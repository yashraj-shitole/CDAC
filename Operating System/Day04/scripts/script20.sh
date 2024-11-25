#!/bin/bash

# ----------------------------------------
#	Aim : Find sum and maximum element of array
# ----------------------------------------

arr=(4 2 6 8 5 1)

echo "arr = ${arr[*]}"
echo "length = ${#arr[*]}"

sum=0
i=0
while [ $i -lt ${#arr[*]} ]
do
	sum=`expr $sum + ${arr[$i]}`
	i=`expr $i + 1`
done

echo "Array sum = $sum"

max=${arr[0]}
for ele in ${arr[*]}
do
	if [ $ele -gt $max ]
	then
		max=$ele
	fi
done

echo "Maximum value = $max"

















