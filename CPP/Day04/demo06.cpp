#include <iostream>
using namespace std;

class Employee
{
    int empid;
    string name;
    double salary;

public:
    Employee()
    {
        empid = 0;
        name = "";
        salary = 0;
    }

    Employee(int empid, string name, double salary)
    {
        this->empid = empid;
        this->name = name;
        this->salary = salary;
    }

    void accept()
    {
        cout << "Enter the empid - ";
        cin >> empid;
        cout << "Enter the name - ";
        cin >> name;
        cout << "Enter the salary - ";
        cin >> salary;
    }
    void display()
    {
        cout << "Empid - " << empid << endl;
        cout << "Name - " << name << endl;
        cout << "Salary - " << salary << endl;
    }
};

int main()
{
    Employee **ptr = new Employee *[5];
    // ptr[0]->accept();
    ptr[0] = new Employee(1, "Anil", 10000);
    ptr[1] = new Employee(2, "Mukesh", 20000);
    ptr[2] = new Employee(3, "Ramesh", 30000);
    ptr[3] = new Employee(4, "Suresh", 40000);
    ptr[4] = new Employee(5, "Sham", 50000);

    for (int i = 0; i < 5; i++)
        ptr[i]->display();

    for (int i = 0; i < 5; i++)
    {
        delete ptr[i];
        ptr[i] = NULL;
    }

    delete[] ptr;
    ptr = NULL;
    return 0;
}

int main2()
{
    // Employee e;
    // e.accept();
    // Employee *ptr = new Employee;
    // *ptr.accept();

    Employee *arr[5];
    arr[0] = new Employee();
    arr[0]->accept();
    arr[1] = new Employee(2, "Mukesh", 20000);
    arr[2] = new Employee(3, "Ramesh", 30000);
    arr[3] = new Employee(4, "Suresh", 40000);
    arr[4] = new Employee(5, "Sham", 50000);

    for (int i = 0; i < 5; i++)
        //(*arr[i]).display(); // dereference the pointer using *
        arr[i]->display();

    for (int i = 0; i < 5; i++)
    {
        delete arr[i];
        arr[i] = NULL;
    }

    return 0;
}

int main1()
{
    Employee arr[5];
    // TO-DO write logic for acccept 5 employees

    // arr[2].accept();

    for (int i = 0; i < 5; i++)
        arr[i].display();
    return 0;
}