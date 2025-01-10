using _0000DemoMVC.Filters;
using Microsoft.AspNetCore.Mvc;

namespace _0000DemoMVC.Controllers
{

    [Auth]
    [SunbeamLogFilter]
    public abstract class BaseController : Controller
    {
    }
}
