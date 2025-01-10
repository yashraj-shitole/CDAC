using Microsoft.AspNetCore.Mvc.Filters;
using _0000DemoMVC.Helper;
namespace _0000DemoMVC.Filters
{
    public class Auth : ActionFilterAttribute
    {
        public override void OnActionExecuting(ActionExecutingContext context)
        {
            var userDetailsToken =   context.HttpContext.Session.GetString("Token");
            if (userDetailsToken==null)
            {
                context.HttpContext.Response.Redirect("/Login/SignIn");
            } 
        }
    }
}
