#include <iostream>
using namespace std;

typedef enum
{
    EXIT,
    INITDATE,
    ACCEPTDATE,
    PRINTDATE,
    ISLEAPYEAR
} menu;

int menuChoice()
{
    int choice;
    cout<<"\n****Menu****";
    cout << "\n0. Exit";
    cout << "\n1. Init Date";
    cout << "\n2. Accept Date";
    cout << "\n3. Print Date";
    cout << "\n4. Is Leap Year";
    cout << "\nEnter your choice: ";
    cin >> choice;
    return choice;
}

struct Date
{
private:
    int day;
    int month;
    int year;

public:
    void initDate()
    {
        this->day = 1;
        this->month = 1;
        this->year = 1990;
    }

    bool isLeapYear(int year)
    {
        if ((year % 4 == 0) && ((year % 400 == 0) || (year % 100) != 0))
            return true;
        else
            return false;
    }

    void acceptDate()
    {
        if (day > 0 && day <= 31)
        {
            cout << "\nEnter the day : ";
            cin >> day;

            cout << "\nEnter the month : ";
            cin >> month;

            cout << "\nEnter the year : ";
            cin >> year;
        }
        else
        {
            cout << "\nEnter valid date !!!!";
        }
    }

    void printDate()
    {
        cout << "\nDate: " << day << "/" << month << "/" << year;
    }
};  // struct Date ends here

int main()
{
    Date d1;
    int year, y, mchoice;

    while ((mchoice = menuChoice()) != 0)
    {
        switch (mchoice)
        {
        case EXIT:
        {
            cout << "\nEnd of program";
        }
        break;

        case INITDATE:
        {
            d1.initDate();
            d1.printDate();
        }
        break;

        case ACCEPTDATE:
        {
            d1.acceptDate();
        }
        break;

        case PRINTDATE:
        {
            d1.printDate();
        }
        break;

        case ISLEAPYEAR:
        {
            cout << "\nEnter the year: ";
            cin >> year;
            y = d1.isLeapYear(year);
            if (y)
                cout << year << " is leap year";
            else
                cout << year << " is not leap year";
        }
        break;

        default:
            cout << "\nInvalid choice !!!!";
            break;
        } // switch
    }   // while
}