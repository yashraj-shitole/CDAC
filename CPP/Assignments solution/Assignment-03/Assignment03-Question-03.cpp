// Q3. Write a class Address with data members (string building, string street, string city ,int pin)
// Implement constructors, getters, setters, accept(), and display() methods.
// Test the class functunalities by creating the object of class and calling all the functions
#include <iostream>
using namespace std;

class Address{
    string building, street, city;
    int pin;

public:
    void setBuilding(string buildingName){
        building=buildingName;
    }
    void setStreet(string streetName){
        street=streetName;
    }
    void setCity(string cityName){
        city=cityName;
    }
    void setPin(int pinNumber){
        pin=pinNumber;
    }

    string getBuilding(){
        return building;
    }
    string getStreet(){
        return street;
    }
    string getCity(){
        return city;
    }
    int getPin(){
        return pin;
    }


    void displayAddress(){
            cout<<"Address: "<<building<<", "<<street<<", "<<city<<" - "<<pin<<endl;
    }

    void acceptAddress(string buildingName,string streetName, string cityName,int pincode){
        building=buildingName;
        street=streetName;
        city=cityName;
        pin=pincode;
    }

};

int main(){

    //creating new object
    Address ad1;

    //using setters
    ad1.setBuilding("SunBeam");
    ad1.setCity("Karad");
    ad1.setStreet("Mangalwar peth");
    ad1.setPin(410115);

    //using getters
    cout<<"Address: "<<ad1.getBuilding()<<", "<<ad1.getStreet()<<", "<<ad1.getCity()<<" - "<<ad1.getPin()<<endl;




    //creating object ad2

    Address ad2;
    //using accept() to get values
    string building,street,city;
    int pin;
    cout<<"Enter address"<<endl;
    cout<<"Building name:"<<endl;
    getline (cin,building);
    cout<<"Street name"<<endl;
    getline (cin,street);
    cout<<"City name"<<endl;
    getline (cin,city);
    cout<<"Enter pincode"<<endl;
    cin>>building;


    ad2.acceptAddress(building,street,city,pin);

    //displaying Address using displayAddress() function
    ad2.displayAddress();

    
    return 0;
}