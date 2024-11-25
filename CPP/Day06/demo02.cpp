#include <iostream>
using namespace std;
class Base
{
public:
    int num1;
    Base()
    {
        num1 = 10;
        cout << "Base()" << endl;
    }

    ~Base()
    {
        cout << "~Base()" << endl;
    }
};

class Derived : Base
{
public:
    int num2;
    Derived()
    {
        num2 = 20;
        cout << "Derived()" << endl;
    }
    ~Derived()
    {
        cout << "~Derived()" << endl;
    }
};

class IndirectDerived : Derived
{
public:
    IndirectDerived()
    {
        cout << "IndirectDerived()" << endl;
    }
    ~IndirectDerived()
    {
        cout << "~IndirectDerived()" << endl;
    }
};

int main()
{
    // Base b;
    // Derived d;
    IndirectDerived id;
    return 0;
}