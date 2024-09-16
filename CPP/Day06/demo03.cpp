#include <iostream>
using namespace std;

class A
{
public:
    A()
    {
        cout << "A()" << endl;
    }
};

class B : virtual A
{
public:
    B()
    {
        cout << "B()" << endl;
    }
};

class C : virtual A
{
public:
    C()
    {
        cout << "C()" << endl;
    }
};

class D : B, C
{
public:
    D()
    {
        cout << "D()" << endl;
    }
};

int main()
{
    // A a;
    // B b;
    // C c;
    D d;
    return 0;
}