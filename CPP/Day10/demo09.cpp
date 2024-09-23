#include <iostream>
#include <vector>
using namespace std;

class Product
{
    int pid;
    string pname;
    double price;
};

class Customer
{
    int cid;
    string cname;
    string mobile;
    vector<Product *> purchasedProducts; // Association

public:
    void purchaseProduct(vector<Product *> &productList)
    {
        int id;
        // productList -> display -> using for
        cout << "Enter product id to purchase -  ";
        cin >> id;

        // find the product for the entered pid.
        // if(id == productList[i])

        // add the selecetd product in purchasedProducts vector
        // purchasedProducts.push_back(productList[i]);
    }

    void displaypurchasedProduct()
    {
        // for loop on purchasedProducts
    }
};

class Employee
{
    int empid;
    string name;
    double salary;
    // Date doj;
};

int main()
{
    // vector<Employee *> employeeList;
    vector<Customer *> customerList; // multiple customers
    vector<Product *> productList;   // list of products for selling
    Product *p = new Product();
    // p->accept();
    productList.push_back(p); // to sell

    Customer *c = new Customer();
    // c->accept();
    customerList.push_back(c);

    // find the customer who  wants to purchase a product
    //  int index = findcustomer(customerList);
    // customerList[index] -> purchaseProduct(productList);

    // display all products purchased by the specific customer
    //  int index = findcustomer(customerList);
    // customerList[index] -> displaypurchasedProduct();

    // display all customers and their purchased products
    // for loop on customerList
    // customerList[i] -> display();
    // customerList[i] -> displaypurchasedProduct();
    return 0;
}