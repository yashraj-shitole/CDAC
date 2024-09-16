#include <iostream>
using namespace std;

class Person
{
    string name;

public:
    void accept()
    {
        cout << "Person::accept()" << endl;
    }
    void display()
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
    Employee *e = static_cast<Employee *>(p);
    e->calculateTax();
    cout << "Program Finished" << endl;
    return 0;
}