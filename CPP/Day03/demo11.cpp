#include <iostream>
using namespace std;
class Point
{
    int *xptr;
    int *yptr;

public:
    Point()
    {
        xptr = new int;
        yptr = new int;
        *xptr = 1;
        *yptr = 1;
    }

    void display()
    {
        cout << "Point(" << *xptr << "," << *yptr << ")" << endl;
    }

    ~Point()
    {
        delete xptr;
        delete yptr;
        xptr = NULL;
        yptr = NULL;
    }
};
int main()
{
    Point p1;
    p1.display();

    return 0;
}