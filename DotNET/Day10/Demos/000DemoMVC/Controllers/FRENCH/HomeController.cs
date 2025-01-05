using Microsoft.AspNetCore.Mvc;

namespace _000DemoMVC.Controllers.FRENCH
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
