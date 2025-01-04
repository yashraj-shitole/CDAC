using System.Diagnostics;

namespace _19DemoThreading
{
    internal class Program
    {
        static Thread t1;
        static Thread t2;
        static void Main(string[] args)
        {
            #region Simple Threads
            //Stopwatch sw = new Stopwatch();
            //sw.Start();

            #region Main Thread Executing DoSomething 10 Times
            ////for (int i = 0; i < 10; i++)
            ////{
            ////    DoSomething();
            ////}
            #endregion

            #region Multiple Threads(10) working on DoSomething
            //for (int i = 0; i < 10; i++)
            //{
            //    Thread thread = new Thread(new ThreadStart(DoSomething));
            //    thread.Start();
            //}
            #endregion


            //sw.Stop();

            //Console.WriteLine("TIme taken = {0}", sw.ElapsedMilliseconds);
            //Console.WriteLine("Done!");
            #endregion

            #region Thread - Joins

            //t1 = new Thread(F1);
            //t2 = new Thread(F2);

            //t1.Start();
            //t2.Start();
            #endregion

            #region Background Thread
            //Thread t = new Thread(() => {
            //    for (int i = 0; i < 10; i++)
            //    {
            //        Thread.Sleep(1000);
            //        Console.WriteLine(i);
            //    }
            //});

            ////t.IsBackground = true;
            //t.Start();
            #endregion

            #region Parallel Programming - Explicit
            //List<Thread> threads = new List<Thread>();
            //List<Task> tasks = new List<Task>();

            //Stopwatch sw = Stopwatch.StartNew();

            //#region Execute 100 Threads to call DoSOmething 100 times
            ////for (int i = 0; i < 100; i++)
            ////{
            ////    Thread thread = new Thread(DoSomething);
            ////    threads.Add(thread);
            ////    thread.Start();
            ////}

            ////foreach (Thread thread in threads)
            ////{
            ////    thread.Join();//We are asking main thread to wait till each child finishes
            ////}
            //#endregion


            //#region Explicit Parallel Programming
            ////Explicit: We create tasks by ourselves

            ////for (int i = 0; i < 100; i++)
            ////{
            ////    Task task = new Task(DoSomething);
            ////    tasks.Add(task);
            ////    task.Start();
            ////}

            ////Task.WaitAll(tasks.ToArray());

            //#endregion

            //sw.Stop();

            //Console.WriteLine("Time taken = {0}" , sw.ElapsedMilliseconds);
            #endregion

            #region Parallel Programming - Single Thread Vs Many Threads Vs Explicit Vs Implicit

            //string[] files = Directory.GetFiles("C:\\Windows\\System32");

            //Stopwatch stopwatch = new Stopwatch();
            //stopwatch.Start();

            //#region Main Thread Processing All Files
            ////foreach (string file in files)
            ////{
            ////    DoSomethingWithFile();
            ////}
            //#endregion

            //#region Many Threads Processing All Files

            ////List<Thread> threads = new List<Thread>();  

            ////foreach (string file in files)
            ////{
            ////    Thread thread = new Thread(DoSomethingWithFile);
            ////    threads.Add(thread);
            ////    thread.Start();
            ////}

            ////foreach (var thread in threads)
            ////{
            ////    thread.Join();
            ////}

            //#endregion

            //#region Explicit : Many Tasks over Threadpool Threads - Multiple CPUs - Processing All Files

            ////List<Task> tasks = new List<Task>();

            ////foreach (string file in files)
            ////{
            ////    Task task = new Task(DoSomethingWithFile);
            ////    tasks.Add(task);
            ////    task.Start();
            ////}

            ////Task.WaitAll(tasks.ToArray());  

            //#endregion

            //#region Implicit : Many Tasks over Threadpool Threads - Multiple CPUs - Processing All Files

            ////Below line is similar to above foreach loop with tasks
            ////In this case tasks are created automatically
            ////hence - it's called implicit parallel programming 

            ////Parallel.ForEach(files, (file) => { DoSomethingWithFile(); });

            //#endregion


            //stopwatch.Stop();

            //Console.WriteLine("-------------------------");
            //Console.WriteLine("Total Files Processed = {0} in {1} miliseconds", files.Length, stopwatch.ElapsedMilliseconds);

            #endregion

            #region Implicit Parallel Programming using PLINQ 
            //string[] files = Directory.GetFiles("C:\\Windows\\System32");



            //Stopwatch sw = new Stopwatch();
            //sw.Start();

            //#region Use Simple ForEach

            ////List<string> list = new List<string>();
            ////foreach (string file in files)
            ////{
            ////    if (file.Contains(".exe"))
            ////    {
            ////        list.Add(file);
            ////    }
            ////}
            //#endregion

            //#region Simple LINQ instead of For Each

            ////var list = from file in files
            ////           where file.Contains(".exe")
            ////           select file;

            //#endregion

            //#region Parallel LINQ instead of For Each : Implicit Parallel Programming

            //var list = from file in files.AsParallel()
            //           where file.Contains(".exe")
            //           select file;

            //#endregion

            //foreach (var item in list)
            //{
            //    Console.WriteLine(item);
            //}

            //sw.Stop();
            //Console.WriteLine("Time Taken to process EXEs = {0}", sw.ElapsedMilliseconds);

            ////Console.WriteLine("-----------------------------------------");
            ////Console.WriteLine("Total EXEs found = {0}", list.Count);
            #endregion

            Console.ReadLine();

        }

        public static void DoSomethingWithFile()
        {
            Console.WriteLine("Thread Used for File Processing {0}", Thread.CurrentThread.ManagedThreadId);
            for (int i = 0; i < 1000; i++)
            {
                for (int j = 0; j < 100; j++)
                {
                    //As if something complex is happening here
                }
            }
        }

        public static void F1()
        {
            for (int i = 0; i < 10; i++)
            {
                if (i == 3)
                {
                    t2.Join();//Wait for t2 to finish 
                }
                Console.WriteLine("{0} - Printed by Thread# 1", i);
                Thread.Sleep(1000);
            }
        }
        public static void F2()
        {
            for (int i = 10; i > 0; i--)
            {
                if (i == 5)
                {
                    t1.Join();//Wait for t1 to finish 
                }
                Console.WriteLine("{0} - Printed by Thread# 2 ", i);
                Thread.Sleep(1000);
            }
        }

        public static void DoSomething()
        {
            for (int i = 0; i < 1000; i++)
            {
                for (int j = 0; j < 1000; j++)
                {
                    for(int k = 0; k < 500; k++)
                    {
                        //Do nothing
                    }
                }
            }
            Console.WriteLine("Thread executing DoSomesomthing is {0}", Thread.CurrentThread.ManagedThreadId);

        }

    }
}
