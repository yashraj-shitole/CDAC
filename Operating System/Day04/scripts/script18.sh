#!/bin/bash

# ----------------------------------------
#	Aim : Function
# ----------------------------------------

# function keyword is used to define a function
#	eg function name
# we can use '()' to define a function, in this case writing function keyword is optional
#	eg name()
# body of function (set of instructions) is written into '{}'

# function definition/declaration
function print_msg
{
	echo "This is print_msg function"
}

function print_values
{
	# parameters(args) are accesses like $1, $2, $3, ....
	echo "1st parameter : $1"
	echo "2nd parameter : $2"
	echo "3rd parameter : $3"
}

addition()
{
	# op1 --> $1
	# op2 --> $2
	res=`expr $1 + $2`
	echo $res
}

echo "This is main script"
print_msg			# function call
print_values 20 3.142 sunbeam

a=30
b=50
sum=`addition $a $b`
echo "$a + $b = $sum"

















