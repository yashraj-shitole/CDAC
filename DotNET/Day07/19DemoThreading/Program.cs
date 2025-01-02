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


            List<Thread> threads = new List<Thread>();
            List<Task> tasks = new List<Task>();

            Stopwatch sw = Stopwatch.StartNew();

            #region Execute 100 Threads to call DoSOmething 100 times
            //for (int i = 0; i < 100; i++)
            //{
            //    Thread thread = new Thread(DoSomething);
            //    threads.Add(thread);
            //    thread.Start();
            //}

            //foreach (Thread thread in threads)
            //{
            //    thread.Join();//We are asking main thread to wait till each child finishes
            //}
            #endregion


            #region Explicit Parallel Programming
            //Explicit: We create tasks by ourselves

            //for (int i = 0; i < 100; i++)
            //{
            //    Task task = new Task(DoSomething);
            //    tasks.Add(task);
            //    task.Start();
            //}

            //Task.WaitAll(tasks.ToArray());

            #endregion

            sw.Stop();

            Console.WriteLine("Time taken = {0}" , sw.ElapsedMilliseconds);

            Console.ReadLine();

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
