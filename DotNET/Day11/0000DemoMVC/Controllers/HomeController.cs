using _0000DemoMVC.Filters;
using _0000DemoMVC.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Filters;
using System.Diagnostics;

namespace _0000DemoMVC.Controllers
{
    public class HomeController : BaseController
    {
        KDACDBContext db = new KDACDBContext();
        public IActionResult Index()
        {
            ViewBag.UserName = HttpContext.Session.GetString("Token");
            return View(db.Emps.ToList());
        }
   
        [HttpGet]
        public IActionResult Create()
        {
            return View();
        }

        [HttpPost]
        public IActionResult Create(Emp emp)
        {
           if(ModelState.IsValid)
            {
                db.Emps.Add(emp);
                db.SaveChanges();
                return Redirect("/Home/Index");
            }
           else
            {
                return View(emp);
            }
        }

        public IActionResult Edit(int id)
        {
            Emp emp = db.Emps.Find(id);
            return View(emp);
        }

        public IActionResult AfterEdit(Emp empEdited)
        {
            var empToUpdate =  db.Emps.Find(empEdited.No);
            empToUpdate.Name = empEdited.Name;
            empToUpdate.Address = empEdited.Address;

            db.SaveChanges();
            return Redirect("/Home/Index");
        }

        public IActionResult Delete(int id)
        {
            Emp emp = db.Emps.Find(id);
            db.Emps.Remove(emp);
            db.SaveChanges();

            return Redirect("/Home/Index");
        }
    }
}
