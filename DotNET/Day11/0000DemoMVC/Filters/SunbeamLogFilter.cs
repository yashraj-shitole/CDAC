using Microsoft.AspNetCore.Mvc.Filters;
using _0000DemoMVC.Helper;
namespace _0000DemoMVC.Filters
{
    public class SunbeamLogFilter : ActionFilterAttribute
    {
        public override void OnActionExecuting(ActionExecutingContext context)
        {
            Logger.CurrentLogger.Log(string.Format("{0}/{1} is called.",
                        context.ActionDescriptor.RouteValues["Controller"],
                        context.ActionDescriptor.RouteValues["Action"]));
        }
    }
}
