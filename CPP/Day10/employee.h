#ifndef EMPLOYEE_H
#define EMPLOYEE_H
#include <iostream>
using namespace std;

class Employee
{
    int empid;
    string name;
    double salary;

public:
    Employee();
    void accept();
    void display();
};

void saveEmployees();

#endif