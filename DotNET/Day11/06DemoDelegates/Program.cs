using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _06DemoDelegates
{
    delegate bool MyDelegate(int i);

    internal class Program
    {
        static void Main(string[] args)
        {
            MyDelegate pointer1 = new MyDelegate(Check);
            //bool result =  Check(200);
            bool result = pointer1(200);
            Console.WriteLine(result);
            Console.ReadLine();
        }

        public static bool Check(int i)
        {
            return i > 10;
        }

    }
}
