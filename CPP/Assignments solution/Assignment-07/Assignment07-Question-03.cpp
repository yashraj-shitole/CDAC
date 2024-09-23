// Q3. Write a class to store Account information of Bank customer by using following class diagram.
// Use enum to store information of account type.
// Create an array of 5 Accounts in main() and accept their details from user.
// Write Menu driven program to deposit/withdraw amount from the account.
// After each transaction display updated account balance.
// Throw exceptions for invalid values.
// Also implement an exception class InsufficientFundsException.
// In withdraw if sufficient balance is not available in account or while deposit the entered amount is
// negative then throw this exception


#include <iostream>
using namespace std;

// Account enum
enum AccountType {
    SAVINGS,
    CURRENT,
    DMAT
};

// Custom exception
class InsufficientFundsException : public exception {
private:
    int accNo;
    double currBalance;
    double withdrawAmount;

public:
    InsufficientFundsException(int accNo, double currBalance, double withdrawAmount) {
        this->accNo = accNo;
        this->currBalance = currBalance;
        this->withdrawAmount = withdrawAmount;
    }

    
    void display() {
        cout << "Insufficient funds for Account No: " << accNo << endl;
        cout << "Current Balance: " << currBalance << endl;
        cout << "Requested Withdrawal: " << withdrawAmount << endl;
    }
};


// Account class 
class Account {
private:
    int accNo;
    AccountType accType;
    double balance;

public:
    Account() {}

    Account(int accNo, AccountType accType, double balance) {
        this->accNo = accNo;
        this->accType = accType;
        this->balance = balance;
    }

    void accept() {
        cout << "Enter Account Number: ";
        cin >> accNo;
        int type;
        cout << "Select Account Type 0.SAVINGS 1.CURRENT 2.DMAT): ";
        cin >> type;
        accType = static_cast<AccountType>(type);
        cout << "Enter Opening Balance: ";
        cin >> balance;
    }

    void display() {
        cout << "Account Number: " << accNo << "\nAccount Type: ";
        switch (accType) {
            case SAVINGS: cout << "SAVINGS"; break;
            case CURRENT: cout << "CURRENT"; break;
            case DMAT: cout << "DMAT"; break;
        }
        cout << "\nBalance: " << balance << endl;
    }

    void deposit(double amount) {
        if (amount < 0) {
            throw InsufficientFundsException(accNo, balance, amount);
        }
        balance += amount;
        cout << "Deposited: " << amount << "\nUpdated Balance: " << balance << endl;
    }

    void withdraw(double amount) {
        if (amount > balance) {
            throw InsufficientFundsException(accNo, balance, amount);
        }
        balance -= amount;
        cout << "Withdrawn: " << amount << "\nUpdated Balance: " << balance << endl;
    }

    int getAccountNumber() {
        return accNo;
    }
};

int main() {
    Account* accounts[5];

    for (int i = 0; i < 5; i++) {
        accounts[i] = new Account(); 
        cout << "\nEnter details for Account " << i + 1 << ":\n";
        accounts[i]->accept();
    }

    int choice, accNo;
    double amount;
    while (true) {
        cout << "\nMenu: \n1. Deposit \n2. Withdraw \n3. Display Account \n4. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        if (choice == 4) {
            break;
        }

        cout << "Enter Account Number: ";
        cin >> accNo;

        Account* selectedAccount = nullptr;
        for (int i = 0; i < 5; i++) {
            if (accounts[i]->getAccountNumber() == accNo) {
                selectedAccount = accounts[i];
                break;
            }
        }

        if (!selectedAccount) {
            cout << "Account not found.\n";
            continue;
        }

    switch (choice) {
        case 1:  // Deposit
            cout << "Enter amount to deposit: ";
            cin >> amount;
            selectedAccount->deposit(amount);
            break;
        case 2:  // Withdraw
            cout << "Enter amount to withdraw: ";
            cin >> amount;
            selectedAccount->withdraw(amount);
            break;
        case 3:  // Display
            selectedAccount->display();
            break;
        default:
            cout << "Invalid choice.\n";
    }


    }

    return 0;
}
