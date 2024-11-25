#include <iostream>
#include <vector>
using namespace std;

int main()
{
    vector<int> v1;
    v1.push_back(10);
    v1.push_back(20);
    v1.push_back(30);

    v1.insert(v1.begin() + 2, 40);
    v1.erase(v1.begin() + 1);

    for (int i = 0; i < v1.size(); i++)
        cout << "Element = " << v1[i] << endl;

    return 0;
}

int main2()
{
    vector<int> v1;
    v1.push_back(10);
    v1.push_back(20);
    v1.push_back(30);
    v1.push_back(40);
    v1.push_back(50);
    cout << "Capacity of vector - " << v1.capacity() << endl;
    cout << "Size of vector - " << v1.size() << endl;
    // v1[7] = 30;
    cout << "Element at index 9 = " << v1[9] << endl;
    return 0;
}

int main1()
{
    vector<int> v1;
    v1.push_back(10);
    v1.push_back(20);
    v1.push_back(30);
    v1.push_back(40);
    v1.push_back(50);

    cout << "Capacity of vector - " << v1.capacity() << endl;
    cout << "Size of vector - " << v1.size() << endl;

    cout << "Element at index 2 = " << v1.at(2) << endl;
    cout << "Element at index 2 = " << v1[2] << endl;

    for (int i = 0; i < v1.size(); i++)
        // cout << "Element = " << v1.at(i)<< endl;
        cout << "Element = " << v1[i] << endl;
    return 0;
}