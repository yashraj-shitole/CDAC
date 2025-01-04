using Microsoft.Data.SqlClient;
using System.Data;
namespace _22DemoDB
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string connectionDetails = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=KDACDB;Integrated Security=True";

            SqlConnection sqlConnection = new SqlConnection(connectionDetails);

            Console.WriteLine("Enter Name");
            SqlParameter parameter1 = new SqlParameter("@name",
                                                    SqlDbType.VarChar, 50);
            parameter1.Value = Console.ReadLine();

            Console.WriteLine("Enter Address");
            SqlParameter parameter2 = new SqlParameter("@address", 
                                                    SqlDbType.VarChar, 50);
            parameter2.Value = Console.ReadLine();

            SqlCommand sqlCommand = new SqlCommand("AddEmployee", sqlConnection);
            sqlCommand.CommandType = CommandType.StoredProcedure;

            sqlCommand.Parameters.Add(parameter1);
            sqlCommand.Parameters.Add(parameter2);

            sqlConnection.Open();
            int rowsAffected = sqlCommand.ExecuteNonQuery();

            sqlConnection.Close();

        }
    }
}
