#include <iostream>
using namespace std;

class BankAccount
{
    const int accno;
    string name;
    double balance;
    static int generate_accno;

public:
    BankAccount() : accno(++generate_accno)
    {
        // accno = ++generate_accno;
        name = "";
        balance = 0;
    }
    BankAccount(string name, double balance) : accno(++generate_accno)
    {
        // accno = ++generate_accno;
        this->name = name;
        this->balance = balance;
    }

    void displayAccountBalance()
    {
        cout << "Accno = " << accno << endl;
        cout << "Name = " << name << endl;
        cout << "Balance = " << balance << endl;
    }
};
int BankAccount::generate_accno = 1000;
int main()
{
    BankAccount a1;
    BankAccount a2("Mukesh", 20000);
    BankAccount a3("Ramesh", 30000);
    BankAccount a4("Suresh", 40000);

    a1.displayAccountBalance();
    a2.displayAccountBalance();
    a3.displayAccountBalance();
    a4.displayAccountBalance();
    return 0;
}