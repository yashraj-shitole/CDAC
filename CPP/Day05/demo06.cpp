#include <iostream>
using namespace std;
class Base
{
    int num1;
};

class Derived : Base
{
    int num2;
};

int main()
{
    Base b1;
    cout << "size of b1 =  " << sizeof(b1) << endl;
    Derived d1;
    cout << "size of d1 =  " << sizeof(d1) << endl;

    return 0;
}