#include <iostream>
using namespace std;

class Point
{
    int xaxis;
    int yaxis;

public:
    // It do not consider the order of data member declarations
    // while initializing in ctor body.
    // Point(int value)
    // {
    //     yaxis = ++value;
    //     xaxis = value;
    // }

    // Construtor members initializer list
    // It considers the order of data member declarations
    // while initializing in ctor members initializer list.
    Point(int value) : yaxis(++value), xaxis(value)
    {
    }

    void display()
    {
        cout << "Point (" << this->xaxis << "," << this->yaxis << ")" << endl;
    }
};

int main()
{
    Point p1(5);
    p1.display();
    t1.hr = 100;
    return 0;
}
