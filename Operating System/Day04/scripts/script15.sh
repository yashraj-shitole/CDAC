#!/bin/bash

# ----------------------------------------
#	Aim : Implement Basic calculator
# ----------------------------------------

# case $var in
# 1|one|4)
#	...
#	;;
# 2)
#	...
#	;;
# *)
#	...
#	;;
# esac






echo -e "1. Add\n2. Sub\n3. Div\n4. Mul"
echo -n "Which operation you want to perform : "
read choice

echo -n "Enter two operands : "
read op1 op2

case $choice in
	1)
		res=`expr $op1 + $op2`
		echo "$op1 + $op2 = $res"
		;;

	2)
		res=`expr $op1 - $op2`
		echo "$op1 - $op2 = $res"
		;;

	3)
		if [ $op2 -ne 0 ]
		then
			res=`expr $op1 / $op2`
			echo "$op1 / $op2 = $res"
		fi
		;;

	4)
		res=`expr $op1 \* $op2`
		echo "$op1 * $op2 = $res"
		;;

	*)
		echo "Invalid operation"
		;;
esac











