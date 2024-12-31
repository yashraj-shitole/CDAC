using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EmployeeLib;

//2.Write a class Person with following members:
// string name; bool gender; Date birth; -----------------------------------------------------------
//string address; ----------------------------------------------------------------------------------
//Provide following functionality:
//Default constructor ------------------------------------------------------------------------------
//Parameterized constructor
//Properties: Name, Gender, Birth, Address and Age(Read Only)
//Accept() method to accept data from console.
//Print() method to print data to console.
//string ToString(); method to return data of object in string format.
//Hint: Class will contain Date object for birth and Age will be calculculated using
//static method in Date class.


namespace EmployeeLib
{
    public class Person
    {
		private string _Name;
		private bool _Gender;
		private Date _Birth;
		private string _Address;

		public Person(){
		}

	public Person()
		{

		}

		public string Address
		{
			get { return _Address; }
			set { _Address = value; }
		}


		public Date Birth
		{
			get { return _Birth; }
			set { _Birth = value; }
		}


		public bool Gender
		{
			get { return _Gender; }
			set { _Gender = value; }
		}


		public string Name
		{
			get { return _Name; }
			set { _Name = value; }
		}

	}
}
