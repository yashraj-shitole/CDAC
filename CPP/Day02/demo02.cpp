#include <iostream>
using namespace std;

struct Time
{
    // members of the structure (Data)
private:
    // Data Members
    int hrs;
    int mins;

public:
    // Member functions
    void acceptTime() //
    {
        // printf("Enter the hrs and mins - ");
        cout << "Enter the hrs and mins";

        // scanf("%d%d", &hrs, &mins);
        cin >> hrs >> mins;
    }

    void displayTime()
    {
        // printf("Time = %d : %d", hrs, mins);
        cout << "Time = " << hrs << " : " << mins << endl;
    }
};

int main()
{
    struct Time t1;  //
    t1.acceptTime(); // address of t1
    t1.displayTime();

    // NOT OK
    // t1.hrs = 10;    // Write/Manipulate
    // cout << t1.hrs; // Read/ Fetch

    struct Time t2;
    t2.acceptTime();
    t2.displayTime();

    return 0;
}