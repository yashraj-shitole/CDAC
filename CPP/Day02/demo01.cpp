#include <iostream>
using namespace std;

struct Time
{
    // members of the structure
    int hrs;
    int mins;
};

void acceptTime(struct Time *ptr)
{
    printf("Enter the hrs and mins - ");
    scanf("%d%d", &ptr->hrs, &ptr->mins);
}

void displayTime(struct Time *ptr)
{
    printf("Time = %d : %d", ptr->hrs, ptr->mins);
}
int main()
{
    struct Time t1;
    acceptTime(&t1);  // pass by address
    displayTime(&t1); // pass by address

    struct Time t2;
    acceptTime(&t2);
    displayTime(&t2);

    return 0;
}