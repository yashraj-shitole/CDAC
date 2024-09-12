#include <iostream>
using namespace std;

int main()
{
    const int n1 = 10;
    const int *const ptr = &n1;
    return 0;
}

int main3()
{
    int n1 = 10;
    const int *ptr = &n1;
    n1 = 20;
    *ptr = 30; // NOT OK
    int n2 = 40;
    ptr = &n2;
    return 0;
}

int main2()
{
    const int n1 = 10;
    const int *ptr = &n1;
    *ptr = 20;
    int n2 = 20;
    ptr = &n2;
    return 0;
}

int main1()
{
    int const n1 = 10;
    // n1 = 20; // NOT OK

    int n2 = 20;
    int n3 = 30;
    int *const ptr = &n2;
    ptr = &n3;
    return 0;
}