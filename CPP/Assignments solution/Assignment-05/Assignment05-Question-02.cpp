// Q2. Write a menu driven program for Student management.
// Create a class student with data members name, gender, rollNumber(Auto generated) and array to
// keep marks of three subjects.
// Accept every thing from user and Print name, rollNumber, gender and percentage.
// In main(), create Student* arr[5] and provide facility for accept, print, search.
// Search function returns index of found Student, otherwise returns -1.

#include <iostream>
using namespace std;
class Student
{

    string name;
    string gender;
    int rollNumber;
    float marks[3];
    float obtaildTotalMarks;
    float totalMarks;

public:
    Student(int roll) : rollNumber(roll)
    {
        name = "";
        gender = "Not Specified";
        for (int i = 0; i < 3; i++)
        {
            marks[i]=0;
        }

    }

        // setters

    void accept()
    {
        cout << "Enter Name " << endl;
        cin >> name;
        cout << "Select gender: 1.Male 2.Female" << endl;
        int choice;
        cin >> choice;
        switch (choice)
        {
        case 1:
        {
            gender = "Male";
            break;
        }
        case 2:
        {
            gender = "Female";
            break;
        }
        default:
        {
            cout << "Wrong choice" << endl;
            gender = "Not Specified";
        }
        }
        cout << "Enter marks" << endl;
        for (int i = 0; i < 3; i++)
        {
            cin >> marks[i];
        }
    }

    // getters

    // print data
    void printData()
    {
        cout << endl;
        cout<<"Roll no: "<<rollNumber<<endl;
        cout << "Students name: " << name << endl;
        cout << "Students gender: " << gender << endl;
        cout << "Students Marks : ";
        for (int i = 0; i < 3; i++)
        {
            cout << marks[i] << " ";
        }
        cout << "Percentage: " << percentage() << endl;
    }

    float percentage()
    {
        obtaildTotalMarks = 0;
        totalMarks = 0;
        for (int i = 0; i < 3; i++)
        {
            obtaildTotalMarks += marks[i];
            totalMarks += 100;
        }
        return (obtaildTotalMarks / totalMarks) * 100;
    }



    bool search(Student *ptr, int roll) {

        if(ptr->rollNumber==roll){
            return true;
        }

        return 0;
    }




};



int main()
{

    Student *arr[5];

    for (int i = 0; i < 5; i++)
    {
        arr[i] = new Student(i+1);
    }

    int choice;

    while (1)
    {
        cout<<endl;
        cout << "Enter your choice" << endl;
        cout << "1.Accept data" << endl;
        cout << "2.Print data" << endl;
        cout << "3.Search" << endl;
        cout << "4.EXIT" << endl;
        cin >> choice;

        switch (choice)
        {
        case 1:
        {
            for (int i = 0; i < 5; i++)
            {
                arr[i]->accept();
            }
            break;
        }
        case 2:
        {
            for (int i = 0; i < 5; i++)
            {
                arr[i]->printData();
            }
            break;
        }
        case 3:
        {
            int roll;
            cout<<"Enter roll number of student "<<endl;
            cin>>roll;
            bool present=false;

            for (int i = 0; i < 5; i++)
            {
                if(arr[i]->search(arr[i],roll)){
                    cout<<"Student found at index "<<i<<endl;
                    present=true;
                    break;
                }
                
            }
            if(present==false){
                cout<<"Student not found"<<endl;
            }
            
            break;
        }
        case 4:
        {
            return 0;
        }
        default:
        {
            cout << "Wrong choice" << endl;
        }
        }
    }
}