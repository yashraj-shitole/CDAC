using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _21DemoDB.Helper
{
    public class Logger
    {
        private static Logger logger = new Logger();
        private Logger() { }

        public static Logger CurrentLogger { get { return logger; } }
        
        public void Log(string message)
        {
            string filePath = "C:\\KDAC Dot Net\\log.txt";

            FileStream fileStream = null;
            if (File.Exists(filePath))
            {
                fileStream = new FileStream(filePath, FileMode.Append, FileAccess.Write);
            }
            else
            {
                fileStream = new FileStream(filePath, FileMode.OpenOrCreate, FileAccess.Write);
            }

            StreamWriter writer = new StreamWriter(fileStream);
            writer.WriteLine("Logged at {0} : {1}", DateTime.Now.ToString(), message);

            writer.Close();
            fileStream.Close();
            writer = null;
            fileStream = null;

        }
    
    }
}
