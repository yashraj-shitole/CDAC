using _003DemoMVC.Models;
using Microsoft.AspNetCore.Mvc;

namespace _003DemoMVC.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            Emp emp = new Emp() { No = 1, Name = "Mahesh", Address = "Pune" };
            Book book = new Book() { ISBN = 9898, Title =" Let us C#" };

            ViewBag.MyBook = book;
            ViewBag.MyMessage = "Welcome to MVC";


            return View(emp);
        }

        public IActionResult AfterEdit(Emp updatedEmp)
        {
            return null;
        }
    }
}
