#include <iostream>
using namespace std;

class Base
{
public:
    void f1()
    {
        cout << "Base::f1()" << endl;
    }

    void f2()
    {
        cout << "Base::f2()" << endl;
    }
};

class Derived : public Base
{
public:
    // function overriding
    void f2()
    {
        cout << "Derived:::f2()" << endl;
    }
    void f3()
    {
        cout << "Derived::f3()" << endl;
    }
};

int main()
{
    Base *bptr = new Derived; // upcasting
    bptr->f2();               // Early Binding

    // Derived *dptr = (Derived *)bptr; // Downcasting
    return 0;
}

int main1()
{
    // Base b;
    // b.f1();
    // b.f2();

    Derived d;
    d.f1();
    d.f2();
    d.f3();

    return 0;
}