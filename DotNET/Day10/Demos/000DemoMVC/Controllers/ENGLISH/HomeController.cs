using Microsoft.AspNetCore.Mvc;

namespace _000DemoMVC.Controllers.ENGLISH
{
    //Home/Index
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}
