// Q2. Provide menu driven code for the functionalities:
// 1. Accept Employee
// a. Accept Manager
// b. Accept Salesman
// c. Accept SalesManager
// 2. Display the count of all employees with respect to designation
// 3. Display All Managers
// 4. Display All Salesman
// 5. Display All SalesManagers

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

    // setters
    void setId(int employeeId)
    {
        id = employeeId;
    }

    void setSalary(double employeeSalary)
    {
        salary = employeeSalary;
    }

    // getters
    int getId()
    {
        return id;
    }
    double getSalary()
    {
        return salary;
    }

    virtual void accept()
    {
    }

    virtual void display()
    {
    }


};

// class manager
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

    void accept() override
    {
        cout << "Enter id: ";
        cin >> id;
        cout << "Enter salary: ";
        cin >> salary;
        cout << "Enter bonus: ";
        cin >> bonus;
    }

    void display() override
    {
        cout << "ID: " << id << endl;
        cout << "Salary: " << salary << endl;
        cout << "Bonus: " << bonus << endl;
    }


};

// class salesman
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

    void setCommission(double salesmanCommission)
    {
        commission = salesmanCommission;
    }

    double getCommission()
    {
        return commission;
    }

    void accept()
    {
        cout << "Enter id: ";
        cin >> id;
        cout << "Enter salary: ";
        cin >> salary;
        cout << "Enter commission: ";
        cin >> commission;
    }

    void display() override
    {
        cout << "ID: " << id << endl;
        cout << "Salary: " << salary << endl;
        cout << "Commission: " << commission << endl;
    }
};

// class salesmanager
class SalesManager : public Manager, public Salesman
{
public:
    SalesManager() {}

    SalesManager(int SalesManagerId, double SalesManagerSalary, double SalesManagerBonus, double SalesManagerCommission)
    {
        id = SalesManagerId;
        salary = SalesManagerSalary;
        bonus = SalesManagerBonus;
        commission = SalesManagerCommission;
    }

    void accept()
    {
        cout << "Enter id: ";
        cin >> id;
        cout << "Enter salary: ";
        cin >> salary;
        cout << "Enter bonus: ";
        cin >> bonus;
        cout << "Enter commission: ";
        cin >> commission;
    }

    void display() override
    {
        cout << "ID: " << id << endl;
        cout << "Salary: " << salary << endl;
        cout << "Bonus: " << bonus << endl;
        cout << "Commission: " << commission << endl;
    }

};

int main()
{
    Employee *employees[10]; // Dynamic array of employee pointers
    int employeeCount = 0;
    int choice;

    while (1)
    {
        cout << "\nEnter your choice:" << endl;
        cout << "1. Accept Manager" << endl;
        cout << "2. Accept Salesman" << endl;
        cout << "3. Accept SalesManager" << endl;
        cout << "4. Display count of all employees by designation" << endl;
        cout << "5. Display all Managers" << endl;
        cout << "6. Display all Salesmen" << endl;
        cout << "7. Display all SalesManagers" << endl;
        cout << "8. EXIT" << endl;
        cout << "Choice: ";
        cin >> choice;

        switch (choice)
        {

        case 1:
            employees[employeeCount] = new Manager();
            employees[employeeCount]->accept();
            employeeCount++;
            break;

        case 2:
            employees[employeeCount] = new Salesman();
            employees[employeeCount]->accept();
            employeeCount++;
            break;

        case 3:
            employees[employeeCount] = new SalesManager();
            employees[employeeCount]->accept();
            employeeCount++;
            break;

        case 4:
        {
            int mgrCount = 0;
            int salesCount = 0;
            int salesMgrCount = 0;
            for (int i = 0; i < employeeCount; i++)
            {
                if (typeid(Manager)==typeid(*employees[i]))
                    mgrCount++;
                else if (typeid(Salesman)==typeid(*employees[i]))
                    salesCount++;
                else if (typeid(SalesManager)==typeid(*employees[i]))
                    salesMgrCount++;
            }
            cout << "Total Managers: " << mgrCount << endl;
            cout << "Total Salesmen: " << salesCount << endl;
            cout << "Total SalesManagers: " << salesMgrCount << endl;
            break;
        }

        case 5:
            cout << "Managers:" << endl;
            for (int i = 0; i < employeeCount; i++)
            {
                if (typeid(Manager)==typeid(*employees[i]))
                    employees[i]->display();
            }
            break;

        case 6:
            cout << "Salesmen:" << endl;
            for (int i = 0; i < employeeCount; i++)
            {
                if (typeid(Salesman)==typeid(*employees[i]))
                    employees[i]->display();
            }
            break;

        case 7:
            cout << "SalesManagers:" << endl;
            for (int i = 0; i < employeeCount; i++)
            {
                if (typeid(SalesManager)==typeid(*employees[i]))
                    employees[i]->display();
            }
            break;

        case 8:
            return 0;

        default:
            cout << "Wrong choice!" << endl;
        }
    }

    return 0;
}
