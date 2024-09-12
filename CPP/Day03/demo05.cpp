#include <iostream>
using namespace std;

class Point
{
    int xaxis;
    int yaxis;

public:
    Point(int xaxis, int yaxis)
    {
        cout << "Inside Ctor" << endl;
        this->xaxis = xaxis;
        this->yaxis = yaxis;
        display();
    }

    void display()
    {
        cout << "Point (" << xaxis << "," << yaxis << ")" << endl;
    }

    // Destructor
    ~Point()
    {
        cout << "Inside Dtor" << endl;
        display();
    }
};

int main()
{
    Point p1(2, 3);
    Point p2(4, 5);

    return 0;
}
