#include <iostream>
using namespace std;

class Time
{
    int hrs;
    int mins;

public:
    void acceptTime() // Time *const this
    {
        cout << "Enter hrs and mins - ";
        cin >> this->hrs >> mins;
    }

    void displayTime()
    {
        cout << "Time - " << hrs << " : " << this->mins << endl;
    }
};

int menu()
{
    int choice;
    cout << "0. EXIT" << endl;
    cout << "1. ADD TIME" << endl;
    cout << "2. DISPLAY TIME" << endl;
    cout << "Enter your choice - ";
    cin >> choice;
    return choice;
}

int main()
{
    int choice;
    Time t1;
    while ((choice = menu()) != 0)
    {
        switch (choice)
        {
        case 1:
            t1.acceptTime();
            break;
        case 2:
            t1.displayTime();
            break;
        default:
            cout << "Wrong Choice..." << endl;
            break;
        }
    }
    return 0;
}