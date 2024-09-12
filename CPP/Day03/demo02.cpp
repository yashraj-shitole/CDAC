#include <iostream>
using namespace std;

class Point
{
    int xaxis;
    int yaxis;

public:
    // Parameterless Constructor
    Point()
    {
        cout << "Inside Parameterless Ctor" << endl;
        xaxis = 1;
        yaxis = 1;
    }

    // Parameterized Constructor
    Point(int xaxis, int yaxis)
    {
        cout << "Inside Parameterized Ctor" << endl;
        this->xaxis = xaxis;
        this->yaxis = yaxis;
    }

    void display()
    {
        cout << "Point (" << xaxis << "," << yaxis << ")" << endl;
    }
};

int main()
{
    Point p1(2, 3);
    p1.display();

    Point p2;
    return 0;
}
