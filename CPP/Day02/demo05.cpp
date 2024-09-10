#include <iostream>
using namespace std;

namespace NA
{
    int num1 = 10;
    int num2 = 20;
    int num3 = 30;
}

namespace NB
{
    int num1 = 40;
    int num2 = 50;
    int num3 = 60;
}

int main()
{
    cout << "value of num1 from NA = " << NA::num1 << endl;
    cout << "value of num2 from NA = " << NA::num2 << endl;
    cout << "value of num3 from NA = " << NA::num3 << endl;

    cout << "value of num1 from NB = " << NB::num1 << endl;
    cout << "value of num2 from NB = " << NB::num2 << endl;
    cout << "value of num3 from NB = " << NB::num3 << endl;
    return 0;
}