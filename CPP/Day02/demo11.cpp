#include <iostream>
using namespace std;

class Time
{

    int hrs;
    int mins;

public:
    // Mutators
    void setHrs(int h)
    {
        hrs = h;
    }
    // Inspector
    int getHrs()
    {
        return hrs;
    }

    // Mutator -> Setters
    void setMins(int m)
    {
        mins = m;
    }

    // Inspector -> Getters
    int getMin()
    {
        return mins;
    }

    // facilitator
    void accept()
    {
        cout << "Enter hrs and mins = ";
        cin >> hrs >> mins;
    }

    // facilitator
    void display()
    {
        cout << "Time = " << hrs << " : " << mins << endl;
    }
};

int main()
{
    Time t1;
    // t1.hrs = 10; // write
    t1.setHrs(10);
    // cout << t1.hrs << endl; // read
    cout << t1.getHrs() << endl;
    return 0;
}