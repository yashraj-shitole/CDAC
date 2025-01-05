using System.Collections;
using System.Linq;

namespace _17DemoFeatures
{
    internal static class Program
    {
        static void Main(string[] args)
        {
            #region Partial Class
            //Maths obj = new Maths();
            //Console.WriteLine(obj.Add(10, 20));
            //Console.WriteLine(obj.Sub(10, 20));
            #endregion

            #region Nullable Type
            //int? salary = null;

            ////Nullable<int> salary = null;

            ////Nullable<int> salary = 0;

            ////Nullable<int> salary = 100;

            //Console.WriteLine(salary.HasValue);
            #endregion

            #region Indexer Usage
            //Dictionary<string, string> arr =
            //    new Dictionary<string, string>();

            //arr.Add("a1", "abcd");
            //arr.Add("a2", "xyz");

            //string data = arr["a2"];
            //Console.WriteLine(data);
            #endregion

            #region Iterator

            //ArrayList arr = new ArrayList();

            //foreach (object item in arr)
            //{

            //}

            //Week week = new Week();
            //foreach (string day in week)
            //{
            //    Console.WriteLine("welcome " + day);
            //}

            #endregion

            #region Implicit Type
            //int i = 100; //stack
            //object obj = i;

            //Emp emp = new Emp(); //heap
            //obj = emp;

            //var i = 100;//this statement changed to int i=100
            //            //by compiler using relfection
            //            //after that i is strictly typed to "int"
            //            //i = true;   //error on this line ...

            //var j = new Emp();//this statement changed to 
            //           //Emp j = new Emp() by compiler     
            //j.Name = "abcd";
            //j.Address = "pune";
            //j.No = 199;

            //int choice = Convert.ToInt32(Console.ReadLine());

            //var v = Factory.GetMeSomething(choice);
            #endregion

            #region Object Initializer + Using Auto Property
            ////Emp emp = new Emp();
            ////emp.No = 100;
            ////emp.Name = "Sachin";
            ////emp.Address = "Mumbai";

            //Emp emp = 
            //    new Emp() { No = 100, Name = "Sachin", Address = "Mumbai" };


            //Console.WriteLine("No : {0}, Name : {1}, Address: {2}", 
            //                    emp.No,emp.Name, emp.Address);

            #endregion

            #region Anonymous Type
            //var v =new { No = 100, Name = "Sachin", Address = "Mumbai" };

            //Console.WriteLine(v.GetType());


            //var v1 = new { Name = "Sachin", No = 100, Address = "Mumbai" };

            //Console.WriteLine(v1.GetType());


            //Console.WriteLine("No : {0}, Name : {1}, Address: {2}",
            //                    v.No, v.Name, v.Address);



            //var v3 = new { No = 100, Name = "Sachin", Address = "Mumbai" };
            //Console.WriteLine(v3.Name);
            //v3.Name = "Changed";
            #endregion

            #region Extension Method
            //string str = "a@b.com";

            ////bool result = MyExtension.CheckForValidEMailAddress(str,100);
            //bool result = str.CheckForValidEMailAddress(100);
            //Console.WriteLine(result);


            ////int []arr = new int[] {10,20,30,40,50};
            ////var avg = arr.Average();
            ////Console.WriteLine(avg);
            #endregion

            #region Create Sample Employee Collection
            
            List<Emp> emps = new List<Emp>()
            {
                new Emp(){ No = 11, Name = "Jayesh", Address="Jalna" },
                new Emp(){ No = 12, Name = "Rudra", Address="Mumbai" },
                new Emp(){ No = 13, Name = "Shekhar", Address="Solapur" },
                new Emp(){ No = 14, Name = "Makarand", Address="Kolhapur" },
                new Emp(){ No = 15, Name = "Rushikesh", Address="Baramati" },
                new Emp(){ No = 16, Name = "Swapnil", Address="Shrigonda" },
            };

            #endregion

            #region Filter Data using ForEach Loop
            //List<Emp> result = new List<Emp>();

            //foreach (var emp in emps)
            //{
            //    if (emp.Address.Contains("r"))
            //    {
            //        result.Add(emp);
            //    }
            //}

            //foreach (var item in result)
            //{
            //    Console.WriteLine(item.Name + " | " + item.Address);
            //}
            #endregion

            #region Simple LINQ
            //var result = (from emp in emps
            //              where emp.Address.Contains("r")
            //              select emp);

            //foreach (var item in result)
            //{
            //    Console.WriteLine(item.Name + " | " + item.Address);
            //} 
            #endregion

            #region LINQ - Differed / Lazy Execution POC

            //Query Executes while for each calls result
            //var result = (from emp in emps
            //              where emp.Address.Contains("r")
            //              select emp);

            //var result = (from emp in emps
            //              where emp.Address.Contains("r")
            //              select emp).ToList(); //Query Executes Here since we call ToList - which is extension Method!!

            //emps.Add(new Emp() { No = 90, Name = "Sudhir", Address = "Rahuri" });

            //foreach (var item in result)
            //{
            //    Console.WriteLine(item.Name + " | " + item.Address);
            //}

            #endregion

            #region LINQ: Select only Name from Collection Objects
            //var result = (from emp in emps
            //              where emp.Address.Contains("r")
            //              select emp.Name);

            //foreach (var empName in result)
            //{
            //    Console.WriteLine(empName);
            //} 
            #endregion

            #region Select No, Name from Collection Objects

            ////var result = (from emp in emps
            ////              where emp.Address.Contains("r")
            ////              select new ResultHolder()
            ////              {
            ////                  ENo = emp.No, 
            ////                  EName = "Mr / Mrs " + emp.Name 
            ////              });

            //var result = (from emp in emps
            //              where emp.Address.Contains("r")
            //              select new 
            //              {
            //                  ENo = emp.No,
            //                  EName = "Mr / Mrs " + emp.Name
            //              }).ToList();

            //foreach (var item in result)
            //{
            //    Console.WriteLine(item.ENo.ToString() + " | " + item.EName);
            //}

            #endregion

            #region How to use our own Where Method 

            //Func<Emp, bool> pointer = new Func<Emp, bool>(Check);

            //Func<Emp, bool> pointer = delegate (Emp emp)
            //                            {
            //                                return emp.Address.Contains("r");
            //                            };


            //var result = Where(emps, pointer);
            //var result = emps.Where(pointer);

            //var result = emps.Where((Emp emp) =>
            //                        {
            //                            return emp.Address.Contains("r");
            //                        });

            //foreach (var item in result)
            //{
            //    Console.WriteLine(item.Name + " | " +  item.Address);
            //}
            #endregion

            #region How LINQ uses Extension Methods like Where, Select

            //var result = emps.Where((emp) => 
            //                        { 
            //                            return emp.Address.Contains("r"); 
            //                        })
            //                 .Select((emp) => { return emp.Name; });


            ////foreach (var item in result)
            ////{
            ////    Console.WriteLine(item.Name + " | " + item.Address);
            ////}

            //foreach (var item in result)
            //{
            //    Console.WriteLine(item);
            //}
            #endregion

            #region Dynamic Type

            //Console.WriteLine("Enter Choice Number");
            //int choice = Convert.ToInt32(Console.ReadLine());

            //Console.WriteLine("Your choice is " + choice);

            //dynamic obj = Factory.GetMeSomething(choice);
            //Console.WriteLine(obj.GetDetails());

            ////object obj = Factory.GetMeSomething(choice);

            ////if (obj is Emp)
            ////{
            ////    Emp e = (Emp)obj;
            ////    Console.WriteLine(e.GetDetails());
            ////}
            ////else if(obj is Book)
            ////{
            ////    Book book = (Book)obj;
            ////    Console.WriteLine(book.GetBookDetails());
            ////}

            #endregion

            #region Optional & Named Parameter
            //Emp emp = new Emp();
            //emp.PrintDetails(10, "Sachin","Chennai");
            //emp.PrintDetails(10, "Sachin");
            //emp.PrintDetails(10, "Chetan");
            //emp.PrintDetails(10);
            //emp.PrintDetails(10,address: "Chandigadh");
            //emp.PrintDetails(10, address: "Chandigadh", name: "Punit");

            #endregion

            Console.ReadLine();
        }

