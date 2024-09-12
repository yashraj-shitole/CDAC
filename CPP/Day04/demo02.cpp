#include <iostream>
using namespace std;

class Test
{
    int num1;
    static int num2;

public:
    Test()
    {
        num1 = 10;
    }
    void setNum1(int num1)
    {
        this->num1 = num1;
    }

    static void setNum2(int num2)
    {
        // num1 = num2; // cannot access non static data members
        // this pointer is not present in static member functions
        Test::num2 = num2;
    }

    static int getNum2()
    {
        return num2;
    }

    void displayTest()
    {
        cout << "num1 = " << num1 << endl;
        cout << "num2 = " << num2 << endl;
    }
};

// Initialization of static data member
int Test::num2 = 20;

int main()
{
    cout << "Value of num2 = " << Test::getNum2() << endl;
    Test::setNum2(22);
    cout << "Value of num2 after change = " << Test::getNum2() << endl;

    // Test::setNum1(11); /// NOT OK
    Test t1;
    t1.setNum1(11);
    t1.setNum2(22);
    return 0;
}

int main1()
{
    Test t1;
    Test t2;
    Test t3;

    t1.setNum1(11);
    t3.setNum2(22);

    t1.displayTest();
    t2.displayTest();
    t3.displayTest();
    return 0;
}
