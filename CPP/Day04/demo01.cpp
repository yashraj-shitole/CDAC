#include <iostream>
using namespace std;

void changeValueofNum1(int &n)
{
    n = 20;
}

// void changeValueofNum1(int n)
// {
//     n = 20;
// }

// void changeValueofNum1(int *n)
// {
//     *n = 20;
// }

int main()
{
    int num1 = 10;
    int num2 = 20;
    int &ref = num1;
    //&ref = num2; // NO such syntax
    // the referent of the reference cannot be
    // changed once initialized
    ref = num2; // value of num2 is copied in num1

    // int &r = new int; // NOT ALLOWED
    return 0;
}

int main1()
{
    int num1 = 10;
    cout << "Before change Value of num1 = " << num1 << endl;
    // changeValueofNum1(num1); // pass by value
    // changeValueofNum1(&num1); // pass by address
    changeValueofNum1(num1); // pass by reference
    cout << "After change Value of num1 = " << num1 << endl;

    return 0;
}