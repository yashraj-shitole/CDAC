#include <iostream>
using namespace std;
class Point
{
    int xaxis;
    int yaxis;

public:
    Point()
    {
        xaxis = 1;
        yaxis = 1;
    }

    void display()
    {
        cout << "Point(" << xaxis << "," << yaxis << ")" << endl;
    }
};
int main()
{
    // Point p1;
    Point *ptr = new Point;
    ptr->display();
    delete ptr;
    ptr = NULL;
    return 0;
}