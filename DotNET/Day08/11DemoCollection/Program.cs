using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _11DemoCollection
{
    internal class Program
    {
        static void Main(string[] args)
        {
            #region Boxing Unboxing
            //int i = 100;    //Stack
            //object obj = i; //Heap  //Boxing
            //int j = Convert.ToInt32(obj);//UbBoxing
            //Console.WriteLine(  j);
            #endregion

            #region Int Array
            //int[] arr = new int[] { 10, 20, 30 };
            //int[] arr = new int[3];
            //arr[0] = 10;
            //arr[1] = 20;
            //arr[2] = 30;


            //for (int i = 0; i < arr.Length; i++)
            //{
            //    Console.WriteLine(arr[i]);
            //}

            //foreach (int i in arr)
            //{
            //    Console.WriteLine(i);
            //}
            #endregion

            #region Emp Objects Declared / Defined

            Emp emp1 = new Emp();
            emp1.No = 1;
            emp1.Name = "Mahesh";
            emp1.Address = "Pune";

            Emp emp2 = new Emp();
            emp2.No = 2;
            emp2.Name = "Nilesh";
            emp2.Address = "Panji";

            Emp emp3 = new Emp();
            emp3.No = 3;
            emp3.Name = "Ganesh";
            emp3.Address = "Puri";

            #endregion

            #region Simple Casting
            //object obj = emp1;
            ////Emp emp = (Emp)obj;

            //Emp emp = obj as Emp;
            #endregion

            #region Simple Emp Array
            //Emp[] arr = new Emp[] { emp1, emp2, emp3 };

            ////Emp[] arr = new Emp[3];
            ////arr[0] = emp1;
            ////arr[1] = emp2;
            ////arr[2] = emp3;

            //foreach (Emp emp in arr)
            //{
            //    Console.WriteLine("Welcome  " + emp.Name);
            //}
            #endregion

            #region Object Array

            //object[] arr = new object[4];
            //arr[0] = emp1;
            //arr[1] = "abcd";
            //arr[2] = 103;
            //arr[3] = true;

            //foreach (object obj in arr)
            //{
            //    if (obj is Emp)
            //    {
            //        Emp emp = (Emp)obj;
            //        Console.WriteLine("Welcome " + emp.Name);
            //    }
            //    else if (obj is int)
            //    {
            //        //int i = Convert.ToInt32(i);
            //        int i = (int)obj;
            //        Console.WriteLine(i);
            //    }
            //    else if (obj is string)
            //    {
            //        //string s = obj.ToString();
            //        //string s = Convert.ToString(obj);
            //        string s = (string)obj;
            //        Console.WriteLine(s);
            //    }
            //    else
            //    {
            //        Console.WriteLine("Unknown type of data!");
            //    }
            //} 
            #endregion

            #region ArrayList

            //ArrayList arr = new ArrayList();
            //arr.Add(emp1);
            //arr.Add("abcd");
            //arr.Add(103);
            //arr.Add(true);
            //arr.Add(emp2);

            //foreach (object obj in arr)
            //{
            //    if (obj is Emp)
            //    {
            //        Emp emp = (Emp)obj;
            //        Console.WriteLine("Welcome " + emp.Name);
            //    }
            //    else if (obj is int)
            //    {
            //        //int i = Convert.ToInt32(i);
            //        int i = (int)obj;
            //        Console.WriteLine(i);
            //    }
            //    else if (obj is string)
            //    {
            //        //string s = obj.ToString();
            //        //string s = Convert.ToString(obj);
            //        string s = (string)obj;
            //        Console.WriteLine(s);
            //    }
            //    else
            //    {
            //        Console.WriteLine("Unknown type of data!");
            //    }
            //}
            #endregion

            #region Find Something from ArrayList 
            //ArrayList emps = new ArrayList();
            //while (true) 
            //{
            //    Emp emp = new Emp();

            //    Console.WriteLine( "Enter ENo");
            //    emp.No = Convert.ToInt32(Console.ReadLine());

            //    Console.WriteLine("Enter EName");
            //    emp.Name = Console.ReadLine();

            //    Console.WriteLine("Enter EAddress");
            //    emp.Address = Console.ReadLine();

            //    emps.Add(emp);

            //    Console.WriteLine("Do you want to continue?");
            //    string choice = Console.ReadLine();
            //    if (choice == "no")
            //    {
            //        break;
            //    }
            //}

            ////foreach (object obj in emps)
            ////{
            ////    Emp emp =   (Emp)obj;
            ////    Console.WriteLine("Welcome " + emp.Name + " from " + emp.Address );
            ////}


            //Console.WriteLine(  "Enter No of the EMp to find ");
            //int NotoFind = Convert.ToInt32(Console.ReadLine());

            //foreach (object obj in emps)
            //{
            //    Emp emp = (Emp)obj;
            //    if (emp.No == NotoFind)
            //    {
            //        Console.WriteLine("Welcome " + emp.Name + " from " + emp.Address);
            //        break;
            //    }
            //}
            #endregion

            #region HashTable

            //Hashtable arr = new Hashtable();
            //arr.Add(emp1.No, emp1);
            //arr.Add(emp2.No, emp2);
            //arr.Add(emp3.No, emp3);
            //arr.Add(99, "abcd");
            //arr.Add(77, new Book("Let us C"));



            //Console.WriteLine("Enter Key to find Value");
            //int key = Convert.ToInt32(Console.ReadLine());

            //object obj = arr[key];

            //if (obj !=null)
            //{

            //    if (obj is Emp)
            //    {
            //        Emp emp = (Emp)obj;
            //        Console.WriteLine("welcome " + emp.Name);
            //    }
            //    else if (obj is string)
            //    {
            //        string s = obj.ToString();
            //        Console.WriteLine(s);
            //    }
            //    else if (obj is Book)
            //    {
            //        Book book = (Book)obj;
            //        Console.WriteLine(book.Title);
            //    }
            //    else
            //    {
            //        Console.WriteLine("Unknown type of data");
            //    }
            //}
            //else
            //{
            //    Console.WriteLine("Could not find object!");
            //}

            #endregion

            #region List<T>
            //List<Emp> arr = new List<Emp>();   
            //arr.Add(emp1);
            //arr.Add(emp2);
            //arr.Add(emp3);
            ////arr.Add(100);

            //foreach (Emp emp in arr)
            //{
            //    Console.WriteLine("Welcome " + emp.Name);
            //}
            #endregion

            #region Stack<T>

            //Stack<Emp> arr = new Stack<Emp>();
            //arr.Push(emp1);
            //arr.Push(emp2);
            //arr.Push(emp3);


            //foreach (Emp emp in arr)
            //{
            //    Console.WriteLine("Welcome " + emp.Name);
            //}

            #endregion

            #region Queue<T>
            //Queue<Emp> arr = new Queue<Emp>();
            //arr.Enqueue(emp1);
            //arr.Enqueue(emp2);
            //arr.Enqueue(emp3);


            //foreach (Emp emp in arr)
            //{
            //    Console.WriteLine("Welcome " + emp.Name);
            //}
            #endregion

            #region Dictionary<Key, Value>
            //Dictionary<int, Emp> arr = new Dictionary<int, Emp>();
            //arr.Add(emp1.No, emp1);
            //arr.Add(emp2.No, emp2);
            //arr.Add(emp3.No, emp3);

            //Console.WriteLine("Enter No to FInd");
            //int no = Convert.ToInt32(Console.ReadLine());

            //Emp empFound = arr[no];

            //Console.WriteLine("Welcome " + empFound.Name);
            #endregion

            Console.ReadLine();
        }
    }
    public class Book
    {
        private string _Title;

        public Book(string title)
        {
            this.Title = title; 
        }
        public string Title
        {
            get { return _Title; }
            set { _Title = value; }
        }

    }

    public class Emp
    {
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

    }
}
