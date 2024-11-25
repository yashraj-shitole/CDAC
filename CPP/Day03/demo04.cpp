#include <iostream>
using namespace std;

class Point
{
    int xaxis;
    int yaxis;

public:
    // Constructor Delegation
    Point() : Point(1, 1) {}
    Point(int value) : Point(value, value) {}
    Point(int xaxis, int yaxis)
    {
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
    p2.display();

    Point p3(5);
    p3.display();
    return 0;
}
