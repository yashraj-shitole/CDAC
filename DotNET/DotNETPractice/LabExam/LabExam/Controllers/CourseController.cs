using LabExam.Model;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;

namespace LabExam.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class CourseController : ControllerBase
    {
        string connectionString;
        public CourseController() {

            connectionString = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=NewDatabase;Integrated Security=True";
        }


        [HttpGet]
        public IEnumerable<Courses> Get()
        {
            List<Courses> courseList = new List<Courses>();
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();
            string query = "select * from Courses";
            SqlCommand command = new SqlCommand(query, connection);
            SqlDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                Courses course = new Courses()
                {
                    CourseId = Convert.ToInt32(reader[0]),
                    CourseName = reader[1].ToString(),
            };
               
                courseList.Add(course);

            }
            connection.Close();

            return courseList;
        }




        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();

            string query = "delete from courses where CourseId=@id";
            string query2 = "update CourseStudent set StudentId=null where CourseId=@id";

            SqlCommand command = new SqlCommand(query, connection);
            SqlCommand cmd2 = new SqlCommand(query2, connection);
        

            SqlParameter param = new SqlParameter("@id", id);


            command.Parameters.Add(param);


            command.ExecuteNonQuery();

           
            connection.Close();
        }

    }
}
