// Q3. Stack is a Last-In-First-Out data structure. Write a Stack class. It implements stack using
// Dynamically allocated array. Stack size should be passed in parameterized constructor. If size is not
// given, allocate stack of size 5.
// Provide member functions like push(), pop(), peek(), isEmpty(), isFull(), and print().

#include <iostream>
using namespace std;


class Stack{

 int* arr;
 int top;
 int size;

public:
Stack(){

}
Stack(int arrSize=5){
    
    arr=new int[arrSize];
    top=-1;
    size=arrSize;
}

void push(int x){
    if (isFull())
    {
        cout<<"Stack is full"<<endl;
        return ;
    }
    
    arr[++top]=x;
    cout<<x<<" pushed into stack"<<endl;

}

int pop(){
    if (isEmpty())
    {
        cout<<"Stack is empty"<<endl;
        return -1;
    }
    cout<<arr[top]<<" poped from stack"<<endl;
    return arr[top--];
}

int peek(){
    if (isEmpty())
    {
        cout<<"Stack is empty"<<endl;
        return -1;
    }
    return arr[top];
}

bool isEmpty(){

    return top == -1;
}

bool isFull(){

    return top == size - 1;


}

void printStack(){
     if (isEmpty())
    {
        cout<<"Stack is empty"<<endl;
        return;
    }
    cout<<"______"<<endl;
    for (int i = 0; i <= top; i++)
    {
        cout<<"| "<<arr[i]<<endl;

    }
    cout<<"______"<<endl;


}


};

int main(){


int choice;
int sizeOfStack;
cout<<"Enter size of stack"<<endl;
cin>>sizeOfStack;
Stack s(sizeOfStack);
system("CLS");


while (1)
{
        cout << "Enter your choice" << endl;
        cout << "1.Push" << endl;
        cout << "2.Pop" << endl;
        cout << "3.Peek" << endl;
        cout << "4.Print stack" << endl;
        cout << "5.EXIT" << endl;
        cin>>choice;

        switch (choice)
        {
        case 1:{
            system("CLS");
            int x;
            cout<<"Enter elemet to push."<<endl;
            cin>>x;
            s.push(x);
            break;
        }
        case 2:{
            system("CLS");
            s.pop();
            break;
        }
        case 3:{
            system("CLS");
            cout<<s.peek()<<" is top element of stack"<<endl;
            break;
        }
        case 4:{
            system("CLS");
            s.printStack();
            break;
        }
        case 5:{
            return 0;
            break;
        }
        
        default:
            cout<<"Wrong choice"<<endl;
            break;
        }
}


    return 0;
}