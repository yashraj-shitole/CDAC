#include <iostream>
using namespace std;

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
};

int main()
{
    Student s1;
    int mchoice;
    while ((mchoice = menuChoice()) != 0)
    {
        switch (mchoice)
            {
            case 0:
            {
                cout << "\nEnd of program";
            }
            break;

            case 1:
            {
                s1.initStudent();
                s1.printDate();
            }
            break;

            case 2:
            {
                s1.acceptStudent();
            }
            break;

            case 3:
            {
                s1.printDate();
            }
            break;

            default:
                cout << "\nInvalid choice !!!!";
                break;
        } // switch
    }   // while
}
