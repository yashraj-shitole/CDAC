#include <iostream>
#include <fstream>
#include <sstream>
#include <vector>
using namespace std;

class Person
{
    string name;

public:
    Person()
    {
    }
    Person(string name)
    {
        this->name = name;
    }
    virtual void accept()
    {
        cout << "Enter name - ";
        cin >> name;
    }

    virtual void display()
    {
        cout << "Name - " << name << endl;
    }
    string getName()
    {
        return name;
    }
};

class Employee : public Person
{
    int empid;
    double salary;

public:
    Employee()
    {
    }
    Employee(int empid, string name, double salary) : Person(name)
    {
        this->empid = empid;
        this->salary = salary;
    }

    virtual void accept()
    {
        cout << "Enter Empid - ";
        cin >> empid;
        Person::accept();
        cout << "Enter Salary - ";
        cin >> salary;
    }

    virtual void display()
    {
        cout << "Empid - " << empid << endl;
        Person::display();
        cout << "Salary - " << salary << endl;
    }
    int getEmpid()
    {
        return empid;
    }
    double getSalaray()
    {
        return salary;
    }
    void setSalary(double salary)
    {
        this->salary = salary;
    }
};

class Student : public Person
{
    int rollno;
    double marks;

public:
    Student()
    {
    }
    Student(int rollno, string name, double marks) : Person(name)
    {
        this->rollno = rollno;
        this->marks = marks;
    }

    virtual void accept()
    {
        cout << "Enter rollno - ";
        cin >> rollno;
        Person::accept();
        cout << "Enter marks - ";
        cin >> marks;
    }

    virtual void display()
    {
        cout << "Rollno - " << rollno << endl;
        Person::display();
        cout << "Marks - " << marks << endl;
    }
    int getRollno()
    {
        return rollno;
    }
    double getMarks()
    {
        return marks;
    }
    void updateMarks()
    {
        cout << "Enter the updated marks - ";
        cin >> marks;
    }
};

int menu()
{
    int choice;
    cout << "************************" << endl;
    cout << "0. EXIT" << endl;
    cout << "1. Add Employee" << endl;
    cout << "2. Add Student" << endl;
    cout << "3. Display All Employees" << endl;
    cout << "4. Display All Students" << endl;
    cout << "5. Find Employee" << endl;
    cout << "6. Find Student" << endl;
    cout << "7. Delete Employee" << endl;
    cout << "8. Delete Student" << endl;
    cout << "9. Update Salary" << endl;
    cout << "10. Update Marks" << endl;
    cout << "************************" << endl;
    cout << "Enter choice - ";
    cin >> choice;
    return choice;
}

void loadEmployees(vector<Employee *> &employeeList)
{
    ifstream fin("employee.txt");
    string line;
    while (getline(fin, line))
    {
        stringstream data(line);
        string id, name, salary;
        getline(data, id, ',');
        getline(data, name, ',');
        getline(data, salary, ',');
        Employee *e = new Employee(stoi(id), name, stod(salary));
        employeeList.push_back(e);
    }
    fin.close();
    cout << "***************************" << endl;
    cout << "Employees loaded from file.." << endl;
    cout << "***************************" << endl;
}
void loadStudents(vector<Student *> &studentList)
{
    ifstream fin("student.txt");
    string line;
    while (getline(fin, line))
    {
        stringstream data(line);
        string rollno, name, marks;
        getline(data, rollno, ',');
        getline(data, name, ',');
        getline(data, marks, ',');
        Student *s = new Student(stoi(rollno), name, stod(marks));
        studentList.push_back(s);
    }
    fin.close();
    cout << "***************************" << endl;
    cout << "Students loaded from file.." << endl;
    cout << "***************************" << endl;
}

void saveEmployees(vector<Employee *> &employeeList)
{
    ofstream fout("employee.txt"); // file open for writing
    for (int i = 0; i < employeeList.size(); i++)
    {
        Employee *e = employeeList[i];
        fout << e->getEmpid() << "," << e->getName() << "," << e->getSalaray() << endl;
    }
    fout.close(); // file closed after writing
    cout << "***************************" << endl;
    cout << "Employees Saved into file.." << endl;
    cout << "***************************" << endl;
}
void saveStudents(vector<Student *> &studentList)
{
    ofstream fout("student.txt");
    for (int i = 0; i < studentList.size(); i++)
    {
        Student *s = studentList[i];
        fout << s->getRollno() << "," << s->getName() << "," << s->getMarks() << endl;
    }
    fout.close();
    cout << "***************************" << endl;
    cout << "Stduents Saved into file..." << endl;
    cout << "***************************" << endl;
}

int findEmployee(vector<Employee *> &employeeList)
{
    int id;
    cout << "Enter the empid to search - ";
    cin >> id;
    for (int i = 0; i < employeeList.size(); i++)
        if (employeeList[i]->getEmpid() == id)
            return i;
    return -1;
}

int findStudent(vector<Student *> &studentList)
{
    int rollno;
    cout << "Enter the rollno to search - ";
    cin >> rollno;
    for (int i = 0; i < studentList.size(); i++)
        if (studentList[i]->getRollno() == rollno)
            return i;
    return -1;
}

int main()
{
    vector<Employee *> employeeList;
    vector<Student *> studentList;
    loadEmployees(employeeList);
    loadStudents(studentList);

    int choice;

    while ((choice = menu()) != 0)
    {
        switch (choice)
        {
        case 1:
        {
            Employee *e = new Employee;
            e->accept();
            employeeList.push_back(e);
        }
        break;
        case 2:
        {
            Student *s = new Student;
            s->accept();
            studentList.push_back(s);
        }
        break;
        case 3:
            for (int i = 0; i < employeeList.size(); i++)
                employeeList[i]->display();
            break;
        case 4:
            for (int i = 0; i < studentList.size(); i++)
                studentList[i]->display();
            break;
        case 5:
        {
            int index = findEmployee(employeeList);
            if (index != -1)
                employeeList[index]->display();
            else
                cout << "Employee not found..." << endl;
        }
        break;
        case 6:
        {
            int index = findStudent(studentList);
            if (index != -1)
                studentList[index]->display();
            else
                cout << "Student not found..." << endl;
        }
        break;
        case 7:
        {
            int index = findEmployee(employeeList);
            if (index != -1)
            {
                delete employeeList[index];
                employeeList.erase(employeeList.begin() + index);
            }
            else
                cout << "Employee does not exists..." << endl;
        }
        break;
        case 8:
        {
            int index = findStudent(studentList);
            if (index != -1)
            {
                delete studentList[index];
                studentList.erase(studentList.begin() + index);
            }
            else
                cout << "Student does not exists..." << endl;
        }
        break;
        case 9:
        {
            int index = findEmployee(employeeList);
            if (index != -1)
            {
                double salary;
                cout << "Enter the new salary - ";
                cin >> salary;
                employeeList[index]->setSalary(salary);
            }
            else
                cout << "Employee does not exists..." << endl;
        }
        break;
        case 10:
        {
            int index = findStudent(studentList);
            if (index != -1)
                studentList[index]->updateMarks();
            else
                cout << "Stduent does not exists..." << endl;
        }
        break;
        default:
            cout << "Wrong choice ..." << endl;
            break;
        }
    }
    saveEmployees(employeeList);
    saveStudents(studentList);
    return 0;
}