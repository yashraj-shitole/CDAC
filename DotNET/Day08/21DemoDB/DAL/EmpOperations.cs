using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.Data.SqlClient;

using _21DemoDB.POCO;
using _21DemoDB.Helper;

namespace _21DemoDB.DAL
{
    public class EmpOperations
    {
        private string connectionDetails = "";
        public EmpOperations()
        {
            connectionDetails = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=KDACDB;Integrated Security=True";
        }
        public List<Emp> GetEmployees()
        {
            #region Simple Select Query
         
            SqlConnection connection = new SqlConnection(connectionDetails);
            connection.Open();

            string queryText = "select * from Emp";

            SqlCommand command = new SqlCommand(queryText, connection);
            SqlDataReader reader = command.ExecuteReader();

            List<Emp> empList = new List<Emp>();

            while (reader.Read())
            {
                Emp emp = new Emp()
                {
                    No = Convert.ToInt32(reader["No"]),
                    Name = reader["Name"].ToString(),
                    Address = reader["Address"].ToString()
                };

                empList.Add(emp);
            }

            connection.Close();
           
            #endregion

            return empList;
        }
        public int AddEmployee(Emp emp)
        {
            #region Simple Insert Query

            SqlConnection connection = new SqlConnection(connectionDetails);
            connection.Open();

            string queryTextFormat = "insert into Emp(Name, Address) values ('{0}', '{1}')";

            string queryText = string.Format(queryTextFormat, emp.Name, emp.Address);

            SqlCommand command = new SqlCommand(queryText, connection);
            int rowsAffected = command.ExecuteNonQuery();
            connection.Close();

            #endregion

            return rowsAffected;
        }
        public int UpdateEmployee(Emp emp)
        {
            #region Simple Update Query

            SqlConnection connection = new SqlConnection(connectionDetails);
            connection.Open();

            string queryTextFormat = "update Emp set Name ='{1}',Address= '{2}' where No = {0}";

            string queryText = string.Format(queryTextFormat, emp.No, emp.Name, emp.Address);

            SqlCommand command = new SqlCommand(queryText, connection);
            int rowsAffected = command.ExecuteNonQuery();
            connection.Close();
            #endregion

            return rowsAffected;
        }
        public int RemoveEmployee(int No)
        {
            #region Simple Delete Query

            SqlConnection connection = new SqlConnection(connectionDetails);
            connection.Open();

            string queryTextFormat = "delete from emp where No = {0}";

            string queryText = string.Format(queryTextFormat, No);

            SqlCommand command = new SqlCommand(queryText, connection);
            int rowsAffected = command.ExecuteNonQuery();
            connection.Close();

            #endregion

            return  rowsAffected;
        }
    }
}
