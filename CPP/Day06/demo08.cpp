#include <iostream>
using namespace std;

// abstract class
class Shape
{
public:
    // pure virtual function
    virtual void accept() = 0;
    virtual void calculateArea() = 0;
};

class Circle : public Shape
{
    int radius;

public:
    void accept()
    {
        cout << "Enter the radius - ";
        cin >> radius;
    }
    void calculateArea()
    {
        cout << "Area of circle = " << 3.14 * radius * radius << endl;
    }
};

class Rectangle : public Shape
{
    int length;
    int breadth;

public:
    void accept()
    {
        cout << "Enter the length and breadth - ";
        cin >> length >> breadth;
    }
    void calculateArea()
    {
        cout << "Area of Rectangle = " << length * breadth << endl;
    }
};

int main()
{
    int choice;
    Shape *sptr = NULL;
    do
    {
        cout << "0. EXIT" << endl;
        cout << "1. Area of Circle" << endl;
        cout << "2. Area of Rectangle" << endl;
        cout << "Enter your choice - ";
        cin >> choice;
        switch (choice)
        {
        case 0:
            cout << "Thank you for using our app.. :)" << endl;
            break;
        case 1:
            sptr = new Circle(); // upcasting
            break;
        case 2:
            sptr = new Rectangle(); // upcasting
            break;
        default:
            cout << "Wrong choice .. :(" << endl;
            break;
        }
        if (sptr != NULL)
        {
            sptr->accept();
            sptr->calculateArea();
            delete sptr;
            sptr = NULL;
        }

    } while (choice != 0);
    return 0;
}

int search(Rectangle **ptr)
{
}

int main()
{
    Rectangle *arr[5];
    search(arr);
}