#include <iostream>
using namespace std;

class Person
{
    string name;

public:
    virtual void accept()
    {
        cout << "Person::accept()" << endl;
    }
    virtual void display()
    {
        cout << "Person::display()" << endl;
    }
};

class Employee : public Person
{
    int id;
    double salary;

public:
    void accept()
    {
        cout << "Employee::accept()" << endl;
    }
    void display()
    {
        cout << "Employee::display()" << endl;
    }
    void calculateTax()
    {
        cout << "Employee::calculateTax()" << endl;
    }
};

class Student : public Person
{
    int rollno;
    double marks;

public:
    void accept()
    {
        cout << "Student::accept()" << endl;
    }
    void display()
    {
        cout << "Student::display()" << endl;
    }
    void calculatePercentage()
    {
        cout << "Student::calculatePercentage()" << endl;
    }
};

int main()
{
    Person *p = new Student;
    p->accept();
    p->display();
    Employee *e = dynamic_cast<Employee *>(p);
    if (e != NULL)
        e->calculateTax();
    else
        cout << "Downcasting is not possible ..." << endl;
    cout << "Program Finished" << endl;
    return 0;
}