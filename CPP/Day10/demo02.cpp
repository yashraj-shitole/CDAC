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
    friend Point operator+(Point &p1, Point &p2);
};

// non member function
Point operator+(Point &p1, Point &p2)
{
    Point res;
    res.x = p1.x + p2.x;
    res.y = p1.y + p2.y;
    return res;
}

class Matrix
{
    int arr[2][3];

public:
    Matrix operator+(Matrix &m2)
    {
        Matrix res;
        res.arr[0][0] = this->arr[0][0] + m2.arr[0][0];
        res.arr[0][1] = this->arr[0][1] + m2.arr[0][1];
        res.arr[0][2] = this->arr[0][2] + m2.arr[0][2];
        res.arr[1][0] = this->arr[1][0] + m2.arr[1][0];
        res.arr[1][1] = this->arr[1][1] + m2.arr[1][1];
        res.arr[1][2] = this->arr[1][2] + m2.arr[1][2];
        return res;
    }
};

int main()
{
    Point p1(2, 3);
    Point p2(3, 4);
    Point res = p1 + p2; // operator+(p1,p2)
    p1.displayPoint();
    p2.displayPoint();
    res.displayPoint();

    Matrix m1;
    Matrix m2;
    Matrix res = m1 + m2;
    return 0;
}
