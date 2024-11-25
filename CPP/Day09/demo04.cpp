#include <iostream>
#include <fstream>
#include <sstream> // step 1
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
        cout << "Enter Empid - ";
        cin >> empid;
        cout << "Enter Name - ";
        cin >> name;
        cout << "Enter Salary - ";
        cin >> salary;
    }

    void display()
    {
        cout << "Empid - " << empid << endl;
        cout << "Name - " << name << endl;
        cout << "Salary - " << salary << endl;
    }
    int getEmpId()
    {
        return empid;
    }
    string getName()
    {
        return name;
    }
    double getSalary()
    {
        return salary;
    }
};

void write()
{
    Employee e;
    e.accept();
    ofstream fout("emp.txt", ios::app);
    fout << e.getEmpId() << "," << e.getName() << "," << e.getSalary() << endl;
    fout.close();
}

void read()
{
    ifstream fin("emp.txt");
    string line;
    while (getline(fin, line))
    {
        stringstream data(line); // step 2
        string id, name, salary; // step 3

        // step 4
        getline(data, id, ',');
        getline(data, name, ',');
        getline(data, salary, ',');

        /// step 5
        Employee e(stoi(id), name, stod(salary));

        e.display();
    }
    fin.close();
}

int main()
{
    // write();
    read();
    return 0;
}