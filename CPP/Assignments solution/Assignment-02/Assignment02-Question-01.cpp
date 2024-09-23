#include <iostream>
using namespace std;

struct Date
{
    int day, month, year;

    void initDate()
    {
        day = 10;
        month = 9;
        year = 2024;
    }

    void printDateOnConsole()
    {
        cout << "Date: " << day << "/" << month << "/" << year << endl;
    }

    void acceptDateFromConsole()
    {
        cout << "Enter day: ";
        cin >> day;
        cout << "Enter month: ";
        cin >> month;
        cout << "Enter year: ";
        cin >> year;
    }

    bool isLeapYear()
    {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
            return true;
        return false;
    }
};

int main()
{
    Date date;
    int choice;

    while (1)
    {
        cout << "\nMenu (Structure):\n";
        cout << "1. Initialize Date\n";
        cout << "2. Accept Date from Console\n";
        cout << "3. Print Date\n";
        cout << "4. Check Leap Year\n";
        cout << "5. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice)
        {
        case 1:
            date.initDate();
            cout << "Date initialized.\n";
            break;
        case 2:
            date.acceptDateFromConsole();
            break;
        case 3:
            date.printDateOnConsole();
            break;
        case 4:
            if (date.isLeapYear())
                cout << date.year << " is a leap year.\n";
            else
                cout << date.year << " is not a leap year.\n";
            break;
        case 5:
            return 0;
        default:
            cout << "Invalid choice!\n";
        }
    }
    return 0;
}
