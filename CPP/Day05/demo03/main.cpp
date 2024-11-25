#include "employee.h"

int main()
{
    Employee e1;
    e1.acceptEmployee();
    e1.displayEmployee();
    Employee e2(2, "Mukesh", 20000);
    e2.displayEmployee();
    return 0;
}