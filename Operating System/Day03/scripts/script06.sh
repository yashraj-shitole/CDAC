#!/bin/bash

# ----------------------------------------
#	Aim : Find maximum of two numbers
# ----------------------------------------

echo -n "Enter numbers : "
read num1 num2

max=0

if [ $num1 -gt $num2 ]
then
	echo "num1 is greater"
	max=$num1
else
	echo "num2 is greater"
	max=$num2
fi

echo "Maximum value = $max"




# Relational Operators
#	-eq, -ne, -lt, -gt, -le, -ge

# Logical Operators
#	-a,	-o,	!

#	if  [ condition ]
#	then
#		...
#	fi

#	if  [ condition ]
#	then
#		...
#	else
#		...
#	fi

#	if  [ condition ]
#	then
#		...
#	elif [ condition ]
#	then
#		...
#	else
#		...
#	fi























