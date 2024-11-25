#include <iostream>
using namespace std;

class InvalidDateException
{
    string message;

public:
    InvalidDateException()
    {
        this->message = " ";
    }

    InvalidDateException(string message)
    {
        this->message = message;
    }

    void printStackTrace()
    {
        cout << "Exception : InvalidDateException" << endl;
        cout << "Message : " << message << endl;
    }
};

class Date
{
    int day;
    int month;
    int year;

public:
    Date()
    {
        day = 1;
        month = 1;
        year = 2000;
    }

    void setDay(int day)
    {
        if (day <= 0 || day > 31)
            throw InvalidDateException();
        this->day = day;
    }
    void setMonth(int month)
    {
        if (month <= 0 || month > 12)
            throw InvalidDateException("month should be between 1 to 12");
        this->month = month;
    }
    void setYear(int year)
    {
        if (year < 2000 || year > 2050)
            throw InvalidDateException("Invalid Year");
        this->year = year;
    }

    void displayDate()
    {
        cout << "Date - " << day << "/" << month << "/" << year << endl;
    }
};

int main()
{
    try
    {
        Date d1;
        d1.setDay(3);
        d1.setMonth(10);
        d1.setYear(2024);
        d1.displayDate();
    }
    catch (InvalidDateException e)
    {
        e.printStackTrace();
    }
    return 0;
}