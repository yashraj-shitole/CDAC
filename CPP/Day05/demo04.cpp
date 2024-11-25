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
        cout << "Inside Date Parameterless Ctor" << endl;
        this->day = 0;
        this->month = 0;
        this->year = 0;
    }
    Date(int day, int month, int year)
    {
        cout << "Inside Date Parameterized Ctor" << endl;
        this->day = day;
        this->month = month;
        this->year = year;
    }

    void setDay(int day)
    {
        this->day = day;
    }

    void setMonth(int month)
    {
        this->month = month;
    }

    void setYear(int year)
    {
        this->year = year;
    }

    void acceptDate()
    {
        cout << "Enter the day, month and year - ";
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
    Date doj; // Association -> Composition

public:
    Employee()
    {
        cout << "Inside Employee Parameterless Ctor" << endl;
        this->empid = 0;
        this->name = "";
        this->salary = 0;
    }
    Employee(int empid, string name, double salary, int day, int month, int year) : doj(day, month, year)
    {
        this->empid = empid;
        this->name = name;
        this->salary = salary;
        this->doj.setDay(day);
        this->doj.setMonth(month);
        this->doj.setYear(year);
    }

    void acceptEmployee()
    {
        cout << "Enter the empid - ";
        cin >> empid;
        cout << "Enter the name - ";
        cin >> name;
        cout << "Enter the salary - ";
        cin >> salary;
        cout << "Enter the Date of joining - " << endl;
        doj.acceptDate();
    }

    void displayEmployee()
    {
        cout << "Empid - " << empid << endl;
        cout << "Name - " << name << endl;
        cout << "Salary - " << salary << endl;
        cout << "Date of Joining - ";
        doj.displayDate();
    }
};

int main()
{
    Employee e1;
    e1.acceptEmployee();
    Employee e2(1, "anil", 10000, 1, 1, 2001);
    e1.displayEmployee();
    e2.displayEmployee();
    return 0;
}