using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _12DemoGenerics
{
    #region Understand the need for Template / Generics
    //internal class Program
    //{
    //    static void Main(string[] args)
    //    {
    //        int p = 100;
    //        int q = 200;

    //        //string format = "Before Swap p = {0}, q = {1}";
    //        //string message = string.Format(format, p, q);
    //        //Console.WriteLine(message);

    //        Console.WriteLine("Before Swap p = {0}, q = {1}",p, q);
    //        Maths maths = new Maths();
    //        maths.Swap(ref p, ref q);

    //        Console.WriteLine("After Swap p = {0}, q = {1}", p, q);
    //        Console.ReadLine();

    //    }
    //}

    //public class Maths
    //{
    //    public void Swap(ref int x,ref int y)
    //    {
    //        int z = x;
    //        x = y;
    //        y = z;
    //    }

    //    public void Swap(ref string x, ref string y)
    //    {
    //        string z = x;
    //        x = y;
    //        y = z;
    //    }
    //}
    #endregion

    #region Using simple Generics
    internal class Program
    {
        static void Main(string[] args)
        {
            #region Swap Int
            //int p = 100;
            //int q = 200;

            //Console.WriteLine("Before Swap p = {0}, q = {1}", p, q);

            //Maths<int> maths = new Maths<int>();
            //maths.Swap(ref p, ref q);

            //Console.WriteLine("After Swap p = {0}, q = {1}", p, q);

            #endregion

            #region Swap String

            //string s1 = "Hello";
            //string s2 = "Hi";

            //Console.WriteLine("Before Swap s1 = {0}, s2 = {1}",s1, s2);

            //Maths<string> obj = new Maths<string>();
            //obj.Swap(ref s1, ref s2);

            //Console.WriteLine("After Swap s1 = {0}, s2 = {1}", s1, s2);

            #endregion

            #region V1: Demo
            //Maths<short> maths = new Maths<short>();
            //int result = maths.Add(10, 20);
            //Console.WriteLine(result);
            #endregion

            #region V2: Demo
            //Maths obj = new Maths();

            //int result = obj.Add(10, 20);
            //Console.WriteLine(result);

            //int p = 100;
            //int q = 200;

            //Console.WriteLine("Before Swap p = {0}, q = {1}", p, q);
            //obj.Swap<int>(ref p, ref q);
            //Console.WriteLine("After Swap p = {0}, q = {1}", p, q);

            #endregion

            #region V3 : Demo - Inherit Generic Class in NonGeneric Class
            //int p = 100;
            //int q = 200;

            //Console.WriteLine("Before Swap p = {0}, q = {1}", p, q);

            //SpecialMaths maths = new SpecialMaths();
            //maths.Swap(ref p, ref q);

            //Console.WriteLine("After Swap p = {0}, q = {1}", p, q);

            #endregion

            #region V3 : Demo - Inherit Generic Class in Generic Class
            //int p = 100;
            //int q = 200;

           

            //SpecialMaths<int, short, string, bool> maths =
            //    new SpecialMaths<int, short, string, bool>();

            //bool result = maths.NonsenseMethod(10, 2, "abd", true);
            //Console.WriteLine("Result of Nonsense method is " + result);

            //Console.WriteLine("Before Swap p = {0}, q = {1}", p, q);
            //maths.Swap(ref p, ref q);

            //Console.WriteLine("After Swap p = {0}, q = {1}", p, q);

            #endregion

            Console.ReadLine();

        }
    }

    #region V3:Inheritance in Generic Class 
    //public class Maths<T>
    //{
    //    public void Swap(ref T x, ref T y)
    //    {
    //        T z = x;
    //        x = y;
    //        y = z;
    //    }
    //}

    #region V3 : Inherit Generic Class in NonGeneric Class
    //public class SpecialMaths : Maths<int>
    //{
    //    public S NonsenseMethod(P para1, Q para2, R para3, S para4)
    //    {
    //        return para4;
    //    }
    //}
    #endregion

    #region V3 : Inherit Generic Class in Generic Class
    //public class SpecialMaths<P, Q, R, S> : Maths<P>
    //{
    //    public S NonsenseMethod(P para1, Q para2, R para3, S para4)
    //    {
    //        return para4;
    //    }
    //} 
    #endregion

    #endregion

    #region V2:  NonGeneric Class with Generic Method + Non Generic Method
    //public class Maths
    //{
    //    public int Add(int x, int y)
    //    {
    //        return x + y;
    //    }
    //    public void Swap<T>(ref T x, ref T y)
    //    {
    //        T z = x;
    //        x = y;
    //        y = z;
    //    }
    //}

    #endregion

    #region V1: Generic Class with Generic Method + Non Generic Method
    public class Maths<T>
    {
        public int Add(int x, int y)
        {
            return x + y;
        }
        public void Swap(ref T x, ref T y)
        {
            T z = x;
            x = y;
            y = z;
        }
    }

    #endregion

    #endregion
}
