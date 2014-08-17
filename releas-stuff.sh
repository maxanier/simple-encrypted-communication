#!/bin/bash
#Arguments: 1:Githubowner 2:Github repository name. Same as in url
#Environment variable token:Github api token
#Get commit message
commsg=$(git show -s --format=%s $(printenv GIT_COMMIT))
echo "Commit message: " $commsg

#Get lasttag
origin=https://github.com/${1}/${2}
echo "Origin url: " $origin
lasttag=$(git describe --abbrev=0 --tags)
echo "Last tag: " $lasttag

#Get mainversion:
ver=${lasttag%v}
echo "Ver: "+$ver
IFS=. major minor build <<<"${lasttag%v}"
echo "Version: "$major"."$minor

r="#release"
if [[ $commsg != *"$r"* ]]; then
	echo "Commit does not include #release"
    exit
fi


#Generate Changelog
changelog=$(git log ${lasttag}..  --pretty=format:'<li> <a href="'${origin}'/commit/%H">view commit </a> &bull; %s</li> ' --reverse | grep "#changelog")
changelogfile=changelog.html
echo $changelog > $changelogfile

#Create release
API_JSON=$(printf '{"tag_name": "v%s","target_commitish": "master","name": "v%s","body": "Release of version %s","draft": false,"prerelease": false}' $1 $1 $1)
token=$(printenv TOKEN)
curl --data "$API_JSON" https://api.github.com/repos/${1}/${2}/releases?access_token=${token}