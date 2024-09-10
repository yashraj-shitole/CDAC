#include <iostream>
using namespace std;

namespace NA
{
    int num1 = 10;
    int num2 = 20;
    int num3 = 30;

    void f1()
    {
        cout << "f1()" << endl;
    }

    void f2()
    {
        cout << "f2()" << endl;
    }

    class Time
    {
        int hr;
        int min;
    };

    namespace NB
    {
        int num1;
    }
}

void f1()
{
    cout << NB::num1;
}

int main1()
{
    cout << "value of num1 from NA = " << NA::num1 << endl;
    cout << "value of num2 from NA = " << NA::num2 << endl;
    cout << "value of num3 from NA = " << NA::num3 << endl;
    NA::f1();
    NA::f2();
    NA::Time t1;
    return 0;
}
using namespace NA;
int main()
{
    cout << "value of num1 from NA = " << num1 << endl;
    cout << "value of num2 from NA = " << num2 << endl;
    cout << "value of num3 from NA = " << num3 << endl;
    NA::f1();
    f2();
    Time t1;
    cout << NB::num1 << endl;
    return 0;
}