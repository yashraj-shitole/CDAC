using ADO_API.Model;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace ADO_API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class EmpController : ControllerBase
    {
        string connectionDetails;

        public EmpController() {
            connectionDetails = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=class;Integrated Security=True;";
        }  

        // GET: api/<EmpController>
        [HttpGet]

        public List<Emp> Get()
        {
            SqlConnection conn = new SqlConnection(connectionDetails);

            conn.Open();

            string query = "select * from Emp";
            SqlCommand cmd=new SqlCommand(query, conn);
            
            SqlDataReader reader = cmd.ExecuteReader();

            List<Emp> result = new List<Emp>();
            while (reader.Read())
            {
                Emp emp = new Emp()
                {
                    Id = Convert.ToInt32(reader["id"]),
                    Name = reader["name"].ToString(),
                    Address = reader["address"].ToString(),
                };
                result.Add(emp);
            }

            conn.Close();
            return result ;
        }

        // GET api/<EmpController>/5
        [HttpGet("{id}")]
        public string Get(int id)
        {
            return "value";
        }

        // POST api/<EmpController>
        [HttpPost]
        public void Post([FromBody] string value)
        {
        }

        // PUT api/<EmpController>/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE api/<EmpController>/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
