#include <iostream>
using namespace std;

class Array
{
    int index;
    int size;
    int *ptr;

public:
    Array()
    {
        size = 5;
        index = 0;
        ptr = new int[size];
    }

    void addElement(int element)
    {
        if (index < size)
        {
            ptr[index] = element;
            index++;
        }
        else
            cout << "Array is full..." << endl;
    }

    int getElement(int index)
    {
        return ptr[index];
    }
    int &operator[](int i)
    {
        return ptr[i];
    }
};

int main()
{
    Array a1;
    a1.addElement(10);
    a1.addElement(20);
    cout << "Element at 0 = " << a1[0] << endl;
    cout << "Element at 1 = " << a1[1] << endl;
    a1[1] = 30;
    cout << "Element at 1 = " << a1[1] << endl;

    return 0;
}

int main1()
{
    Array a1;
    a1.addElement(10);
    a1.addElement(20);
    cout << "Element at index 0 = " << a1.getElement(0) << endl;
    cout << "Element at index 1 = " << a1.getElement(1) << endl;
    return 0;
}