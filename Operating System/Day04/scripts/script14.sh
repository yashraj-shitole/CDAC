#!/bin/bash

# ----------------------------------------
#	Aim : Count current directory content
# ----------------------------------------

echo "Current working directory : " ; pwd

count=0

for entry in `ls`
do
	if [ -d $entry ]
	then
		continue
	fi
	count=`expr $count + 1`
done

echo "File count : $count"

















