#include <iostream>
using namespace std;

class Point
{
    int x;
    int y;

public:
    Point()
    {
        cout << "Parameterless" << endl;
        x = 1;
        y = 1;
    }
    Point(int x, int y)
    {
        cout << "Parameterized" << endl;
        this->x = x;
        this->y = y;
    }

    void displayPoint()
    {
        cout << "Point = (" << x << "," << y << ")" << endl;
    }

    void setY(int y)
    {
        this->y = y;
    }
};

int main()
{
    Point p1;       // paramaterless
    Point p2(2, 3); // parameterized
    Point p3 = p2;  // Default Copy Ctor -> Shallow copy

    p2.displayPoint();
    p3.displayPoint();

    p3.setY(5);
    cout << "After change in p3 y value - " << endl;

    p2.displayPoint();
    p3.displayPoint();

    return 0;
}