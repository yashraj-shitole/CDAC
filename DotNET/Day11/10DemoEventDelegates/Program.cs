using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10DemoEventDelegates
{
    internal class Program
    {
        //Developer No 2 : Consumer of SQL Server Class /Code
        static void Main(string[] args)
        {
            SQLServer sqlServer = new SQLServer();
            MyLogDelegate pointer = new MyLogDelegate(Developer2LogCode);
            sqlServer.QueryExecuted += pointer;

            //MyLogDelegate pointer = new MyLogDelegate(Logger.CurrentLogger.Log);
            //sqlServer.QueryExecuted += pointer;

            sqlServer.Insert();
            Console.ReadLine();
        }

        public static void Developer2LogCode(string message)
        {
            //User of SQL Server class OR Developer2
            //is going to write his / her own logic about log
            //person may log in DB / FILE/ EMail /Whatsapp/ Excel / etc etc

            Console.WriteLine("MY LOG - " + message );
        }
    }


    //Developer No 1: Creator of the class / code

    public delegate void MyLogDelegate(string message);

    #region SQL Server Class - Version 2

    public class SQLServer
    {
        public event MyLogDelegate QueryExecuted;
        public void Insert()
        {
            Console.WriteLine("SQL Server Record Inserted..");
            QueryExecuted("SQL DATA ADDED");
        }

        public void Update()
        {
            Console.WriteLine("SQL Server Record Updated..");
            QueryExecuted("SQL DATA UPDATED");
        }

        public void Delete()
        {
            Console.WriteLine("SQL Server Record Deleted..");
            QueryExecuted("SQL DATA DELETED");
        }
    }

    #endregion

    #region SQL Server Class - Version 1
    //public class SQLServer
    //{
    //    public void Insert()
    //    {
    //        Console.WriteLine("SQL Server Record Inserted..");
    //        Logger.CurrentLogger.Log("SQL Data ADDED");
    //    }

    //    public void Update()
    //    {
    //        Console.WriteLine("SQL Server Record Updated..");
    //        Logger.CurrentLogger.Log("SQL Data UPDATED");
    //    }

    //    public void Delete()
    //    {
    //        Console.WriteLine("SQL Server Record Deleted..");
    //        Logger.CurrentLogger.Log("SQL Data DELETED");
    //    }
    //} 
    #endregion


    public class Logger
    {
        private static Logger logger = new Logger();
        private Logger() { }

        public static Logger CurrentLogger { get { return logger; } }

        public void Log(string message)
        {
            //Log message over console
            Console.WriteLine("LOGGED at Console : " + 
                               DateTime.Now.ToString () + " - " + message);

            //Log message inside log file
            //Code HERE 
            //Code Here

            //Log message inside Database
            //Code HERE 
            //Code Here

            //Log message Over email
            //Code HERE 
            //Code Here

        }
    }
}
