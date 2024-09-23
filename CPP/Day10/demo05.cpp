#include <iostream>
using namespace std;

class Point
{
    int *xptr;
    int *yptr;

public:
    Point()
    {
        xptr = new int(1);
        yptr = new int(1);
    }
    Point(int x, int y)
    {
        xptr = new int;
        *xptr = x;
        yptr = new int(y);
    }
    void displayPoint()
    {
        cout << "Point = (" << *xptr << "," << *yptr << ")" << endl;
    }
    void setY(int y)
    {
        *yptr = y;
    }
};

int main()
{
    Point p1(2, 3); // parameterized
    Point p2;       // parameterless
    p2 = p1;        // Default Assignment operator function -> Shallow copy
    p1.displayPoint();
    p2.displayPoint();
    p2.setY(5);
    cout << "After change in p2 y - " << endl;
    p1.displayPoint();
    p2.displayPoint();
    return 0;
}
