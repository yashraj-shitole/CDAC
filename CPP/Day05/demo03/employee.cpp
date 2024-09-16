#include "employee.h"

Employee::Employee()
{
}

Employee::Employee(int empid, string name, double salary)
{
    this->empid = empid;
    this->name = name;
    this->salary = salary;
}

void Employee::acceptEmployee()
{
    cout << "Enter the empid - ";
    cin >> empid;
    cout << "Enter the name - ";
    cin >> name;
    cout << "Enter the salary - ";
    cin >> salary;
}

void Employee::displayEmployee()
{
    cout << "Empid = " << empid << endl;
    cout << "Name = " << name << endl;
    cout << "Salary = " << salary << endl;
}
