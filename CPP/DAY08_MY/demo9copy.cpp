#include <iostream>
#include <vector>
using namespace std;

class Person{

public:
string name;
Person(){

}

virtual void acceptDetails(){}

virtual void displayDetails(){}

};

class Student: public Person{
public:
    int rollNo;
    float marks;

    void acceptDetails() override {
        cout<< "Enter Name: ";
        cin>>name;
        cout << "Enter roll number: ";
        cin >> rollNo;
        cout << "Enter marks: ";
        cin >> marks;
    }

    void displayDetails() override{
        cout<<"Name: "<<name<<endl;
        cout<<"Roll no: "<<rollNo<<endl;
        cout<<"Marks: "<<marks<<endl;
        cout<<endl;
    }

    string getName(){

    }

    void setName(string name){
        this->name=name;
    }

    int getRollNo() {
        return rollNo;
    }

    void setRollNo(int rollNo) {
        this->rollNo = rollNo;
    }

    float getMarks() {
        return marks;
    }

    void setMarks(float marks) {
        this->marks = marks;
    }
};


void menu(){
    cout<<"___________________________"<<endl;
    cout<<endl;
    cout<<"1. Add Student"<<endl;
    cout<<"2. Display Student"<<endl;
    cout<<"3. Find Student"<<endl;
    cout<<"4. Delete Student"<<endl;
    cout<<"5. EXIT"<<endl;
    cout<<"___________________________"<<endl;
}


int main(){


    vector<Student *> studentList;

    int choice;
    do{
        menu();
        cout<<"Enter your choice: ";
        cin>>choice;


        switch(choice){

            case 1:{
                Student *e=new Student;
                e->acceptDetails();
                studentList.push_back(e);
                break;
            }
            case 2:{
                for(int i=0;i<studentList.size();i++){
                    studentList[i]->displayDetails();
                }
                break;
            }

            case 3:{
                int rollNo;
                cout<<"Enter roll number to find student: ";
                cin>>rollNo;
                bool notFound=true;

                for(int i=0;i<studentList.size();i++){
                    if(studentList[i]->getRollNo()==rollNo){
                        studentList[i]->displayDetails();
                        notFound=false;
                        break;
                    }
                }

                if(notFound){
                    cout<<"Student not found"<<endl;
                }

                break;
            }
            case 4:{
                    int rollNo;
                    cout<<"Enter roll number to delete student: ";
                    cin>>rollNo;

                    for(int i=0;i<studentList.size();i++){
                        if(studentList[i]->getRollNo()==rollNo){
                            delete studentList[i];
                            studentList.erase(studentList.begin()+i);
                            break;
                        }
                        else{
                            cout<<"Student not found"<<endl;
                        }
                    }
                break;
            }

            case 5:{
                break;
            }

            default:
                cout<<"Wrong choice";

        }
    }while(choice !=5);


cout<<"Thankyou for using app..."<<endl;
return 0;
}


