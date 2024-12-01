#!/bin/bash

echo WELCOME TO CALCULATOR

add(){
 echo Enter two numbers
 read num1
 read num2
 ans=$((num1 + num2))
 echo $num1 + $num2 = $ans
}

sub(){

	echo Enter two numbers
	read nun1
	read num2
	ans=$((num1 - num2))
	echo $num1 - $num2 = $ans
}

mul(){
echo Enter two numbers
read num1
read num2
ans=$((num1 * num2))
echo $num1 * $num2 = $ans
}


while true;do
echo 1=To add numbers
echo 2=To sub numbers
echo 3=To mul numbers
echo Enter choice

read choice

case $choice in 
	1)add;;
	2)sub;;
	3)mul;;
	*)echo Wrong choice 
esac

done

