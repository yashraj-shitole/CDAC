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

    // Single parameterized Constructor
    Point(int value)
    {
        cout << "Inside Single Parameterized Ctor" << endl;
        xaxis = value;
        yaxis = value;
    }

    // Parameterized Constructor
    Point(int x, int y)
    {
        cout << "Inside Parameterized Ctor" << endl;
        xaxis = x;
        yaxis = y;
    }

    void init()
    {
        cout << "Init called" << endl;
        xaxis = 1;
        yaxis = 1;
    }
    void display()
    {
        cout << "Point (" << xaxis << "," << yaxis << ")" << endl;
    }
};

int main()
{
    Point p1;
    p1.display();
    Point p2;
    p2.display();
    Point p3(2, 3);
    p3.display();
    Point p4(4, 5);
    p4.display();
    Point p5(3);
    p5.display();

    return 0;
}

int main1()
{
    // int n1 = 10;// Initialization;
    // int n2;
    // n2 = 20; // Assignment
    Point p1;
    p1.init();
    Point p2;
    p2.init();
    Point p3;
    p3.init();
    p1.display();
    p2.display();
    p3.display();
    return 0;
}