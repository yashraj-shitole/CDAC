using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;
using WebApi_Ado.Models;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace WebApi_Ado.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EmpController : ControllerBase
    {
        string connectionDetails;
        public EmpController()
        {
            connectionDetails = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=Employee;Integrated Security=True";
        }
        // GET: api/<EmpController>
        [HttpGet]
        public IEnumerable<Emp> Get()
        {
            List<Emp> list = new List<Emp>();
            SqlConnection connection = new SqlConnection(connectionDetails);
            connection.Open();

            string query = "Select *from Emp";

            SqlCommand cmd = new SqlCommand(query, connection);
            SqlDataReader reader = cmd.ExecuteReader();
            while (reader.Read())
            {
                Emp emp = new Emp()
                {
                    No = Convert.ToInt32(reader["No"]),
                    Name = reader["Name"].ToString(),
                    Address = reader["address"].ToString(),
                };
               list.Add(emp);
            }
            connection.Close();
            return list;
        }
            
    

        // GET api/<EmpController>/5
        [HttpGet("No/{No}")]
        public Emp Get(int No)
        {
           SqlConnection connection = new SqlConnection(connectionDetails);
            connection.Open();

            string queryText = "select * from Emp where No = @No";

            //string query = string.Format(queryText, No);

            SqlCommand sqlCommand = new SqlCommand(queryText, connection);

            sqlCommand.Parameters.AddWithValue("@No", No);

            SqlDataReader reader = sqlCommand.ExecuteReader();

            //List<Emp> list = new List<Emp>();

            Emp emp = null; 

            while (reader.Read())
            {
                emp = new Emp()
                {
                    No = Convert.ToInt32(reader["No"]),
                    Name = reader["Name"].ToString(),
                    Address = reader["Address"].ToString(),
                };
                //list.Add(emp);
            }

            connection.Close();
            return emp;

        }

        // POST api/<EmpController>
        [HttpPost]
        public void Post([FromBody] Emp emp)
        {
            SqlConnection connection = new SqlConnection(connectionDetails);
            connection.Open();

            string query = "Insert Into Emp values(@Name , @Address)";

            SqlCommand sqlCommand = new SqlCommand( query, connection);

            sqlCommand.Parameters.AddWithValue("@Name", emp.Name);
            sqlCommand.Parameters.AddWithValue("@Address", emp.Address);

            sqlCommand.ExecuteNonQuery();

            connection.Close();
        }

        // PUT api/<EmpController>/5
        [HttpPut]
        public void Put([FromBody] Emp emp)
        {
            SqlConnection connection = new SqlConnection( connectionDetails);
            connection.Open();

            string query = "Update Emp set Name = @Name , Address = @Address where No = @No";

            SqlCommand cmd = new SqlCommand( query, connection);
            cmd.Parameters.AddWithValue("@No", emp.No);
            cmd.Parameters.AddWithValue("@Name", emp.Name);
            cmd.Parameters.AddWithValue("@Address" , emp.Address);

            cmd.ExecuteNonQuery();

            connection.Close();
        }

        // DELETE api/<EmpController>/5
        [HttpDelete("No/{No}")]
        public void Delete(int No)
        {
            SqlConnection connection = new SqlConnection(connectionDetails);
            connection.Open();

            string query = "Delete from Emp where No = @No";

            SqlCommand sqlCommand1 = new SqlCommand( query, connection);

            sqlCommand1.Parameters.AddWithValue("@No", No);

            sqlCommand1.ExecuteNonQuery();

            connection.Close();
        }
    }
}
