#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
    double val = 12.3456;
    cout << setprecision(2) << fixed << val << endl;
}
int main1()
{
    // int num = 10;
    //  cout << oct << num << endl;
    cout << setw(10) << setfill('$') << "Hello" << endl;
    // cout << setw(10) << setfill('$') << left << "World" << endl;
    cout << setw(10) << setfill('X') << "9388" << endl;
    return 0;
}