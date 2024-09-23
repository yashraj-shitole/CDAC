// Q1.  A shop sells book or tapes. The Book class holds id, title, author, and price; whereas Tape class
// holds id, title, artist, and price. There is 5% discount on tapes, while 10% discount on books.
// Assuming that each user purchase 3 products (either book or tape), calculate final bill. The program
// should be menu driven and should not cause memory leakage.
// Hint - Create class Product and inherit into Book and Tape. Also create array like Product* arr[3]

#include <iostream>
using namespace std;


//class product
class Product
{

public:
    int id;
    string title;
    float price;

    //virtual funtions
    virtual void acceptDetails() {}
    virtual void displayDetails() {}

    //getter
    float getPrice(){
        return price;
    }
};

//class books
class Books : public Product
{
    string author;
    float bookPrice;

public:
//Overridden funtion from employee
    void acceptDetails() override
    {
        cout << "Enter product id" << endl;
        cin >> id;
        cout << "Enter title" << endl;
        cin >> title;
        cout << "Enter author name" << endl;
        cin >> author;
        cout << "Enter books price" << endl;
        cin >> bookPrice;
        price = bookPrice - (bookPrice * 0.10);
    }


};


//class tape
class Tape : public Product
{
    string artist;
    float tapePrice;

public:
//Overridden funtion from employee
    void acceptDetails() override
    {
        cout << "Enter product id" << endl;
        cin >> id;
        cout << "Enter title" << endl;
        cin >> title;
        cout << "Enter author name" << endl;
        cin >> artist;
        cout << "Enter books price" << endl;
        cin >> tapePrice;
        price = tapePrice - (tapePrice * 0.05);
    }

//getter
    float getPrice(){
        return price;
    }
};


//global funtion for menu
void menu()
{
    cout << "Enter your choice" << endl;
    cout << "1. Add product" << endl;
    cout << "2. Calculate bill" << endl;
    cout << "3. EXIT" << endl;

}

int main()
{

    //product array for 3 products
    Product *arr[3];

    while (1)
    {
        int choice;
        menu();
        cin >> choice;

        switch (choice)
        {
        case 1:
        {
            for (int i = 0; i < 3; i++)
            {
                int choice;
                cout << "Enter your choice" << endl;
                cout << "1. Add Book" << endl;
                cout << "2. Add Tape" << endl;
                cin >> choice;
                //switch case for type of product
                switch (choice)
                {
                case 1:
                {
                    arr[i] = new Books();
                    arr[i]->acceptDetails();
                    break;
                }
                case 2:
                {
                    arr[i] = new Tape();
                    arr[i]->acceptDetails();
                    break;
                }
                default:
                {
                    cout << "Wrong choice" << endl;
                }
                }
            }
            break;

            case 2:{
                float totalBill;
                for(int i=0;i<3;i++){
                    totalBill += arr[i]->getPrice();
                }
                cout<<"Total Bill: "<<totalBill<<endl;
                break;
            }

            case 3:{
                return 0;
            }

            default:{
                cout<<"wrong choice"<<endl;
            }
        }
        }
    }
}