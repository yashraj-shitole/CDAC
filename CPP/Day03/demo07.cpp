#include <iostream>
using namespace std;

class Test
{
    const int num1;
    int num2;

public:
    Test() : num1(10)
    {
        num2 = 20;
    }

    void setNum2(int num2)
    {
        this->num2 = num2;
    }

    int getNum2() const
    {
        return num2;
    }

    void display() const // const Test *const this
    {
        // num1 = 30;// NOT OK
        // num2 = 40; // NOT OK
        cout << num1 << endl;
        cout << num2 << endl;
    }
};

int main()
{
    Test t1;
    t1.setNum2(40);

    //
    const Test t2;
    // t2.setNum2(50); NOT OK
    t2.display();
    t2.getNum2();

    // const int num1 = 10;
    // const int *const ptr = &num1;

    // const Test t3;
    // const Test *const ptr_this = &t3;

    return 0;
}