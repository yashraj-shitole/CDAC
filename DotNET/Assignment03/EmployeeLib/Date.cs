using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


//1.Write class Date with following members:
//int day; int month; int year; ------------------------------------------------------------
//Provide following functionality: 
//Default constructor ----------------------------------------------------------------------
//Parameterized constructor ----------------------------------------------------------------
//Properties: Day, Month and Year ----------------------------------------------------------
//AcceptDate() method to accept data from console. -----------------------------------------
//PrintDate() method to print data to console. ---------------------------------------------
//bool IsValid(); method to check validity of date. ----------------------------------------
//string ToString(); method to return data of object in string format. ---------------------
//Also provide a static member function that returns difference between
//two date objects in number of years. -----------------------------------------------------
//Overload “-” operator to perform the same job.  ------------------------------------------


namespace EmployeeLib
{
    public class Date
    {

        private int _Day;
        private int _Month;
        private int _Year;


        //overloaded date to get difference between years of two dates
        public static int operator -(Date date, Date date)
        {
            return (uint)date1._Year - date2._Year;
        }

        public static int  YearDifference(Date date1,Date date2)
        {
            return  date1-date2;
        }

        public Date()
        {
        }

        public Date(int day, int month, int year)
        {
            _Day = day;
            _Month = month;
            _Year = year;
        }

       

        public void AcceptDate()
        {
            Console.WriteLine("Enter day month year in DD-MM-YYYY format");
            String date = Console.ReadLine();
            int day = Convert.ToInt32(date.Substring(0, 2));
            int month = Convert.ToInt32(date.Substring(3, 2));
            int year = Convert.ToInt32(date.Substring(6, 4));
            if (IsValid(day, month, year))
            {
                _Day = day;
                _Month = month;
                _Year = year;
            }
            else
            {
                Console.WriteLine("Wrong date entered");
            }

        }

        public void PrintDate()
        {
            Console.WriteLine(_Day + "-" + _Month + "-" + _Year);
        }

        public bool IsValid(int day, int month, int year)
        {

            if (month <= 12 && day <= 31)
            {
                return true;
            }
            else return false;

        }

        override
        public string ToString()
        {
            return _Day+"-"+_Month+"-"+_Year;
        }



        public int Year
        {
            get { return _Year; }
            set { _Year = value; }
        }


        public int Month
        {
            get { return _Month; }
            set { _Month = value; }
        }


        public int Day
        {
            get { return _Day; }
            set { _Day = value; }
        }


    }
}
