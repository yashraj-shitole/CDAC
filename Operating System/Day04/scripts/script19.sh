#!/bin/bash

# ----------------------------------------
#	Aim : Array 
# ----------------------------------------

# array declartion
#	declare -a arr
#	arr=(10 20 30 40 50)

# ${arr[*]} - all elements of the array --> "10 20 30 40 50"
# ${arr[@]} - all elements of the array --> "10" "20" "30" "40" "50"
# ${arr[$i]} - ith element of the array
# ${#arr[*]} - length of the array
# ${#arr[@]} - length of the array
# ${#arr[$i]} - length of ith element of the array
# arr[$i]=value - value is added at ith index of the array
# unset arr[$i] - delete/remove ith element of the array
# ${arr[*]:n} - elements from nth index 
# ${arr[*]:m:n} - n elements from mth index 

arr=(10 20 30 40 50)

echo "arr = ${arr[*]}"
echo "length = ${#arr[*]}"

echo "elements from 2nd index = ${arr[*]:2}"
echo "2 elements from 1nd index = ${arr[*]:1:2}"

unset arr[2]

echo "arr = ${arr[*]}"












