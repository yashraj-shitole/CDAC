#include <iostream>
using namespace std;

class Point
{
    int x;
    int y;

public:
    Point()
    {
        x = 1;
        y = 1;
    }
    Point(int x, int y)
    {
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
