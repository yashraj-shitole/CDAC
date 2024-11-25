#include <iostream>
using namespace std;

class Point
{
    int x;
    int y;

public:
    Point()
    {
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

    // Overloading the + operator as member function
    Point operator+(Point &p2) /// this-> p1
    {
        Point res;
        res.x = this->x + p2.x;
        res.y = this->y + p2.y;
        return res;
    }
};

int main()
{
    Point p1(2, 3);
    Point p2(3, 4);
    Point res = p1 + p2; // p1.operator+(p2)
    p1.displayPoint();
    p2.displayPoint();
    res.displayPoint();
    return 0;
}

int main1()
{
    int n1 = 10;
    int n2 = 20;
    int res = n1 + n2;
    cout << "Result = " << res << endl;
    return 0;
}