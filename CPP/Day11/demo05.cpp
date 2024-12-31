#include <iostream>
using namespace std;

int num5 = 50;

class Outer
{
    int num3;
    static int num4;

public:
    // Nested class
    class Inner
    {
        int num1;
        static int num2;

    public:
        void f1()
        {
            cout << num1 << endl;
            cout << num2 << endl;
            Outer o1;
            cout << o1.num3 << endl;
            // cout << num3 << endl; // NOT OK
            cout << num4 << endl;
            cout << num5 << endl;
        }
        static void f2()
        {
            // cout << num1 << endl; // NOT OK
            cout << num2 << endl;
            cout << num4 << endl;
            Outer o1;
            cout << o1.num3 << endl;
            cout << num5 << endl;
        }
    };
};

class Test
{
    int num1;
    static int num2;

public:
    void f1() // this
    {
    }
    static void display()
    {
        cout << num2 << endl;
        Test t;
        cout << t.num1 << endl;
    }
};
int main()
{
    Outer o1;
    Outer::Inner i1;

    Test t1;
    t1.f1();
    return 0;
}