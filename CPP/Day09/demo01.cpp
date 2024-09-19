#include <iostream>
#include <map>
using namespace std;

int main()
{
    map<int, string> m1;
    m1[3] = "Anil";
    m1[2] = "Mukesh";
    m1[5] = "Ramesh";
    m1[1] = "Suresh";
    m1[5] = "Sham";

    cout << m1[2] << endl;
    map<int, string>::iterator itr = m1.begin();
    while (itr != m1.end())
    {
        cout << itr->first << " - " << itr->second << endl;
        itr++;
    }
    return 0;
}