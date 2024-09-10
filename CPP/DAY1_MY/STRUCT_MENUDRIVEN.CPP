#include <iostream>
using namespace std;

struct Time
{
    int hour;
    int minute;
    int second;

    void timeInput(){
        cout<<"Enter Hour Minuter Second"<<endl;
        cin>>hour>>minute>>second;
    }

     void timeDisplay(){
        cout<<hour<<':'<<minute<<':'<<second<<endl;
    }
};





int main(){

    struct Time t1;

    t1.timeInput();
    t1.timeDisplay();

    int choice;

    while (choice != 0)
    {
        menu();
    }
    



void menu{
    cin>>choice;
    cout<<"Choose option"<<endl;
    cout<<"1. To add Date"<<endl;
    cout<<"2. To display Date"<<endl;
    cout<<"3. Exit"<<endl;

}

}