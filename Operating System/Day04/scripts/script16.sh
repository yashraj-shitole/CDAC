#!/bin/bash

# ----------------------------------------
#	Aim : Basic calculator
# ----------------------------------------

# select var in collection
# do
#	...
# done

select choice in Add Sub Mul Div
do
	echo -n "Enter two numbers : "
	read num1 num2

	case $choice in
		Add)
			echo `expr $num1 + $num2`
			;;
		Sub)
			echo `expr $num1 - $num2`
			;;
		Mul)
			echo `expr $num1 \* $num2`
			;;
		Div)
			echo `expr $num1 / $num2`
			;;
	esac
done
















