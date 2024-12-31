#include <iostream>
using namespace std;
int num3 = 30;

void f1()
{
    int num2 = 20;
    static int num4 = 40;

    class Local
    {
        int num1;
        // static int num2; // NOT OK

    public:
        void f1()
        {
            cout << num1 << endl;
            // cout << num2 << endl; // NOT OK
            cout << num3 << endl;
            cout << num4 << endl;
        }
        static void f2()
        {
            cout << num3 << endl;
            cout << num4 << endl;
        }
    };
    Local l1;
}

int main()
{

    return 0;
}