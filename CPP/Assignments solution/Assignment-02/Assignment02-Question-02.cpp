
#include <iostream>
using namespace std;


class Student //class Student
{
    int rollNo; 
    float marks;
    string name;

public:
    void initStudent() // to initialize default values (0,' ',0)
    {
        rollNo = 0;
        marks= 0;
        name = " ";
    }

    void printStudentOnConsole()
    {
        cout << "Name: " << name << " Roll No: " << rollNo<< " Marks: " << marks << endl;
    }

    void acceptStudentFromConsole()
    {
        cout << "Enter Roll No: ";
        cin >> rollNo;
        cout << "Enter Name: ";
        cin >> name;
        cout << "Enter Mark: ";
        cin >> marks;
    }

   
};

int main()
{
    Student s;
    int choice;

    while (1)
    {
        cout << "\nMenu (Structure):\n";
        cout << "1. Initialize Student\n";
        cout << "2. Accept student details\n";
        cout << "3. Print student details\n";
        cout << "4. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice)
        {
        case 1:
            s.initStudent();
            cout << "Student details initialized.\n";
            break;
        case 2:
            s.acceptStudentFromConsole();
            break;
        case 3:
            s.printStudentOnConsole();
            break;
       
        case 4:
            return 0;
        default:
            cout << "Invalid choice!\n";
        }
    }
    return 0;
}
