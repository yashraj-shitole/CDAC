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

int main()
{
    // varaible t1 of type Time
    Time t1; // object of the class
    Time t2;

    t1.acceptTime(); // acceptTime(&t1)
    t2.acceptTime(); // acceptTime(&t2)

    t1.displayTime(); // displayTime(&t1)
    t2.displayTime(); // displayTime(&t2)
    return 0;
}