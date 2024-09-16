#include <iostream>
using namespace std;
class Person
{
    string name;

public:
    Person()
    {
        cout << "Person()" << endl;
    }
    Person(string name)
    {
        cout << "Person(string)" << endl;
        this->name = name;
    }
    virtual void accept()
    {
        cout << "Enter the name - ";
        cin >> name;
    }
    virtual void display()
    {
        cout << "Name - " << name << endl;
    }
};

class Employee : public Person
{
    int empid;
    double salary;

public:
    Employee()
    {
        cout << "Employee()" << endl;
    }
    Employee(int empid, string name, double salary) : Person(name)
    {
        cout << "Employee(int,string,double)" << endl;
        this->empid = empid;
        this->salary = salary;
        // this->name = name; // can perform  if data member is protected
    }
    void accept()
    {
        cout << "Enter empid - ";
        cin >> empid;
        Person::accept();
        cout << "Enter Salary - ";
        cin >> salary;
    }

    void display()
    {
        cout << "Empid -  " << empid << endl;
        Person::display();
        cout << "Salary -  " << salary << endl;
    }
};

class Student : public Person
{
    int rollno;
    double marks;

public:
    Student()
    {
    }
    Student(int rollno, string name, double marks) : Person(name)
    {
        this->rollno = rollno;
        this->marks = marks;
    }
    void accept()
    {
        cout << "Enter rollno - ";
        cin >> rollno;
        Person::accept();
        cout << "Enter marks - ";
        cin >> marks;
    }
    void display()
    {
        cout << "Rollno - " << rollno << endl;
        Person::display();
        cout << "Marks - " << marks << endl;
    }
};

int main()
{
    Person *arr[5];
    arr[0] = new Employee(1, "Anil", 10000);
    arr[1] = new Student(1, "Mukesh", 50);
    arr[2] = new Employee(2, "Ramesh", 20000);
    arr[3] = new Student(2, "Suresh", 60);
    arr[4] = new Employee(3, "Sham", 30000);

    // display Employees only
    for (int i = 0; i < 5; i++)
        if (typeid(*arr[i]) == typeid(Employee))
            arr[i]->display();
    return 0;
}

void checkDetails(Person *p)
{
    cout << "Type of p - " << typeid(p).name() << endl;
    cout << "Type of *p - " << typeid(*p).name() << endl;
}

int main2()
{
    checkDetails(new Student);
    return 0;
}

int main1()
{
    // Employee e1;
    // e1.accept();
    // e1.display();
    // Person *p = new Employee; // upcasting
    Person *p = new Student; // upcasting
    p->accept();
    p->display();
    return 0;
}