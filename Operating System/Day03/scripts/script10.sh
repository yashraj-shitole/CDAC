#!/bin/bash

# ----------------------------------------
#	Aim : Print table of given number
# ----------------------------------------

echo -n "Enter number : "
read num

echo "Table of $num : "
i=1							# init
# while [ $i -lt 11 ]			# cond
until [ $i -eq 11 ]			# cond
do
	res=`expr $num \* $i`	# body
	echo $res
	i=`expr $i + 1`			# mod
done






# init
# while [ condition ]
# do
#	body
#	mod
# done

# init
# until [ condition ]
# do
#	body
#	mod
# done




















