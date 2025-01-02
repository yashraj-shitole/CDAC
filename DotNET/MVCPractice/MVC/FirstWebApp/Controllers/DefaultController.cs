using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace FirstWebApp.Controllers
{
    public class DefaultController : Controller
    {
        // GET: Default
        public String Index()
        {
            return "<h1>Hello</h1>";
        }
    }
}