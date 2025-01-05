using _002DemoMVC.Model;
using Microsoft.AspNetCore.Cors;
using Microsoft.AspNetCore.Mvc;

namespace _002DemoMVC.Controllers
{
    [Route("[controller]")]
    [ApiController]
    [EnableCors]
    public class EmpsController : ControllerBase
    {
        KDACDBContext context = new KDACDBContext();

        [HttpGet]
        public IEnumerable<Emp> Get()
        {
            return context.Emps.ToList();
        }

        // GET api/emps/5
        [HttpGet("{id}")]
        public Emp Get(int id)
        {
            return context.Emps.Find(id);
        }

        // POST api/emps
        [HttpPost]
        public void Post([FromBody] Emp emp)
        {
            context.Emps.Add(emp);
            context.SaveChanges();
        }

        // PUT api/emps/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] Emp emp)
        {
            Emp empToUpdate = context.Emps.Find(id);
            empToUpdate.Name = emp.Name;
            empToUpdate.Address = emp.Address;
            context.SaveChanges();
        }

        // DELETE api/emps/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
            Emp empToDelete = context.Emps.Find(id);
            context.Emps.Remove(empToDelete);
            context.SaveChanges();
        }
    }
}
