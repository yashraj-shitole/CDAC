#include <iostream>
using namespace std;

class Singleton
{

    // step-3 : Create a static datamamber of ptr type of the same class
    static Singleton *ptr;

    // step-1 : Make the ctor private
private:
    Singleton()
    {
        cout << "Singleton Ctor" << endl;
    }

public:
    // step-2 : Create an static function that will return
    // the instance of this class
    static Singleton *getInstance()
    {
        // step-5 : check if ptr is null, then only create
        //  the instance of this class else return the ptr as it is
        if (ptr == NULL)
            ptr = new Singleton;
        return ptr;
    }
};
// step-4 : Initialize the static data member to NULL
Singleton *Singleton::ptr = NULL;

int main()
{
    Singleton *s1 = Singleton::getInstance();
    Singleton *s2 = Singleton::getInstance();
    Singleton *s3 = Singleton::getInstance();
    Singleton *s4 = Singleton::getInstance();
    return 0;
}