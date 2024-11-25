#include <iostream>
using namespace std;

class BankAccount
{
    const int accno;
    string name;
    double balance;

public:
    BankAccount(int accno) : accno(accno)
    {
        name = "";
        balance = 0;
    }

    void acceptDetails()
    {
        cout << "Enter name - ";
        // cin >> name;
        getline(cin, name);
        cout << "Enter initial balance - ";
        cin >> balance;
    }

    void deposit()
    {
        double amount;
        cout << "Enter the amount to deposit -";
        cin >> amount;
        balance = balance + amount;
    }
    void withdraw()
    {
        // TO-DO
    }

    void displayAccountDetails() const
    {
        // balance = 1000; // NOT OK
        cout << "Accno - " << accno << endl;
        cout << "Name - " << name << endl;
        cout << "Balance - " << balance << endl;
    }

    int getAccno() const
    {
        return accno;
    }
    string getName() const
    {
        return name;
    }
    double getBalance() const
    {
        return balance;
    }
};

int main()
{
    BankAccount a1(1001);
    a1.acceptDetails();
    a1.displayAccountDetails();
    BankAccount a2(1002);
    a2.acceptDetails();
    a2.displayAccountDetails();
    return 0;
}