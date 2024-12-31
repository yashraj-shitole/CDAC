#include <iostream>
using namespace std;
class Shape
{
public:
    virtual void accept() = 0;
    virtual void calculateArea() = 0;
};

class Circle : public Shape
{
public:
    void accept()
    {
        cout << "Cicle accept- " << endl;
    }
    void calculateArea()
    {
        cout << "Area of Cicle - " << endl;
    }
};

class Rectangle : public Shape
{
public:
    void accept()
    {
        cout << "Rectangle accept- " << endl;
    }
    void calculateArea()
    {
        cout << "Area of Rectangle - " << endl;
    }
};

int menu()
{
    int choice;
    cout << "0. EXIT" << endl;
    cout << "1. Area of Circle" << endl;
    cout << "2. Area of Rectangle" << endl;
    cout << "Enter the choice - ";
    cin >> choice;
    return choice;
}

int main()
{
    int choice;
    Shape *sptr = NULL;
    while ((choice = menu()) != 0)
    {
        switch (choice)
        {
        case 1:
            sptr = new Circle();
            break;
        case 2:
            sptr = new Rectangle();
            break;
        default:
            cout << "Wrong choice..." << endl;
            break;
        }
        if (sptr != NULL)
        {
            sptr->accept();
            sptr->calculateArea();
            delete sptr;
            sptr = NULL;
        }
    }
    return 0;
}