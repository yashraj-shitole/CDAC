using System;
using System.Diagnostics;
using System.Linq.Expressions;

namespace _18DemoPerfExpressionTree
{
    //delegate bool MyDelegate(int i);
    //delegate P MyDelegate<P,Q>(Q i);
    internal class Program
    {
        static void Main(string[] args)
        {

            //MyDelegate pointer = new MyDelegate(Check);

            //MyDelegate pointer = delegate (int i)
            //                            {
            //                                return i > 10;
            //                            };

            //MyDelegate pointer = (i)=>
            //                        {
            //                            return i > 10;
            //                        };


            //MyDelegate<bool,int> pointer = (i) =>
            //                                    {
            //                                        return i > 10;
            //                                    };


            //Func<int, bool> pointer = (i) =>
            //                                    {
            //                                        return i > 10;
            //                                    };

            //1. Create Expression Tree
            Expression<Func<int, bool>> tree = (i) => i > 10;

            //2. Compile Expression Tree
            Func<int, bool> pointer = tree.Compile();

            Stopwatch sw = new Stopwatch();


            sw.Start();
            //bool result = Check(20);
            //bool result = pointer(20);
            bool result = pointer(20);//3: Execute Compiled Expression Tree
            sw.Stop();

            Console.WriteLine(result);
            Console.WriteLine("Time Taken = {0}",sw.ElapsedTicks);

            Console.ReadLine();
        }

        

        //public static bool Check(int i)
        //{
        //    return i > 10;
        //}
    }
}
