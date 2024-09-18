#include <iostream>
using namespace std;

template <class T>
class MyStack
{
    int size;
    int top;
    T *ptr;

public:
    MyStack(int size = 5)
    {
        this->size = size;
        this->top = -1;
        ptr = new T[size];
    }
    void push(T element)
    {
        top++;
        ptr[top] = element;
    }
    void pop()
    {
        top--;
    }
    T peek()
    {
        return ptr[top];
    }
};

class Employee
{
    int id;
    string name;
    double salary;
};

int main()
{
    MyStack<Employee> empStack;
    MyStack<double> s1;
    MyStack<char> s2;
    return 0;
}

int main1()
{
    MyStack<int> s1;
    s1.push(10);
    s1.push(20);
    s1.push(30);
    cout << "Element at peek = " << s1.peek() << endl;
    s1.pop();
    cout << "After pop, Element at peek = " << s1.peek() << endl;

    return 0;
}