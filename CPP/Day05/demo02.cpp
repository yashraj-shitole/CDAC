#include <iostream>
using namespace std;
enum WEEKDAY
{
    Sunday = 1,
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday
};
int main()
{
    int choice = 3;
    switch (WEEKDAY(choice))
    {
    case Sunday:
        cout << "Sunday Selected..." << endl;
        break;
    case Monday:
        cout << "Monday Selected..." << endl;
        break;
    case Tuesday:
        cout << "Tuesday Selected..." << endl;
        break;
    }
    return 0;
}