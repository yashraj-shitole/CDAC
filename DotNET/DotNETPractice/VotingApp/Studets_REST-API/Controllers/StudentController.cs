using Microsoft.AspNetCore.Mvc;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace Studets_REST_API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class StudentController : ControllerBase
    {
            
        private readonly MyDbContext context;

        public StudentController(MyDbContext context)
        {
            this.context = context;
        }




        // GET: api/<StudentController>
        [HttpGet]
        public List<Student> Get()
        {

            List<Student> list = context.Students.ToList() ;

            return list;
        }

        // GET api/<StudentController>/5
        [HttpGet("{id}")]
        public Student Get(int id)
        {
            List<Student> list = context.Students.ToList();

            foreach (Student s  in list)
            {
                if (s.Id == id)
                {
                    return s;
                }
                
            }

            return null;
        }

        // POST api/<StudentController>
        [HttpPost]
        public JsonResult Post(Student student)
        {
            //Student s = new Student();

            //context.
            context.Students.Add(student);
            context.SaveChanges();

            return new JsonResult(Ok(student));
         } 

        // PUT api/<StudentController>/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {


        }

        // DELETE api/<StudentController>/5
        [HttpDelete("{id}")]
        public JsonResult Delete(int id)
        {
            Student s = context.Students.Find(id);
            if (s == null)
            {
                return new JsonResult(NotFound());
            }

            context.Students.Remove(s);

            return new JsonResult(Ok("Deleted"));

        }
    }
}
