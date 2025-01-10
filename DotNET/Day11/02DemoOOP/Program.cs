using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02DemoOOP
{
    internal class Program
    {
        static void Main(string[] args)
        {
            ReportFactory reportFactory = new ReportFactory();
            Console.WriteLine("1: PDF, 2: DOCX, 3: TXT, 4: XML, 5: JSON");
            
            int choice = Convert.ToInt32(Console.ReadLine());

            Logger.CurrentLogger.Log("Choice Given is " + choice);

            Report report = reportFactory.GetReport(choice);

            Logger.CurrentLogger.Log("Calling GenerateReport");
           
            report.GenerateReport();
           
            Console.ReadLine();
        }
    }
    public abstract class Report
    {
        protected abstract void CreateReport();
        protected abstract void ParseReport();
        protected abstract void ValidateReport();
        protected abstract void SaveReport();
      
        public virtual void GenerateReport()
        {
            CreateReport();
            ParseReport();
            ValidateReport();
            SaveReport();
        }
    }
    public class PDF : Report
    {
        protected override void SaveReport()
        {
            Console.WriteLine("PDF Saved");
            Logger.CurrentLogger.Log("SAVE PDF Function Called.");
        }

        protected override void ValidateReport()
        {
            Console.WriteLine("PDF Validated");
            Logger.CurrentLogger.Log("Validate PDF Function Called.");
        }

        protected override void ParseReport()
        {
            Console.WriteLine("PDF Parsed");
            Logger.CurrentLogger.Log("Parse PDF Function Called.");
        }

        protected override void CreateReport()
        {
            Console.WriteLine("PDF Created");
            Logger.CurrentLogger.Log("Create PDF Function Called.");
        }

       
    }
    public class DOCX : Report
    {
        protected override void SaveReport()
        {
            Console.WriteLine("DOCX Saved");
        }

        protected override void ValidateReport()
        {
            Console.WriteLine("DOCX Validated");
        }

        protected override void ParseReport()
        {
            Console.WriteLine("DOCX Parsed");
        }

        protected override void CreateReport()
        {
            Console.WriteLine("DOCX Created");
        }
      
    }
    public class TXT : Report
    {
        protected override void SaveReport()
        {
            Console.WriteLine("TXT Saved");
        }

        protected override void ValidateReport()
        {
            Console.WriteLine("TXT Validated");
        }

        protected override void ParseReport()
        {
            Console.WriteLine("TXT Parsed");
        }

        protected override void CreateReport()
        {
            Console.WriteLine("TXT Created");
        }
    }
    public abstract class  SpecialReport : Report
    {
        protected abstract void ReValidateReport();
        public override void GenerateReport()
        {
            CreateReport();
            ParseReport();
            ValidateReport();
            ReValidateReport();
            SaveReport();
        }
    }
    public class XML : SpecialReport
    {
        protected override void SaveReport()
        {
            Console.WriteLine("XML Saved");
        }

        protected override void ValidateReport()
        {
            Console.WriteLine("XML Validated");
        }

        protected override void ReValidateReport()
        {
            Console.WriteLine("XML Re-Validated");
        }

        protected override void ParseReport()
        {
            Console.WriteLine("XML Parsed");
        }

        protected override void CreateReport()
        {
            Console.WriteLine("XML Created");
        }

      
    }
    public class JSON : SpecialReport
    {
        protected override void SaveReport()
        {
            Console.WriteLine("JSON Saved");
        }

        protected override void ValidateReport()
        {
            Console.WriteLine("JSON Validated");
        }

        protected override void ReValidateReport()
        {
            Console.WriteLine("JSON Re-Validated");
        }

        protected override void ParseReport()
        {
            Console.WriteLine("JSON Parsed");
        }

        protected override void CreateReport()
        {
            Console.WriteLine("JSON Created");
        }

      
    }
    public class ReportFactory
    {
        public Report GetReport(int  choice)
        {
            if (choice == 1)
            {
                return new PDF();
            }
            else if (choice == 2)
            {
                return new DOCX();
            }
            else if (choice == 3)
            {
                return new TXT() ;
            }
            else if (choice == 4)
            {
                return new XML();
            }
            else
            {
                return new JSON() ;
            }
        }
    }

    public class Logger
    {
        private static Logger logger = new Logger();
        private Logger()
        {
            Console.WriteLine("NEW Logger Object Created");
        }
        
        public static Logger CurrentLogger
        {
            get { return logger; }
        }
        public void Log(string message)
        {
            Console.WriteLine("Logged at " + DateTime.Now.ToString() +
                               " : " + message);
        }
    }

}
