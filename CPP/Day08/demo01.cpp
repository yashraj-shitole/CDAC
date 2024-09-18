#include <iostream>
using namespace std;

template <typename T>
void swap(T *p1, T *p2)
{
    T temp = *p1;
    *p1 = *p2;
    *p2 = temp;
}

int main()
{
    char n1 = 'A';
    char n2 = 'B';
    cout << "Before swap -> n1 = " << n1 << ", n2 = " << n2 << endl;
    swap(&n1, &n2);
    cout << "After swap -> n1 = " << n1 << ", n2 = " << n2 << endl;
    return 0;
}