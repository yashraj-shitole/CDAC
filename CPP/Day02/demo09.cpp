#include <iostream>
using namespace std;

void multiply(int n1, int n2)
{
    cout << "Multiplication = " << n1 * n2 << endl;
}

void multiply(int n1, int n2, int n3)
{
    cout << "Multiplication = " << n1 * n2 * n3 << endl;
}

void square(int n)
{
    cout << "Square = " << n * n << endl;
}

void square(double n)
{
    cout << "Square = " << n * n << endl;
}

void division(int n1, double n2)
{
    cout << "Division = " << n1 / n2 << endl;
}

void division(double n1, int n2)
{
    cout << "Division = " << n1 / n2 << endl;
}
int main()
{
    multiply(5, 2);
    multiply(5, 3, 2);
    square(5);
    square(5.5);
    division(10, 2.5);
    division(10.6, 2);

    return 0;
}