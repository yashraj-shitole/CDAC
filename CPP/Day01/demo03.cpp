#include <iostream>
using namespace std;
int main()
{
    char ch1 = 'A';
    wchar_t ch2=L'A';
    wcout << "value in the char = " << ch1 << endl;
    wcout << "value in the wchar_t = " << ch2 << endl;
    cout << "size of char = " << sizeof(ch1) << endl;
    cout << "size of wchar_t = " << sizeof(ch2) << endl;

    return 0;
}
