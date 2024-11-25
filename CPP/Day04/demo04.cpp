#include <iostream>
using namespace std;

class Circle
{
    int radius;
    static const double PI;

public:
    Circle(int radius)
    {
        this->radius = radius;
    }

    void calculateArea()
    {
        double area = PI * radius * radius;
        cout << "Area of circle = " << area << endl;
    }
};

const double Circle::PI = 3.14;

int main()
{
    Circle c1(5);
    Circle c2(7);
    Circle c3(9);
    c1.calculateArea();
    c2.calculateArea();
    c3.calculateArea();
    return 0;
}