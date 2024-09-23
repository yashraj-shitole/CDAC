#include <iostream>
#include <vector>
using namespace std;

class Person
{
    public:
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

    void accept()
    {
        cout << "Enter empid - ";
        cin >> empid;
        Person::accept();
        cout << "Enter salary - ";
        cin >> salary;
    }
    void display()
    {
        cout << "Empid - " << empid << endl;
        Person::display();
        cout << "Salary - " << salary << endl;
    }
    int getEmpId()
    {
        return empid;
    }
};

int findEmployee(vector<Person *> &personList)
{
    int id;
    cout << "Enter empid to search - ";
    cin >> id;
    for (int i = 0; i < personList.size(); i++)
    {
        Employee *eptr = dynamic_cast<Employee *>(personList[i]);
        if (eptr != NULL && id == eptr->getEmpId())
            return i;
    }
    // if (typeid(*personList[i]) == typeid(Employee))
    // {
    //     Employee *eptr = (Employee *)personList[i];
    //     if (id == eptr->getEmpId())
    //          return i;
    // }
    return -1;
}

// To-Do -> Create a class student derived from the Person
class Student:public Employee{

int rollNo;
double marks;

public:
    Student(){
    }

    Student(string name,int rollNo,double marks){
        this->name=name;
        this->rollNo=rollNo;
        this->marks=marks;
    }

    void accept(){
        cout<<"Enter Student name"<<endl;
        cin>>name;
        cout<<"Enter Student Rollno"<<endl;
        cin>>rollNo;
        cout<<"Enter Student marks"<<endl;
        cin>>marks;
    }

    void display(){
        cout<<"Enter Student name: "<<name<<endl;
        cout<<"Enter Student Rollno: "<<rollNo<<endl;
        cout<<"Enter Student marks: "<<marks<<endl;
    }

    int getRollNo(){
        return rollNo;
    }
};

// To-Do -> Implement the findStudent()
int findStudent(vector<Student *> &studentList){
    int id;
    cout << "Enter empid to search - ";
    cin >> id;
    for (int i = 0; i < studentList.size(); i++)
    {
        Student *eptr = dynamic_cast<Student *>(studentList[i]);
        if (eptr != NULL && id == eptr->getRollNo())
            return i;
    }
}



void write()
{
    Student s;
    s.accept();
    ofstream fout("person.txt", ios::app);
    fout << s.getRollNo() << "," << s.getName() << "," << s.getMarks() << endl;
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
    int choice;
    vector<Person *> personList;
    vector<Student *> studentList;

    do
    {
        cout << "0. EXIT" << endl;
        cout << "1. Add Employee" << endl;
        cout << "2. Display Employees" << endl;
        cout << "3. Find Employee" << endl;
        cout << "4. Delete Employee" << endl;
        // To-Do -> Add the similar above 4 cases for Student
        cout << "5. Add Student" << endl;
        cout << "6. Display Student" << endl;
        cout << "7. Find Student" << endl;
        cout << "8. Delete Student" << endl;
        cout << "Enter thhe choice - ";
        cin >> choice;

        switch (choice)
        {
        case 0:
            cout << "Thank you for using the app..." << endl;
            break;
        case 1:
        {
            Employee *e = new Employee;
            e->accept();
            personList.push_back(e);
        }
        break;
        case 2:
            for (int i = 0; i < personList.size(); i++)
                if (typeid(*personList[i]) == typeid(Employee))
                    personList[i]->display();
            break;
        case 3:
        {
            int index = findEmployee(personList);
            if (index != -1)
                personList[index]->display();
            else
                cout << "Employee not found..." << endl;
        }
        break;
        case 4:
        {
            int index = findEmployee(personList);
            if (index != -1)
            {
                delete personList[index];
                personList.erase(personList.begin() + index);
            }
            else
                cout << "Incorrect Empid ..." << endl;
        }
        break;

        case 5:{
            Student *s=new Student;
            s->accept();
            studentList.push_back(s);
            break;
        }
        case 6:{
                for(int i=0;i<studentList.size();i++){
                    if(typeid(*studentList[i])==typeid(Student)){
                        studentList[i]->display();
                    }
                }
            break;
        }
        case 7:{
                int index=findStudent(studentList);
                if(index!= -1){
                    personList[index]->display();
                }
                else
                cout<<"Incorect rollno..."<<endl;
            break;
        }
        case 8:{
            int index = findStudent(studentList);
            if(index != -1){
                delete studentList[index];
                studentList.erase(studentList.begin() + index);
            }
            else
            cout<<"Incorrect rollno..."<<endl;

            break;
        }
        default:
            cout << "Wrong choice..." << endl;
            break;
        }

    } while (choice != 0);

    // to de allocate all the dynamic memory
    for (int i = 0; i < personList.size(); i++)
    {
        delete personList[i];
        personList[i] = NULL;
    }
    return 0;
}


