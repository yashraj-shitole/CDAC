#include "employee.h"
#include "student.h"
int main()
{
    Person p;
    p.accept();
    p.display();

    Employee e;
    e.accept();
    e.display();

    Student s;
    s.accept();
    s.display();
    return 0;
}