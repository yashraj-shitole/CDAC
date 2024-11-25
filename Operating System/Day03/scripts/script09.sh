#!/bin/bash

# ----------------------------------------
#	Aim : Take file name from user and 
#			check whether it has execute permissions are not
# ----------------------------------------

echo -n "Enter file path : "
read filepath

if [ -f $filepath -a -x $filepath ]
then
	echo "$filepath is regular executable file"
else
	echo "$filepath is not a regular file or it don't have execute permission" 
fi


















