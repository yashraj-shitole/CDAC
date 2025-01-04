using Microsoft.Data.SqlClient;

namespace _20DemoDB
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //string connectionDetails = "data source = (LocalDB)\\MSSQLLocalDB;database=KDACDB;integrated security=true";

            string connectionDetails = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=KDACDB;Integrated Security=True";

            #region Simple Select Query
            //SqlConnection connection = new SqlConnection(connectionDetails);
            //connection.Open();

            //string queryText = "select * from Emp";

            //SqlCommand command = new SqlCommand(queryText, connection);
            //SqlDataReader reader = command.ExecuteReader();

            //List<Emp> empList = new List<Emp>();

            //while (reader.Read())
            //{
            //    Emp emp = new Emp()
            //    {
            //        No = Convert.ToInt32(reader["No"]),
            //        Name = reader["Name"].ToString(),
            //        Address = reader["Address"].ToString()
            //    };

            //    empList.Add(emp);
            //}

            //connection.Close();
            //foreach (var emp in empList)
            //{
            //    Console.WriteLine("{0}  |  {1}  | {2}", emp.No, emp.Name,emp.Address);
            //} 
            #endregion

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


            Console.ReadLine();
        }
    }

    public class Emp
    {
        public int No { get; set; }
        public string Name { get; set; }
        public string Address { get; set; }
    }
}
