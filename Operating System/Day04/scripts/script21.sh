#!/bin/bash

# ----------------------------------------
#	Aim : Automation for Package installation
# ----------------------------------------

pkgs=("vim" "ncal" "gcc" "rename")

echo "Updating package list !!!"

sudo apt-get update
if [ $? -ne 0 ]
then 
	echo "Package list is not updated"
	exit
fi

echo "Package list is updated !!!"

echo "Installing packages from list !!!"
i=0
while [ $i -lt ${#pkgs[*]} ]
do
	sudo apt-get install ${pkgs[$i]}
	if [ $? -eq 0 ]
	then
		echo "${pkgs[$i]} is installed successfully"
	else
		echo "${pkgs[$i]} is not installed"
	fi
	i=`expr $i + 1`
done



















