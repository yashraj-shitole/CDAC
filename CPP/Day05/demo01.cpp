#include <iostream>
using namespace std;

int main()
{
    int **ptr = new int *[2];
    ptr[0] = new int[3];
    ptr[1] = new int[3];
    ptr[0][0] = 10;
    ptr[0][1] = 20;
    ptr[0][2] = 30;
    ptr[1][0] = 40;
    ptr[1][1] = 50;
    ptr[1][2] = 60;

    for (int row = 0; row < 2; row++)
    {
        for (int col = 0; col < 3; col++)
        {
            cout << ptr[row][col] << "  ";
        }
        cout << endl;
    }

    delete[] ptr[0];
    ptr[0] = NULL;
    delete[] ptr[1];
    ptr[1] = NULL;
    delete[] ptr;
    ptr = NULL;
}

int main2()
{
    int *arr[2][3];
    arr[0][0] = new int(10);
    // TO-DO
    return 0;
}

int main1()
{
    int arr[2][3];
    arr[0][0] = 10;
    arr[0][1] = 20;
    arr[0][2] = 30;
    arr[1][0] = 40;
    arr[1][1] = 50;
    arr[1][2] = 60;

    // row , col
    for (int row = 0; row < 2; row++)
    {
        for (int col = 0; col < 3; col++)
        {
            // cout << "Element = " << arr[row][col] << endl;
            cout << arr[row][col] << "  ";
        }
        cout << endl;
    }
    return 0;
}