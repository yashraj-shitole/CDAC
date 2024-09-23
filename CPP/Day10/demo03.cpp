#include <iostream>
using namespace std;

class Employee
{
    int empid;
    string name;
    double salary;

public:
    friend istream &operator>>(istream &in, Employee &e);
    friend ostream &operator<<(ostream &out, Employee &e);
};

istream &operator>>(istream &in, Employee &e)
{
    cout << "Enter empid - ";
    in >> e.empid;
    cout << "Enter name - ";
    in >> e.name;
    cout << "Enter salary - ";
    in >> e.salary;
    return in;
}

ostream &operator<<(ostream &out, Employee &e)
{
    out << "Empid = " << e.empid << endl;
    out << "Name = " << e.name << endl;
    out << "Salary = " << e.salary << endl;
    return out;
}

int main()
{
    Employee e1;
    cout << "Enter the employee details - " << endl;
    cin >> e1;  //  operator>>(cin,e1);
    cout << e1; // operator<<(cout,e1);
    return 0;
}

int main1()
{
    int n1;
    cout << "Enter the value of n1 - ";
    cin >> n1;
    cout << n1;
    return 0;
}