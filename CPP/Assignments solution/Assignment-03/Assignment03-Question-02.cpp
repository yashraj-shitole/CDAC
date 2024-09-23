// Q2. Imagine a tollbooth at a bridge. Cars passing by the booth are expected to pay a fifty-cent toll.
// Mostly they do, but sometimes a car goes by without paying.
// The tollbooth keeps track of the number of cars that have gone by and of the total amount of money
// collected. Model this tollbooth with a class called tollbooth.
// The two data items are a type unsigned int to hold the total number of cars, and a type double to
// hold the total amount of money collected.
// A constructor initializes all data members to 0. A member function called payingCar() increments
// the car total and adds 0.50 to the cash total. An other function, called nopayCar()
// increments the car total but adds nothing to the cash total. Finally, a member function called
// printOnConsole() displays the two totals and number of paying as well as non paying cars total.

#include <iostream>

using namespace std;

class Tollbooth{

    int totalCars;
    double totalCash;


public:
    void payingCar(){
        totalCars += 1;
        totalCash += 0.5;
    }

    void noPayCar(){
        totalCars += 1;
    }

    void printOnConsole(){
        cout<<"Cars passed: "<<totalCars<<endl;
        cout<<"Total cash: "<<totalCash<<endl;

    }

};

int main(){


    int choice;

    while (1)
    {
        cout<<"Select option"<<endl;
        cout<<"1. Car payed 0.5/-"<<endl;
        cout<<"2. Car not payed"<<endl;
        cout<<"3. Display data"<<endl;
        cout<<"4. EXIT"<<endl;

        cin>>choice;
        Tollbooth t;
        switch (choice)
        {
        case 1:
            t.payingCar();
            break;
        
        case 2:
            t.noPayCar();
            break;

        case 3:
            t.printOnConsole();

        case 4:
            return 0;

        default:
            cout<<"Wrong choice"<<endl;

        }

       
    }
    


}

