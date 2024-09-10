#include <iostream>
using namespace std;
// Default Argument Function
void multiply(int n1, int n2, int n3 = 1, int n4 = 1)
{
    cout << "Multiplication = " << n1 * n2 * n3 * n4 << endl;
}

int main()
{
    multiply(2, 3, 4, 5);
    multiply(2, 3, 4);
    multiply(2, 3);
    return 0;
}