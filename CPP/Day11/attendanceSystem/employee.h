#ifndef EMPLOYEE_H
#define EMPLOYEE_H
#include "person.h"
class Employee : public Person
{
    int empid;
    double salary;

public:
    void accept();
    void display();
};
#endif