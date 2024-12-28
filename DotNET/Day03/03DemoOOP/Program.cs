using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _03DemoOOP
{
    internal class Program
    {
        static void Main(string[] args)
        {
            IY obj1 = new Maths();  
           
        }
    }

    public interface IX
    {
        int Add(int x, int y);
        int Sub(int x, int y);
    }


    public interface IY
    {
        int Mult(int x, int y);
        int Div(int x, int y);
    }

    public class Maths: IX, IY
    {
        public int Add(int x, int y) { 
            return x + y;
        }

        public int Sub(int x, int y)
        {
            return x - y;
        }

        public int Mult(int x, int y)
        {
            return x * y;
        }

        public int Div(int x, int y)
        {
            return x / y;
        }
    }

}
