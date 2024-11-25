#include <iostream>
using namespace std;

class Test
{
private:
    int n1;
    static int n2;

public:
    friend void f1();
};

void f1()
{
    Test t1;
    cout << t1.n1 << Test::n2 << endl;
}

class Base
{
private:
    int n1;
    int n2;
    int n3;

public:
    friend class Derived;
};

class Derived : public Base
{
public:
    void printDerived()
    {
        cout << n1 << n2 << n3 << endl;
    }
};

int main()
{

    return 0;
}