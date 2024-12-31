#include <iostream>
using namespace std;
class Shape
{
public:
    virtual void accept() = 0;
    virtual void calculateArea() = 0;
    static Shape *shapeFactory(int choice);
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

class Square : public Shape
{
public:
    void accept()
    {
        cout << "Square accept- " << endl;
    }
    void calculateArea()
    {
        cout << "Area of Square - " << endl;
    }
};

int menu()
{
    int choice;
    cout << "0. EXIT" << endl;
    cout << "1. Area of Circle" << endl;
    cout << "2. Area of Rectangle" << endl;
    cout << "3. Area of Square" << endl;
    cout << "Enter the choice - ";
    cin >> choice;
    return choice;
}

Shape *Shape::shapeFactory(int choice)
{
    switch (choice)
    {
    case 1:
        return new Circle;
    case 2:
        return new Rectangle;
    case 3:
        return new Square;
    }
    return NULL;
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
        case 2:
        case 3:
            sptr = Shape::shapeFactory(choice);
            sptr->accept();
            sptr->calculateArea();
            delete sptr;
            sptr = NULL;
            break;
        default:
            cout << "Wrong choice..." << endl;
            break;
        }
    }
    return 0;
}