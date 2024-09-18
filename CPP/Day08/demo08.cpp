#include <iostream>
#include <vector>
using namespace std;

class Employee
{
    int empid;
    string name;
    double salary;

public:
    Employee()
    {
    }
    Employee(int empid, string name, double salary)
    {
        this->empid = empid;
        this->name = name;
        this->salary = salary;
    }
    void accept()
    {
        cout << "Enter the empid - ";
        cin >> empid;
        cout << "Enter the name - ";
        cin >> name;
        cout << "Enter the salary - ";
        cin >> salary;
    }
    void display()
    {
        cout << "Empid - " << empid << endl;
        cout << "Name - " << name << endl;
        cout << "Salary - " << salary << endl;
    }
};

int main()
{
    vector<Employee *> empList;
    empList.push_back(new Employee(1, "Anil", 10000));
    empList.push_back(new Employee(2, "Mukesh", 20000));
    empList.push_back(new Employee(3, "Ramesh", 30000));
    empList.push_back(new Employee(4, "Suresh", 40000));

    empList.insert(empList.begin() + 2, new Employee(5, "sham", 50000));

    empList.erase(empList.begin() + 3);

    for (int i = 0; i < empList.size(); i++)
        empList[i]->display();

    return 0;
}
