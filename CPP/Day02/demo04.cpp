#include <iostream>
using namespace std;

// global namespace
int num1 = 10;

namespace NA
{
    int num1 = 30;
}

int main()
{
    int num1 = 20;
    cout << "Value of local num1 = " << num1 << endl;
    cout << "Value of global num1 = " << ::num1 << endl;
    cout << "Value of NA namespace num1 = " << NA::num1;

    return 0;
}