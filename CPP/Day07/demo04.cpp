#include <iostream>
using namespace std;
class Employee
{
public:
    Employee()
    {
        cout << "Employee()" << endl;
    }
    virtual ~Employee()
    {
        cout << "~Employee()" << endl;
    }
};

class Manager : public Employee
{

public:
    Manager()
    {
        cout << "Manager()" << endl;
    }
    ~Manager()
    {
        cout << "~Manager()" << endl;
    }
};

int main()
{
    Employee *e = new Manager(); // upcasting
    delete e;
    e = NULL;
    return 0;
}