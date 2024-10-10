#!/bin/bash

# ----------------------------------------
#	Aim : Check given path is file or directory
# ----------------------------------------

# File conditionals - to check conditions with files
#	-e $path	:	true if path exist
#	-f $name	:	true if name is a regular file
#	-d $name	:	true if name is a directory
#	-x $name	:	true if name has execute permission
#	-r $name	:	true if name has read permission
#	-w $name	:	true if name has write permission

echo -n "Enter path : "
read path

if [ -e $path ]
then
	echo "$path is exists"
	if [ -f $path ]
	then
		echo "$path is a regular file"
	else
		echo "$path is a directory"
	fi

else
	echo "$path doesn't exist"
fi
















