#include <iostream>
using namespace std;

class Person
{
    string name;

public:
    void accept()
    {
        cout << "Person::accept()" << endl;
    }
    void display()
    {
        cout << "Person::display()" << endl;
    }
};

class Fruit
{
    int weight;
    string taste;

public:
    void accept()
    {
        cout << "Fruit::accept()" << endl;
    }
    void display()
    {
        cout << "Fruit::display()" << endl;
    }
};

int main()
{
    Person *person;
    Fruit *fruit = new Fruit;
    person = reinterpret_cast<Person *>(fruit);

    return 0;
}