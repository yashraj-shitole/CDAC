#!/bin/bash

# ----------------------------------------
#	Aim : Find area of reactangle 
# ----------------------------------------

echo -n "Enter length and bredth of reactanlge : "
read le br

# command substitution
#	- result of command is replaced/substituted at the place of command
#	- this can be done by two ways
#		1. `command`
#		2. $(command)

area=`expr $le \* $br`

echo "Area of reactangle : $area"


















