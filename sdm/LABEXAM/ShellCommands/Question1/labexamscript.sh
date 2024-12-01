#!/bin/bash

fibo(){
        echo Enter number
        read n
	echo -----
        i=0
        a=0
        b=1

	for((i=0 ; i<n ; i++))
	do
		echo $a
             temp=`expr $a + $b`
	     b=$a
	     a=$temp
		
	
	done

	echo -----

}




while true;
do

echo ENTER CHOICE	
read choice

	case $choice in
		1)fibo;;
		2)pwd;;
	esac
	
	
done


