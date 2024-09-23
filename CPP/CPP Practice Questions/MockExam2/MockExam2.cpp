#include <iostream>
#include <vector>
#include <fstream>

using namespace std;

class Product
{
    int id;
    string productName;
    double price;

public:
    void acceptData()
    {
        cout << "Enter Product Id: ";
        cin >> id;
        cout << "Enter Product Name: ";
        cin >> productName;
        cout << "Enter Product Price: ";
        cin >> price;

        cout << endl;
    }

    void displayData()
    {
        cout << "Product Id: " << id << endl;
        cout << "Product Name: " << productName << endl;
        cout << "Product Price: " << price << endl;
        cout << endl;
    }


    int getProductId(){
        return id;
    }
};

class Person
{
protected:
    string name;
};

class Customer : Person
{
    string phoneNumber;
    vector<Product *> purchasedProducts;

public:
    string getName()
    {
        return name;
    }
    string getGetPhoneNumber()
    {
        return phoneNumber;
    }

    void acceptData()
    {
        cout << "Enter Customer Name: ";
        cin >> name;
        cout << "Enter Phone Number: ";
        cin >> phoneNumber;
        cout << endl;
    }

    void addProducts(vector<Product *> &ProductList, int productId)
    {
        for (int i = 0; i < ProductList.size(); i++)
        {
            if (ProductList[i]->getProductId()==productId)
            {
                purchasedProducts.push_back(ProductList[i]);
            }
        }
    }

    void customerOrders()
    {
        for (int i = 0; i < purchasedProducts.size(); i++)
        {
            purchasedProducts[i]->displayData();
        }
    }

    void displayProducts()
    {
        for (int i = 0; i < purchasedProducts.size(); i++)
        {
            purchasedProducts[i]->displayData();
        }
    }
};

void menu()
{
    cout<<endl;
    cout<<"_________________________________"<<endl;
    cout<<endl;
    cout << "1. Display all products " << endl;
    cout << "2. Add new customer" << endl;
    cout << "3. Add new product" << endl;
    cout << "4. Customer purchase product" << endl;
    cout << "5. Search Customer and orders" << endl;
    cout << "6. EXIT" << endl;
    cout<<"_________________________________"<<endl;
    cout<<endl;

}

void write(vector<Customer *> &customerList)
{
    for (int i = 0; i < customerList.size(); i++)
    {
        ofstream fout("customer.txt");
        fout << customerList[i]->getName() << "," << customerList[i]->getGetPhoneNumber() << endl;
        fout.close();
    }
}

int main()
{

    vector<Customer *> customerList;
    vector<Product *> ProductList;
    int choice;

    do
    {
        menu();
        cin >> choice;

        switch (choice)
        {
        case 1:
        {
            for (int i = 0; i < ProductList.size(); i++)
            {
                ProductList[i]->displayData();
            }

            break;
        }

        case 2:
        {
            Customer *c = new Customer();
            c->acceptData();
            customerList.push_back(c);
            break;
        }
        case 3:
        {
            Product *p = new Product();
            p->acceptData();
            ProductList.push_back(p);
            break;
        }
        case 4:
        {
            string phoneNumber;
            cout << "Enter phone number to purchase product: ";
            cin >> phoneNumber;

            for (int i = 0; i < customerList.size(); i++)
            {
                if (customerList[i]->getGetPhoneNumber() == phoneNumber)
                {
                    for (int j = 0; j < ProductList.size(); j++)
                    {
                        ProductList[j]->displayData();
                    }

                    int productId;
                    cout << "Enter product id to purchase: ";
                    cin >> productId;

                    customerList[i]->addProducts(ProductList, productId);
                }
            }

            break;
        }
        case 5:
        {
            string phoneNumber;
            cout << "Enter phone number of customer: ";
            cin >> phoneNumber;
            for (int i = 0; i < customerList.size(); i++)
            {
                customerList[i]->displayProducts();
            }
            break;
        }
        case 6:
        {
            cout << "Thank you for using app" << endl;
            break;
        }

        default:
        {
            cout << "Wrong choice" << endl;
            break;
        }
        }

    } while (choice != 6);

    write(customerList);

    return 0;
}
