using _000DemoMVC.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Filters;

namespace _000DemoMVC.Controllers
{
    public class HomeController : Controller
    {
        //public HomeController(ISpellChecker checker)
        public HomeController(IEnumerable<ISpellChecker> checkers)
        {
            
        }

        public override void OnActionExecuting(ActionExecutingContext context)
        {
            base.OnActionExecuting(context);
        }

        public override void OnActionExecuted(ActionExecutedContext context)
        {
            base.OnActionExecuted(context);
        }

        public IActionResult Index()
        {
            Emp emp = new Emp() { No = 1, Name = "Sudhir", Address = "Pune" };
            return View("MyUI",emp);
        }

        public IActionResult About()
        {
            return new ContentResult() 
            {
                Content = "This is about us!", 
                ContentType = "text/plain" 
            };
        }

        public IActionResult Contact()
        {
            List<Emp> emps = new List<Emp>()
            {
                new Emp() { No = 11, Name = "Sachin1", Address = "Pune1" },
                new Emp() { No = 12, Name = "Sachin2", Address = "Pune2" },
                new Emp() { No = 13, Name = "Sachin3", Address = "Pune3" }
            };
            return new JsonResult(emps);
        }
    }
}

