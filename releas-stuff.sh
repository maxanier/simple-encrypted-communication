#!/bin/sh

commsg=$(git show -s --format=%s $(printenv GIT_COMMIT))
echo "Commit message: " $commsg
 
if [[ "${commsg}" != *\#release* ]]; then
	echo "Commit does not include \#release"
    exit
fi

origin=$(git config --get remote.origin.url)
origin=${origin%.git}
echo "Origin url: " $origin
lasttag=$(git describe --abbrev=0 --tags)
echo "Last tag: "+lasttag
changelog=$(git log ${lasttag}..  --pretty=format:'<li> <a href="'${origin}'/commit/%H">view commit </a> &bull; %s</li> ' --reverse )
changelogfile=build/changelog.html
echo $changelog > $changelogfile

API_JSON=$(printf '{"tag_name": "v%s","target_commitish": "master","name": "v%s","body": "Release of version %s","draft": false,"prerelease": false}' $VERSION $VERSION $VERSION)
owner="maxanier"
repo="MinecraftSecondScreenMod"
token="e3a447b30d370af965e0056242175703ea9ce15e"
curl --data "$API_JSON" https://api.github.com/repos/${owner}/${repo}/releases?access_token=${token}
echo $API_JSON
read -p "wait"
