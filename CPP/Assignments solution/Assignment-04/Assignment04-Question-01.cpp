// Q1. Write a class for Time and provide the functionality
// Time()
// Time(int h,int m,int s)
// getHour()
// getMinute()
// getSeconds()
// printTime()
// setHour()
// setMinute()
// setSeconds()
// In main create an array dynamically of Time * of size 5.
// Accept the values and display.

#include <iostream>
using namespace std;

class Time
{

    int hour, minute, second;

public:
    Time()
    {
        hour = 0;
        minute = 0;
        second = 0;
    }
    Time(int h, int m, int s)
    {
        hour = h;
        minute = m;
        second = s;
    }

    // getters - Inspectors
    int getHour()
    {
        return hour;
    }
    int getMinute()
    {
        return minute;
    }
    int getSeconds()
    {
        return second;
    }
    void printTime()
    {
        cout << "Time: " << hour << ":" << minute << ":" << second << endl;
    }

    // setters - Mutators
    void setHour(int h)
    {
        hour = h;
    }
    void setMinute(int m)
    {
        minute = m;
    }
    void setSecond(int s)
    {
        second = s;
    }
};

int main()
{

    int choice;
    Time *arr[5];

      for (int i = 0; i < 5; i++)
    {
        arr[i] = new Time();
    }


    while (1)
    {
        cout << "Enter your choice" << endl;
        cout << "1.Set time" << endl;
        cout << "2.Set Hour" << endl;
        cout << "3.Set Minute" << endl;
        cout << "4.Set Second" << endl;
        cout << "5.Set time of specific object in array" << endl;
        cout << "6.Display time" << endl;
        cout << "7.EXIT" << endl;

        cin >> choice;
        switch (choice)
        {
        case 1:
        { // to set hour minute second
            system("cls");
            int h, m, s;
            for (int i = 0; i < 5; i++)
            {
                cout << "Enter Time" << endl;
                cout << "Enter hour minute second" << endl;
                cin >> h >> m >> s;
                if (h > 24 || m > 60 || s > 60)
                {
                    cout << "Wrong time entered";
                }
                else
                {
                    arr[i]->setHour(h);
                    arr[i]->setMinute(m);
                    arr[i]->setSecond(s);
                }
            }
            break;
        }
        case 2:
        { // to set hour
            system("cls");
            int h;
            for (int i = 0; i < 5; i++)
            {
                cout << "Enter Time" << endl;
                cout << "Enter hour" << endl;
                cin >> h;
                if (h > 24)
                {
                    cout << "Wrong hour entered";
                }
                else
                {
                    arr[i]->setHour(h);
                }
            }
            break;
        }

        case 3:
        { // to set minute
            system("cls");
            int m;
            for (int i = 0; i < 5; i++)
            {
                cout << "Enter Time" << endl;
                cout << "Enter minute" << endl;
                cin >> m;
                if (m > 60)
                {
                    cout << "Wrong minute entered";
                }
                else
                {
                    arr[i]->setMinute(m);
                }
            }
            break;
        }

        case 4:
        { // to set second
            system("cls");
            int s;
            for (int i = 0; i < 5; i++)
            {
                cout << "Enter Time" << endl;
                cout << "Enter second" << endl;
                cin >> s;
                if (s > 60)
                {
                    cout << "Wrong time entered";
                }
                else
                {
                    arr[i]->setSecond(s);
                }
            }
            break;
        }

        case 5:
        { // to change time of specific object
            system("cls");
            for (int i = 0; i < 5; i++)
            {
                cout << i << ") ";
                arr[i]->printTime();
            }

            int i;
            cout << "Enter the number to change time" << endl;
            cin >> i;

            int h, m, s;

            cout << "Enter Time" << endl;
            cout << "Enter hour minute second" << endl;
            cin >> h >> m >> s;
            if (h > 24 || m > 60 || s > 60)
            {
                cout << "Wrong time entered";
            }
            else
            {
                arr[i]->setHour(h);
                arr[i]->setMinute(m);
                arr[i]->setSecond(s);
            }

            break;
        }
        case 6:
        { // to print time in all objects
            system("cls");
            for (int i = 0; i < 5; i++)
            {
                cout << i << ") ";
                arr[i]->printTime();
            }

            break;
        }
        case 7:
        {

            return 0;
        }
        default:
            break;
        }
        cout << endl;
    }

    return 0;
}