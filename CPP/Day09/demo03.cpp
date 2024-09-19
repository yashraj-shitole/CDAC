#include <iostream>
#include <fstream>
using namespace std;

void write()
{
    ofstream fout("file1.txt", ios::app);
    fout << "Hello" << endl;
    fout.close();
}
void read()
{
    ifstream fin("file1.txt");
    string line;
    while (getline(fin, line))
    {
        cout << line << endl;
    }
    fin.close();
}
int main()
{
    // cout << "Hello" << endl;
    // write();
    read();
    return 0;
}