        #region How to write our own Where Method
        //public static List<Emp> Where(this List<Emp> emps, Func<Emp, bool> pointer)
        //{
        //    List<Emp> result = new List<Emp>();
        //    foreach (Emp emp in emps)
        //    {
        //        if (pointer(emp))
        //        {
        //            result.Add(emp);
        //        }
        //    }
        //    return result;
        //}



        //public static bool Check(Emp emp)
        //{
        //    return emp.Address.Contains("r");
        //}
        #endregion
    }

    public class ResultHolder
    {
        public int ENo { get; set; }
        public string EName { get; set; }
    }
    public static class MyExtension
    {
        // public static bool CheckForValidEMailAddress<T>(this T str, int i)
        public static bool CheckForValidEMailAddress(this string str, int i)
        {
            //Logic to check the string here
            //------------------------------
            //------------------------------
            return true;
        }
    }
    public class Factory
    {
        public static object GetMeSomething(int choice)
        {
            if (choice == 10)
            {
                return new Emp() { No = 1, Name = "abc", Address = "pune" };
            }
            else
            {
                return new Book();
            }
        }
    }
    public class Book
    {
        public string GetBookDetails()
        {
            return "Some book";
        }
    }
    public class Emp
    {
        #region Auto Property
            public int No { get; set; }
            public string Name { get; set; }
            public string Address { get; set; }

        #endregion

        public string GetDetails()
        {
            return string.Format("{0}, | {1}, | {2}", No, Name, Address);
        }

        public void PrintDetails(int no, string name="Sachin", string address="Pune")
        {
            Console.WriteLine("{0} | {1} | {2}", no, name, address);
        }

        #region Normal Property + Variables
        //private int _No;
        //private string _Name;
        //private string _Address;

        //public string Address
        //{
        //    get { return _Address; }
        //    set { _Address = value; }
        //}

        //public string Name
        //{
        //    get { return _Name; }
        //    set { _Name = value; }
        //}

        //public int No
        //{
        //    get { return _No; }
        //    set { _No = value; }
        //}
        #endregion
    }
    public class Week: IEnumerable
    {
        private string[] Days = new string[] {"Mon", "Tue", "Wed", "Thu", "Fri","Sat","Sun" };

        public IEnumerator GetEnumerator()
        {
            for (int i = 0; i < Days.Length; i++)
            {
                yield return Days[i];
            }
        }
    }
}
