#!/bin/bash

# ----------------------------------------
#	Aim : Check number is prime or not
# ----------------------------------------

echo -n "Enter number : "
read num

i=2

while [ $i -lt $num ]
do
	if [ `expr $num % $i` -eq 0 ]
	then
		echo "Number is not prime"
		break
	fi
	i=`expr $i + 1`					# num = 8 
done								# i = 2

if [ $num -eq $i ]					# num = 7
then								# i = 2, 3, 4, 5, 6, 7
	echo "Number is prime"
fi


















