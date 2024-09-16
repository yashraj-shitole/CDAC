#include <iostream>
using namespace std;

void division(int n, int d)
{
    if (d == 0)
        throw 2;
    double result = n / d;
    cout << "Division = " << result << endl;
}

void multiply(int n1, int n2)
{
    if (n1 == 0 || n2 == 0)
        throw 2.7;
    int result = n1 * n2;
    cout << "Multiplication = " << result << endl;
}

int main()
{
    try
    {
        division(10, 0);
        multiply(10, 5);
    }
    catch (int ex)
    {
        cout << "Division is not possible..." << endl;
    }
    catch (double ex)
    {
        cout << "Multiplication is not possible..." << endl;
    }
    cout << "Program Finished" << endl;
    return 0;
}