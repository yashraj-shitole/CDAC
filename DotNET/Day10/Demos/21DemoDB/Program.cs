using _21DemoDB.DAL;
using _21DemoDB.Helper;
using _21DemoDB.POCO;
using Microsoft.Data.SqlClient;

namespace _21DemoDB
{
    internal class Program
    {
        static void Main(string[] args)
        {
            EmpOperations empOperations = new EmpOperations();

            while (true)
            {
                Console.WriteLine("1: Select, 2: Insert, 3: Update, 4: Delete");
                Console.WriteLine("Enter Choice");

                int choice = Convert.ToInt32(Console.ReadLine());
                Logger.CurrentLogger.Log("DB Choice Given " + choice);

                switch (choice)
                {
                    case 1:
                        List<Emp> empList = empOperations.GetEmployees();
                        foreach (var emp in empList)
                        {
                            Console.WriteLine("{0}  |  {1}  | {2}", emp.No, emp.Name, emp.Address);
                        }
                        Logger.CurrentLogger.Log("Select Called");
                        break;

                    case 2:
                        Emp empToAdd = new Emp();
                        Console.WriteLine("Enter Name");
                        empToAdd.Name = Console.ReadLine();

                        Console.WriteLine("Enter Address");
                        empToAdd.Address = Console.ReadLine();

                        int rowsAffected = empOperations.AddEmployee(empToAdd);
                        Console.WriteLine("Rows Affected = {0}", rowsAffected);
                        Logger.CurrentLogger.Log("Insert Called");
                        break;
                    
                    case 3:
                        Emp empToUpdate = new Emp();
                        Console.WriteLine("Enter No of Record To Udpate");
                        empToUpdate.No = Convert.ToInt32(Console.ReadLine());

                        Console.WriteLine("Enter New Name");
                        empToUpdate.Name = Console.ReadLine();

                        Console.WriteLine("Enter New Address");
                        empToUpdate.Address = Console.ReadLine();

                        int rowsAffected1 = empOperations.UpdateEmployee(empToUpdate);
                        Console.WriteLine("Rows Affected = {0}", rowsAffected1);
                        Logger.CurrentLogger.Log("Update Called");
                        break;
                    
                    case 4:
                        Console.WriteLine("Enter No of Record To Remove");
                        int No = Convert.ToInt32(Console.ReadLine());
                        int rowsAffected2 = empOperations.RemoveEmployee(No);
                        Console.WriteLine("Rows Affected = {0}", rowsAffected2);
                        Logger.CurrentLogger.Log("Delete Called");
                        break;

                    default:
                        break;
                }

                Console.WriteLine("Do you want to contnue? Y / N");
                string exitChoice = Console.ReadLine();
                if (exitChoice == "N")
                {
                    break;
                }
            }

            #region Simple Insert Query

            //SqlConnection connection = new SqlConnection(connectionDetails);
            //connection.Open();

            //string queryTextFormat = "insert into Emp(Name, Address) values ('{0}', '{1}')";

            //Console.WriteLine("Enter Name");
            //string Name = Console.ReadLine();

            //Console.WriteLine("Enter Address");
            //string Address = Console.ReadLine();

            //string queryText = string.Format(queryTextFormat, Name, Address);

            //SqlCommand command = new SqlCommand(queryText, connection);
            //int rowsAffected = command.ExecuteNonQuery();
            //connection.Close();

            //Console.WriteLine("Rows Affected = {0}", rowsAffected);
            #endregion

            #region Simple Update Query

            //SqlConnection connection = new SqlConnection(connectionDetails);
            //connection.Open();

            //string queryTextFormat = "update Emp set Name ='{1}',Address= '{2}' where No = {0}";

            //Console.WriteLine("Enter No of record to update the record");
            //int No = Convert.ToInt32(Console.ReadLine());

            //Console.WriteLine("Enter New Name");
            //string Name = Console.ReadLine();

            //Console.WriteLine("Enter New Address");
            //string Address = Console.ReadLine();

            //string queryText = string.Format(queryTextFormat, No, Name, Address);

            //SqlCommand command = new SqlCommand(queryText, connection);
            //int rowsAffected = command.ExecuteNonQuery();
            //connection.Close();

            //Console.WriteLine("Rows Affected = {0}", rowsAffected);

            #endregion

            #region Simple Delete Query

            //SqlConnection connection = new SqlConnection(connectionDetails);
            //connection.Open();

            //string queryTextFormat = "delete from emp where No = {0}";

            //Console.WriteLine("Enter No of record to delete the record");
            //int No = Convert.ToInt32(Console.ReadLine());

            //string queryText = string.Format(queryTextFormat, No);

            //SqlCommand command = new SqlCommand(queryText, connection);
            //int rowsAffected = command.ExecuteNonQuery();
            //connection.Close();

            //Console.WriteLine("Rows Affected = {0}", rowsAffected);

            #endregion


        }
    }
}
