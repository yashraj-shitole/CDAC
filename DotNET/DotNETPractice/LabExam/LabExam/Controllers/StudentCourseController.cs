using LabExam.Model;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;

namespace LabExam.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class StudentCourseController : ControllerBase
    {


        string connectionString;
        public StudentCourseController()
        {

            connectionString = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=NewDatabase;Integrated Security=True";
        }

        [HttpPost]
        public void Post(int cId,int sId)
        {
            SqlConnection connection = new SqlConnection(connectionString);
            connection.Open();
            string query = "insert into CourseStudent values(@pcId,@psId)";
            SqlCommand cmd = new SqlCommand(query, connection);
            SqlParameter @pcId = new SqlParameter("@pcId", cId);
            SqlParameter @psId = new SqlParameter("@psId", sId);
            cmd.Parameters.Add(@pcId);
            cmd.Parameters.Add(@psId);

            cmd.ExecuteNonQuery();
            connection.Close();

        }



    }
}
