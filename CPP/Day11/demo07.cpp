#include <iostream>
using namespace std;

void division(int n, int d) noexcept
{
    if (d == 0)
        throw 2;
    cout << "division = " << n / d << endl;
}

void multiply(int n1, int n2) throw(int)
{
    if (n1 == 0 || n2 == 0)
        throw 2.2;
    cout << "multiplication = " << n1 / n2 << endl;
}

int main()
{
    try
    {
        // division(10, 0);
        multiply(0, 5);
    }
    catch (int e)
    {
        cout << "Denominator cannot be 0" << endl;
    }
    catch (double e)
    {
        cout << "Multiplication is not possible" << endl;
    }
    return 0;
}