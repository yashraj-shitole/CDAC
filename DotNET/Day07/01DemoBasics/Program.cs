using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _01DemoBasics
{
    public class Program
    {
        static void Main(string[] args)
        {
            #region Call Getter Setter Like C++
            //Person person = new Person();
            //person.setName("Mahesh");
            //Console.WriteLine(person.getName());

            #endregion

            #region Call Getter Setter C# Way

            //Person person = new Person();
            //person.Name = "Mahesh";     //Setter is called.
            //Console.WriteLine(person.Name); //Getter is called.

            #endregion

            #region Person, Employee Class / Inheritance
            //Person person = new Person();
            //person.Name = "Mahesh";
            //person.No = 10;
            //person.Address = "Pune";

            //string details =  person.GetDetails();
            //Console.WriteLine(details);


            //Employee employee = new  Employee();
            //employee.Name = "Mahesh";
            //employee.No = 10;
            //employee.Address = "Pune";
            //employee.DName = "IT";

            //string details = employee.GetDetails();
            //Console.WriteLine(details);
            #endregion

            #region Value Type, reference type and premitives
            //int i = 100;
            //Student s;
            //s.No = 10;
            //s.Name = "Mahesh";

            //string s = "abcd";

            //String s = new String(new char['a', 'b', 'c', 'd']);


            #endregion

            //Employee employee = new Employee();
            //Console.WriteLine(employee.GetDetails()) ;

            Employee employee = new Employee(8, "yuvraj", "chandigad", "sports");
            Console.WriteLine(employee.GetDetails());

            Console.ReadLine();
        }
    }

    public struct Student
    {
        public int No;
        public string Name ;
    }

    public class Person
    {
        #region C++ Like Syntax For Private Member and Getter / Setter
        //private string _Name;

        //public void setName(string name)
        //{
        //    _Name = name;
        //}
        //public string getName()
        //{
        //    return _Name;
        //}
        #endregion

        #region Writing Property in .NET

        private int _No;
        private string _Name;
        private string _Address;

        public string Address
        {
            get { return _Address; }
            set { _Address = value; }
        }

        public string Name
        {
            get { return _Name; }
            set { _Name = value; }
        }

        public int No
        {
            get { return _No; }
            set { _No = value; }
        }


        #endregion

        public Person()
        {
            No = 0;
            Name = "";
            Address = "";
        }

        public virtual string GetDetails()
        {
            return No.ToString() + Name + Address;
        }

    }

    public class Employee : Person
    {
        public Employee()
        {
            No = 100;
            Name = "Sachin";
            Address = "Mumbai";
            DName = "IT";
        }

        public Employee(int no, string name, string address, string dname)
        {
            No = no;
            Name = name;
            Address = address;
            DName = dname;
        }


        private string _DName;

        public string DName
        {
            get { return _DName; }
            set { _DName = value; }
        }
        public override string GetDetails()
        {
            return base.GetDetails() + DName;
        }

    }
}
