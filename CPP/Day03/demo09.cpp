#include <iostream>
using namespace std;

int main()
{
    // int num1 = 10;
    // cout << num1 << endl;
    int *ptr = new int;
    *ptr = 20;
    cout << "Value at DMA = " << *ptr << endl;
    delete ptr;
    ptr = NULL;
    return 0;
}