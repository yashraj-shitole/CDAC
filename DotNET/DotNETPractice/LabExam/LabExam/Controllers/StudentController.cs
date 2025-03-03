using LabExam.Model;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;

namespace LabExam.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class StudentController : ControllerBase
    {

        string connectionString;
        public StudentController() {

            connectionString = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=NewDatabase;Integrated Security=True";
        }

        [HttpGet]
        public IEnumerable<Students> Get()
        {
            List<Students> students=new List<Students>();
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();
            string query = "select * from Students";
            SqlCommand command = new SqlCommand(query, connection);
            SqlDataReader reader=command.ExecuteReader();
            while (reader.Read())
            {
                Students students1 = new Students()
                {
                    StudentId = Convert.ToInt32(reader[0]),
                    StudentName = reader[1].ToString(),
                    StudentAge= Convert.ToInt32(reader[2]),

                }; 
                students.Add(students1 );

            }
            connection.Close();
          
            return students;
        }
        [HttpPost]
        public void Post(Students students) { 
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();
            string query = "insert into Students values(@pStudentName,@pStudentAge)";
            SqlCommand cmd = new SqlCommand(query, connection);
            SqlParameter @pStudentName = new SqlParameter("@pStudentName",students.StudentName);
            SqlParameter @pStudentAge = new SqlParameter("@pStudentAge", students.StudentAge);
            cmd.Parameters.Add(@pStudentName);
            cmd.Parameters.Add(@pStudentAge);
            cmd.ExecuteNonQuery();
            connection.Close();

        }

       


        




    }
}
