using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MathsLib;
namespace _00DemoBasics
{
    internal class Program
    {
        static void Main(string[] args)
        {
            #region How to use command line arguments

            //Console.WriteLine("Command Line Arguments received are : ");

            //for (int i = 0; i < args.Length; i++)
            //{
            //    Console.WriteLine(args[i]);
            //}

            #endregion

            #region Simple Array

            //int[] arr = new int[] { 1, 2, 3 };

            ////int[] arr = new int[3];
            ////arr[0] = 1;
            ////arr[1] = 2;
            ////arr[2] = 3;

            ////for (int i = 0; i < arr.Length; i++)
            ////{
            ////    Console.WriteLine(arr[i]);
            ////}

            //foreach (int i in arr)
            //{
            //    Console.WriteLine(i);
            //}

            #endregion

            #region Switch Case, Calling MathsLib.DLL Code

            //Maths obj = new Maths();

            //while (true)
            //{
            //    Console.WriteLine("Enter Your Choice");
            //    Console.WriteLine("1: Add, 2: Sub, 3 : Exit");
            //    int choice = Convert.ToInt32(Console.ReadLine());

            //    switch (choice)
            //    {
            //        case 1:
            //            Console.WriteLine("Enter value of X");
            //            string xValue = Console.ReadLine();
            //            int x = Convert.ToInt32(xValue);

            //            Console.WriteLine("Enter value of Y");
            //            string yValue = Console.ReadLine();
            //            int y = Convert.ToInt32(yValue);
            //            int result = obj.Add(x, y);
            //            Console.WriteLine(result);

            //            break;

            //        case 2:
            //            Console.WriteLine("Enter value of X");
            //            string xValue1 = Console.ReadLine();
            //            int x1 = Convert.ToInt32(xValue1);

            //            Console.WriteLine("Enter value of Y");
            //            string yValue1 = Console.ReadLine();
            //            int y1 = Convert.ToInt32(yValue1);
            //            int result1 = obj.Sub(x1, y1);
            //            Console.WriteLine(result1);
            //            break;

            //        default:
            //            break;

            //    }
            //    if (choice != 1 && choice != 2)
            //    {
            //        break;
            //    }
            //}

            #endregion
        }
    }
}
