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

class Car
{
    string name;
    string number;

public:
    Car()
    {
        cout << "Car Paramaterless Ctor" << endl;
        this->name = "";
        this->number = "";
    }
    Car(string name, string number)
    {
        cout << "Car Paramaterized Ctor" << endl;
        this->name = name;
        this->number = number;
    }

    void acceptCar()
    {
        cout << "Enter the name of the car - ";
        cin >> name;
        cout << "Enter the number of the car - ";
        cin >> number;
    }

    void displayCar()
    {
        cout << "Car name - " << name << endl;
        cout << "Car number - " << number << endl;
    }
};

// Employee has-a Doj
// Employee has-a CAR
class Employee
{
    int empid;
    string name;
    double salary;
    Date doj; // Association -> Composition
    Car *car; // Association -> Aggegration

public:
    Employee()
    {
        cout << "Inside Employee Parameterless Ctor" << endl;
        this->empid = 0;
        this->name = "";
        this->salary = 0;
        car = NULL;
    }
    Employee(int empid, string name, double salary, int day, int month, int year)
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
        if (car != NULL)
            car->acceptCar();
    }

    void displayEmployee()
    {
        cout << "Empid - " << empid << endl;
        cout << "Name - " << name << endl;
        cout << "Salary - " << salary << endl;
        cout << "Date of Joining - ";
        doj.displayDate();
        if (car != NULL)
            car->displayCar();
    }
    void setCar(Car *car)
    {
        this->car = car;
    }
};

int main()
{
    Employee e2;
    Car c;
    e2.setCar(&c);
    e2.acceptEmployee();
    e2.displayEmployee();
    return 0;
}

int main1()
{
    Employee e1;
    e1.acceptEmployee();
    e1.displayEmployee();
    return 0;
}