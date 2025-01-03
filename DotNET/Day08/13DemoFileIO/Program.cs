using System.IO;
using System.Runtime.Serialization.Formatters.Binary;

namespace _13DemoFileIO
{
    internal class Program
    {
        static void Main(string[] args)
        {
            #region Simple File Write
            //string path = "C:\\KDAC Dot Net\\Data.txt";
            //FileStream fileStream = null;

            //if (File.Exists(path))
            //{
            //    fileStream = 
            //        new FileStream(path, FileMode.Append, FileAccess.Write);
            //}
            //else
            //{
            //    fileStream =
            //        new FileStream(path, FileMode.OpenOrCreate, FileAccess.Write);
            //}

            //StreamWriter writer = new StreamWriter(fileStream);

            //Console.WriteLine("Enter something to write to:");
            //string data = Console.ReadLine();
            //writer.WriteLine(data);

            //writer.Close();
            //fileStream.Close();
            #endregion

            #region Simple File Read
            //string path = "C:\\KDAC Dot Net\\Data.txt";
            //FileStream fileStream = null;

            //if (File.Exists(path))
            //{
            //    fileStream =
            //        new FileStream(path, FileMode.Open, FileAccess.Read);
            //    StreamReader streamReader = new StreamReader(fileStream);
            //    string data = streamReader.ReadToEnd();
            //    Console.WriteLine(data);

            //    streamReader.Close();
            //    fileStream.Close();
            //}
            //else
            //{
            //    Console.WriteLine("File does not exist!");
            //}

            #endregion


            #region Simple Object Write

            string path = "C:\\KDAC Dot Net\\ObjectInFile.txt";
            FileStream fileStream = null;

            if (File.Exists(path))
            {
                fileStream =
                    new FileStream(path, FileMode.Append, FileAccess.Write);
            }
            else
            {
                fileStream =
                    new FileStream(path, FileMode.OpenOrCreate, FileAccess.Write);
            }

            BinaryFormatter specialWriter = new BinaryFormatter();

            Emp emp = new Emp();
            
            Console.WriteLine("Enter No");
            emp.No = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("Enter Name");
            emp.Name = Console.ReadLine();

            Console.WriteLine("Enter Address");
            emp.Address = Console.ReadLine();

            specialWriter.Serialize(fileStream, emp);

            specialWriter = null;
            fileStream.Close();

            #endregion

            Console.ReadLine();
        }
    }

    [Serializable]
    public class Emp
    {
        private int _No;
        private string _Name;
        private string _Address;

        [NonSerialized]
        private string _Password = "abc@123";

        public string Address
        {
            get { return _Address; }
            set { _Address = value; }
        }

        public string Name
        {
            get { return _Name; }
            set { _Name = value; }
        }

        public int No
        {
            get { return _No; }
            set { _No = value; }
        }

    }
}
