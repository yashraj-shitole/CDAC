// Q1. Write a menu driven program to calculate volume of the box(length * width * height).
// Provide parameterless, parameterized(with 3 parameters) and single paramaterized constructor.
// Create the local objects in respective case and call the function to caluclate area.
// Menu options ->
// 1. Calculate Volume with default values
// 2. Calculate Volume with length,breadth and height with same value
// 3. Calculate Volume with different length,breadth and height values.

#include <iostream>

using namespace std;

class BoxVolume
{

    double length, width, height, volume;

public:
    BoxVolume()
    {
        length = 2;
        width = 3;
        height = 4;
    }
    BoxVolume(double len, double wid, double hei)
    {
        length = len;
        width = wid;
        height = hei;
    }
    BoxVolume(double x)
    {

        length = x;
        width = x;
        height = x;
    }

    double printVolume()
    {
        return length * width * height;
    }
};

int main()
{
    int choice;

    while (1)
    {
        cout << "\nMenu (Structure):\n";
        cout << "1. Initialize Date\n";
        cout << "2. Accept height, width, length from Console\n";
        cout << "3. Accept side from Console\n";

        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice)
        {
        case 1:
        {
            BoxVolume bv1;
            cout << "Volume of Box is " << bv1.printVolume() << endl;
            break;
        }
        case 2:
        {
            double l, w, h;
            cout << "Enter length, breadth, and height: ";
            cin >> l >> w >> h;
            BoxVolume bv2(l, w, h);
            cout << "Volume of Box is " << bv2.printVolume() << endl;
            break;
        }
        case 3:
        {
            double x;
            cout << "Enter side ";
            cin >> x;
            BoxVolume bv3(x);
            cout << "Volume of Box is " << bv3.printVolume() << endl;
            return 0;
        }

        default:
        {
            cout << "Invalid choice!\n";
        }
        }
    }
    return 0;
}
