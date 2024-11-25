#!/bin/bash

# ----------------------------------------
#	Aim : Print table of given number
# ----------------------------------------


echo -n "Enter number : "
read num

echo "Table of $num : "
# for(( i=1 ; i <= 10 ; i++ ))
# for i in 1 2 3 4 5 6 7 8 9 10
for i in `seq 10`
do
	res=`expr $num \* $i`
	echo $res
done


# C style 
# for(( init ; cond ; mod ))
# do
#	...
# done

# for each
# for var in collection
# do
#	...
# done

























