#include <iostream>
using namespace std;

typedef enum
{
    EXIT,
    INITSTUDENT,
    ACCEPTSTUDENT,
    PRINTSTUDENT,
} menu;

namespace NStudent
{
    class Student
    {
        int rollNo;
        string sname;
        float marks;

    public:
        void initStudent()
        {
            rollNo = 0;
            sname = "\" \"";
            marks = 0;
        }

        void acceptStudent()
        {
            cout << "\nEnter the roll number: ";
            cin >> rollNo;

            cout << "\nEnter the student name: ";
            cin >> sname;
            
            cout << "\nEnter the marks: ";
            cin >> marks;
        }

        void printDate()
        {
            cout << "\nInit Student";
            cout << "\nRoll Number\tName\tMarks";
            cout << "\n"
                 << rollNo << "\t\t" << sname << "\t" << marks;
        }
    }; // class Student ends here
}   // namespace Student ends here

int menuChoice()
{
    int choice;
    cout << "\n0. Exit";
    cout << "\n1. Init Student";
    cout << "\n2. Accept Student";
    cout << "\n3. Print Student";
    cout << "\nEnter your choice: ";
    cin >> choice;
    return choice;
}

using namespace NStudent;
int main()
{
    Student s1;
    int mchoice;
    while ((mchoice = menuChoice()) != 0)
    {
        switch (mchoice)
        {
            case EXIT:
            {
                cout << "\nEnd of program";
            }
            break;

            case INITSTUDENT:
            {
                s1.initStudent();
                s1.printDate();
            }
            break;

            case ACCEPTSTUDENT:
            {
                s1.acceptStudent();
            }
            break;

            case PRINTSTUDENT:
            {
                s1.printDate();
            }
            break;

            default:
                cout << "\nInvalid choice !!!!";
                break;
        }   // switch
    }   // while
}