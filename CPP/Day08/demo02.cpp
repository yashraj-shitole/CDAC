#include <iostream>
using namespace std;

template <class X, class Y>
class Point
{
    X xaxis;
    Y yaxis;

public:
    Point(X xaxis, Y yaxis)
    {
        this->xaxis = xaxis;
        this->yaxis = yaxis;
    }

    void displayPoint()
    {
        cout << "Point = (" << xaxis << ", " << yaxis << ")" << endl;
    }
};

int main()
{
    Point<int, int> p1(2, 3);
    p1.displayPoint();

    Point<double, double> p2(1.5, 3.6);
    p2.displayPoint();

    Point<char, int> p3('A', 70);
    p3.displayPoint();
    return 0;
}