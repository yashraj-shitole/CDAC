// Q1. Create a class Date with data memebrs day,month and year.
// Cretae a class Person with data members name,address and birthdate. The birthdate shoud be of
// type Date.
// Cretae a class Employee with data members id, sal, dept and joining date. The joining date should
// be of type date.
// Employee class should be inherited from Person.
// Implement following classes. Test all functionalities in main().

#include <iostream>
using namespace std;


//date class
class Date{

int day, month, year; //data members


public: //to get accessed by other classes
//setter
void acceptDate(){
    cin>>day>>month>>year;
}


//getters
int getDay(){
    return day;
}
int getMonth(){
    return month;
}
int getYear(){
    return year;
}

void display(){
    cout<<day<<"/"<<month<<"/"<<year<<endl;
}

};


//person class
class Person{

//data members;
public:
string name;
string address;
Date birthdate; //creating data member of type Date

void acceptDetails(){
    cout<<"Enter name"<<endl;
    getline(cin,name);
    cout<<"Enter address"<<endl;
    getline(cin,address);
    cout<<"Enter bithdate DD MM YY"<<endl;
    birthdate.acceptDate();

}


void printDetails(){
    cout<<name<<endl;
    cout<<address<<endl;
    cout<<birthdate.getDay()<<"/"<<birthdate.getMonth()<<"/"<<birthdate.getYear()<<endl; //accessing datamembers from date class
}
};



class Employee:Person{ //Inheritance

int id;
float sal;
string dept;
Date joiningDate;


public:
void acceptDetails(){
    // cout<<"Enter name"<<endl;
    // getline(cin,name);

    // cout<<"Enter address"<<endl;
    // getline(cin,address);
    
    Person::acceptDetails();

    cout<<"Enter id"<<endl;
    cin>>id;

    cout<<"Enter salary"<<endl;
    cin>>sal;

    cout<<"Enter department"<<endl;
    cin>>dept;

    cout<<"Enter Joining Date DD MM YY"<<endl;
    joiningDate.acceptDate();


// cout<<"Enter bithdate DD MM YY"<<endl;
    // cin>>d>>m>>y;
    // birthdate.acceptDate(d,m,y);

}



void printDetails(){

    Person::printDetails();
    cout<<dept<<endl;
    cout<<id<<endl;
    cout<<sal<<endl;
    joiningDate.display();

}


};


int main(){

Person p; //object of class person
p.acceptDetails();
p.printDetails();

Employee e;
e.acceptDetails();
e.printDetails();

}