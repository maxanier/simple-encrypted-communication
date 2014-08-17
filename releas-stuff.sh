#!/bin/sh

commsg=$(git show -s --format=%s $(printenv GIT_COMMIT))
echo "Commit message: " $commsg

c=${commsg%#release}
if ["${c}" =="${commsg}"]; then
	echo "Commit does not include \#release"
    exit
fi

origin=https://github.com/${2}/${3}
echo "Origin url: " $origin
lasttag=$(git describe --abbrev=0 --tags)
echo "Last tag: " $lasttag
changelog=$(git log ${lasttag}..  --pretty=format:'<li> <a href="'${origin}'/commit/%H">view commit </a> &bull; %s</li> ' --reverse | grep "#changelog")
changelogfile=changelog.html
echo $changelog > $changelogfile
echo "Version:" $1 
API_JSON=$(printf '{"tag_name": "v%s","target_commitish": "master","name": "v%s","body": "Release of version %s","draft": false,"prerelease": false}' $1 $1 $1)
token=$(printenv TOKEN)
curl --data "$API_JSON" https://api.github.com/repos/${2}/${3}/releases?access_token=${token}
echo $API_JSON