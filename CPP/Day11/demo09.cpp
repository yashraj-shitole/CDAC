#include <iostream>
#include <vector>
using namespace std;
class LessPriceException
{
    int pid;
    string message;
    int price;

public:
    LessPriceException(string message)
    {
        this->message = message;
    }
    LessPriceException(int pid, double price, string message)
    {
        this->pid = pid;
        this->price = price;
        this->message = message;
    }

    void printStackTrace()
    {
        cout << "Exception - LessPriceException" << endl;
        cout << "Message - " << message << endl;
        cout << "Product Deatils, Pid - " << pid << endl;
        cout << "Entered price - " << price << endl;
    }
};
class Product
{
    int pid;
    string pname;
    double price;

public:
    Product()
    {
    }
    Product(int pid, string pname, double price)
    {
        this->pid = pid;
        this->pname = pname;
        this->price = price;
    }

    int getPid()
    {
        return pid;
    }

    void acceptProduct()
    {
        cout << "Enter pid - ";
        cin >> pid;
        cout << "Enter name - ";
        cin >> pname;
        double p;
        cout << "Enter price - ";
        cin >> p;
        if (p <= 0)
            // throw 2;
            // throw LessPriceException("Price is less than 0");
            throw LessPriceException(pid, p, "Price is less than 0");
        price = p;
    }
    void displayProduct()
    {
        cout << "Pid - " << pid << endl;
        cout << "Name - " << pname << endl;
        cout << "Price - " << price << endl;
    }
};

class Customer
{
    int cid;
    string cname;
    string mobile;
    vector<Product *> purchasedProducts; // Association

public:
    Customer()
    {
    }
    Customer(int cid, string cname, string mobile)
    {
        this->cid = cid;
        this->cname = cname;
        this->mobile = mobile;
    }

    int getCId()
    {
        return cid;
    }

    void acecptCustomer()
    {
        cout << "Enter cid - ";
        cin >> cid;
        cout << "Enter name - ";
        cin >> cname;
        cout << "Enter mobile - ";
        cin >> mobile;
    }
    void displayCustomer()
    {
        cout << "Cid - " << cid << endl;
        cout << "Name - " << cname << endl;
        cout << "Mobile - " << mobile << endl;
    }
    void purchaseProduct(vector<Product *> &productList)
    {
        cout << "Product List --->>>>" << endl;
        for (int i = 0; i < productList.size(); i++)
            productList[i]->displayProduct();

        int id;
        cout << "Enter product id to purchase -  ";
        cin >> id;

        // find the product for the entered pid.
        for (int i = 0; i < productList.size(); i++)
            if (id == productList[i]->getPid())
                purchasedProducts.push_back(productList[i]);
    }

    void displaypurchasedProduct()
    {
        for (int i = 0; i < purchasedProducts.size(); i++)
            purchasedProducts[i]->displayProduct();
    }
};

int findcustomer(vector<Customer *> &customerList)
{
    int id;
    cout << "Enter cid to search - ";
    cin >> id;
    for (int i = 0; i < customerList.size(); i++)
        if (customerList[i]->getCId() == id)
            return i;
    return -1;
}

int main()
{
    vector<Customer *> customerList; // multiple customers
    vector<Product *> productList;   // list of products for selling
    Product *p = new Product();
    try
    {
        p->acceptProduct();
        productList.push_back(p); // to sell
    }
    catch (int e)
    {
        cout << "Price cannot be less than 0.." << endl;
    }
    catch (LessPriceException e)
    {
        e.printStackTrace();
    }
    productList.push_back(new Product(2, "Pen", 5));
    productList.push_back(new Product(3, "Pencil", 2));

    Customer *c = new Customer();
    c->acecptCustomer();
    customerList.push_back(c);
    customerList.push_back(new Customer(2, "Mukesh", "567890"));

    // find the customer who  wants to purchase a product
    if (int index = findcustomer(customerList); index != -1)
        customerList[index]->purchaseProduct(productList);

    // display all products purchased by the specific customer
    if (int index = findcustomer(customerList); index != -1)
        customerList[index]->displaypurchasedProduct();

    // display all customers and their purchased products
    // for loop on customerList
    for (int i = 0; i < customerList.size(); i++)
    {
        customerList[i]->displayCustomer();
        customerList[i]->displaypurchasedProduct();
    }

    return 0;
}