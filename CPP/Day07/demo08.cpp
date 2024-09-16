#include <iostream>
using namespace std;

class Test
{
    const int n1;
    int n2;

public:
    Test() : n1(10)
    {
        n2 = 20;
    }

    void f1() const
    {
        // n1 = 100; // NOT OK-> n1 is const
        n2 = 200; // NOT OK -> function is constant
    }
    void f2()
    {
        // n1 = 100; // NOT OK-> n1 is const
        n2 = 200; // OK
    }
    void f3() const // const Test *const this
    {
        const_cast<Test *const>(this)->n2 = 300;
    }
};

int main()
{

    return 0;
}