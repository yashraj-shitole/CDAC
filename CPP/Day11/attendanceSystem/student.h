#ifndef STUDENT_H
#define STUDENT_H
#include "person.h"
class Student : public Person
{
    int rollno;
    double marks;

public:
    void accept();
    void display();
};
#endif