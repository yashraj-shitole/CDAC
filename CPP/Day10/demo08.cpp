#include <iostream>
using namespace std;

class Time
{
    int hr;
    int min;

public:
    Time()
    {
        cout << "Parameterless ctor" << endl;
        hr = 10;
        min = 10;
    }
    Time(int mins)
    {
        cout << "Single Parameterized ctor" << endl;
        hr = mins / 60;
        min = mins % 60;
    }
    Time(int hr, int min)
    {
        cout << "Parameterized ctor" << endl;
        this->hr = hr;
        this->min = min;
    }
    Time(Time &t)
    {
        cout << "Copy ctor" << endl;
    }
    void operator()()
    {
        cout << "Time = " << hr << " : " << min << endl;
    }
    // conversion function
    operator int()
    {
        int mins = hr * 60 + min;
        return mins;
    }
};

void f1()
{
}

// int main()
// {
//     Time t1(2, 30);
//     int mins = t1();
//     return 0;
// }

int main4()
{
    Time t1(2, 30); // Paramaterized
    int mins = t1;  // conversion function
    cout << "mins = " << mins << endl;
    return 0;
}

int main3()
{
    Time t1;  // paramaterless
    t1 = 140; // conversion function
    // Time = int
    return 0;
}

int main2()
{
    Time t1;         // paramaterless ctor
    Time t2(10, 20); // parameterized ctor
    Time t3(130);    // singe parameterized ctor
    Time t4 = t3;    // copy ctor
    return 0;
}

int main1()
{
    Time t1(10, 30);
    // t1.display();
    // cout << t1;
    t1(); // to have the behaviour of object as a function
    // f1();
    return 0;
}
