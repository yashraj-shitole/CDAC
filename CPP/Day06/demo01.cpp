#include <iostream>
using namespace std;

class Date
{
    int day;
    int month;
    int year;

public:
    Date()
    {
        cout << "Date()" << endl;
        this->day = 0;
        this->month = 0;
        this->year = 0;
    }
    Date(int day, int month, int year)
    {
        cout << "Date(int,int,int)" << endl;
        this->day = day;
        this->month = month;
        this->year = year;
    }
    void acceptDate()
    {
        cout << "Enter day, month and year - ";
        cin >> day >> month >> year;
    }
    void displayDate()
    {
        cout << day << "/" << month << "/" << year << endl;
    }
};

// Employee has-a Doj

class Employee
{
    int empid;
    string name;
    double salary;
    Date doj;  // object Composition
    Date *dob; // Pointer Aggegration

public:
    Employee()
    {
        cout << "Employee()" << endl;
        this->empid = 0;
        this->name = "";
        this->salary = 0;
        dob = NULL;
    }

    Employee(int empid, string name, double salary, int day, int month, int year) : doj(day, month, year)
    {
        cout << "Employee(int,string,double,int,int,int)" << endl;
        this->empid = empid;
        this->name = name;
        this->salary = salary;
        dob = NULL;
    }

    void acceptEmployee()
    {
        cout << "Enter the empid - ";
        cin >> empid;
        cout << "Enter the name - ";
        cin >> name;
        cout << "Enter the salary - ";
        cin >> salary;
        doj.acceptDate();
    }

    void displayEmployee()
    {
        cout << "Empid - " << empid << endl;
        cout << "Name - " << name << endl;
        cout << "Salary - " << salary << endl;
        cout << "Date of joining - ";
        doj.displayDate();
        if (dob != NULL)
        {
            cout << "Date of Birth - ";
            dob->displayDate();
        }
    }

    void acceptDateofBirth()
    {
        // not to perform
        // Date d;
        // dob = &d;
        dob = new Date();
        cout << "Enter the Date of birth -";
        dob->acceptDate();
    }

    ~Employee()
    {
        if (dob != NULL)
        {
            delete dob;
            dob = NULL;
        }
    }
};

int main()
{
    Employee e1;
    e1.acceptEmployee();
    e1.acceptDateofBirth();
    e1.displayEmployee();

    Employee e2(1, "Anil", 10000, 1, 1, 2001);
    e2.displayEmployee();
    return 0;
}