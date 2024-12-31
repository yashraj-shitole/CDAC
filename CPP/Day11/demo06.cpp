#include <iostream>
using namespace std;

inline void add(int n1, int n2)
{
    int result = n1 + n2;
    cout << "Addition = " << result << endl;
}

void f1()
{
    cout << "Hello" << endl;
}

constexpr int square(int n)
{
    // f1();
    return n * n;
}

int main()
{
    add(10, 20);
    // int result = 10 + 20;
    // cout << "Addition = " << result << endl;

    int sq = square(5);
    // int sq = 25;
    return 0;
}