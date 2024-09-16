#include <iostream>
using namespace std;

class Base
{
private:
    int num1;

protected:
    int num2;

public:
    int num3;

    void displayBase()
    {
        cout << num1 << num2 << num3 << endl;
    }
};

// Default mode of inheritance is private
class Derived : public Base
{
public:
    void displayDerived()
    {
        cout << num1 << num2 << num3;
    }
};

class IndirectDerived : Derived
{
public:
    void displayIndirect()
    {
        cout << num1 << num2 << num3 << endl;
    }
};

int main()
{
    Base b;
    cout << b.num1 << b.num2 << b.num3;

    Derived d;
    cout << d.num1 << d.num2 << d.num3 << endl;
}