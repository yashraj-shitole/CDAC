#include <iostream>
using namespace std;

class Test
{
public:
    Test()
    {
        cout << "Test ctor" << endl;
    }

    void display()
    {
        cout << "Test :: display" << endl;
    }

    ~Test()
    {
        cout << "Test dtor" << endl;
    }
};

class SmartPointer
{
    Test *ptr;

public:
    SmartPointer(Test *ptr)
    {
        cout << "SmartPointer ctor" << endl;
        this->ptr = ptr;
    }

    Test *operator->()
    {
        return ptr;
    }

    ~SmartPointer()
    {
        cout << "SmartPointer Dtor" << endl;
        delete ptr;
        ptr = NULL;
    }
};
int main()
{
    SmartPointer s1(new Test);
    s1->display();
    return 0;
}

int main1()
{
    // Test t1;
    // t1.display();

    Test *t = new Test;
    t->display();
    delete t;
    return 0;
}