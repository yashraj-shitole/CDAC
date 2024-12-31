#include <iostream>
using namespace std;
namespace NAttendance::NEmployee
{
    class Employee
    {
    };
    void saveEmployee()
    {
    }
    void loadEmployee();
}

namespace NAttendence::NStudent
{
    class Student
    {
    };
    void saveStudent();
    void loadStudent();
}

int main()
{
    int num1;
    int *ptr;

    num1 = NULL;
    // num1 = nullptr; // NOT OK
    // ptr = NULL; // OK But not recommended
    ptr = nullptr;
    return 0;
}