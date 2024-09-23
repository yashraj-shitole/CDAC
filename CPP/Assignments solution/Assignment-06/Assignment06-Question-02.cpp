// Q2. Implement following classes. Test all functionalities in main() of each created class. Note that
// employee is inherited into manager and salesman.

#include <iostream>
using namespace std;

class Employee
{

public:
    int id;
    double salary;

    Employee()
    {
        id = 0;
        salary = 0;
    }

    Employee(int employeeId, double employeeSalary)
    {
        id = employeeId;
        salary = employeeSalary;
    }

    // id setter
    void setId(int employeeId)
    {
        id = employeeId;
    }

    // id getter
    int getId()
    {
        return id;
    }

    // salary setter
    void setSalary(double employeeSalary)
    {
        salary = employeeSalary;
    }

    // salary getter
    double getSalary()
    {
        return salary;
    }

    void accept()
    {
        cout << "Enter id" << endl;
        cin >> id;
        cout << "Enter salary" << endl;
        cin >> salary;
    }

    void display()
    {
        cout << "id: " << id << endl;
        cout << "Salary: " << salary << endl;
    }
};

// Manager class inherited from Employee
class Manager : virtual public Employee
{

public:
    double bonus;

    Manager()
    {
        bonus = 0;
    }

    Manager(int managerId, double managerSalary, double managerBonus)
    {
        id = managerId;
        salary = managerSalary;
        bonus = managerBonus;
    }

    // setters
    void setBonus(double employeeBonus)
    {
        bonus = employeeBonus;
    }

    // getters
    double getBonus()
    {
        return bonus;
    }

    void accept()
    {
        Employee::accept();
        cout << "Enter bonus" << endl;
        cin >> bonus;
    }

    void display()
    {
        Employee::display();
        cout << "Bonus: " << bonus << endl;
    }
};

// Salesman class inherited from Employee
class Salesman : virtual public Employee
{

public:
    double commission;

    Salesman()
    {
        commission = 0;
    }

    Salesman(int salesmanId, double salesmanSalary, double salesmanCommission)
    {
        id = salesmanId;
        salary = salesmanSalary;
        commission = salesmanCommission;
    }

    // stters
    void setCommission(double salesmanCommission)
    {
        commission = salesmanCommission;
    }

    // getters
    double getCommission()
    {
        return commission;
    }

    void accept()
    {
        Employee::accept();
        cout << "Enter commission" << endl;
        cin >> commission;
    }

    void display()
    {
        Employee::display();
        cout << "Commission: " << endl;
    }
};

// SalesManager class inherited from Employee and Manager
class SalesManager : Manager, Salesman
{

public:
    SalesManager()
    {
    }
    SalesManager(int SalesManagerId, double SalesManagerSalary, double SalesManagerBonus, double SalesManagerCommission)
    {

        id = SalesManagerId;
        salary = SalesManagerSalary;
        bonus = SalesManagerBonus;
        commission = SalesManagerCommission;
    }

    void accept()
    {
        Employee::accept();
        double bonus;
        double commission;
        cout << "Enter bonus" << endl;
        cin >> bonus;
        Manager::setBonus(bonus);
        cout << "Enter commission" << endl;
        cin >> commission;
        Salesman::setCommission(commission);
    }

    void display()
    {
        Employee::display();
        Manager::getBonus();
        Salesman::getCommission();
    }
};

int main()
{

    Employee e;
    e.accept();
    e.display();

    Manager m;
    m.accept();
    m.display();

    Salesman s;
    s.accept();
    s.display();

    SalesManager sm;
    sm.accept();
    sm.display();

    return 0;
}