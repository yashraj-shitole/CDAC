using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using LabExam.Models;
using NuGet.Protocol.Plugins;

namespace LabExam.Controllers
{
    public class UserController : Controller
    {
        private readonly AppDbContext _context;

        public UserController(AppDbContext context)
        {
            _context = context;
        }

        // GET: User
        public async Task<IActionResult> Index()
        {
              return _context.USers != null ? 
                          View(await _context.USers.ToListAsync()) :
                          Problem("Entity set 'AppDbContext.USers'  is null.");
        }

        

        // GET: User/Details/5
        public async Task<IActionResult> Details(int id)
        {
            if (id == null || _context.USers == null)
            {
                return NotFound();
            }

            var user = await _context.USers
                .FirstOrDefaultAsync(m => m.Id == id);
            if (user == null)
            {
                return NotFound();
            }

            return View(user);
        }


        //looooggiinnn
        public IActionResult Login()
        {
            return View();
        }

        // GET: User/Register
        public IActionResult Create()
        {
            return View();

        }// GET: User/Register
        public IActionResult Home(int id)
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public  IActionResult Login([Bind("Email,Password")] User user)
        {

            if (_context.USers == null)
            {
                return View();
            }

            User user1 = _context.USers.FirstOrDefault(m => m.Email == user.Email && m.Password == user.Password);
            if (user == null)
            {
                ViewBag.Message = "Invalid cred";
                return RedirectToAction("Login", "Login");
            }
            if (user1 == null)
            {
            return View();

            }
            
            if (user.Email == user1.Email)
            {
              
                return View("Home",user1);
            }
            return View();
        }


        // POST: User/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Name,Email,Password")] User user)
        {
            if (ModelState.IsValid)
            {
                _context.USers.Add(user);
                _context.SaveChanges();
                return RedirectToAction("Login");
            }
            return View();
        }

        // GET: User/Edit/5
        public async Task<IActionResult> Edit(string id)
        {
            if (id == null || _context.USers == null)
            {
                return NotFound();
            }

            var user = await _context.USers.FindAsync(id);
            if (user == null)
            {
                return NotFound();
            }
            return View(user);
        }

        // POST: User/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("Id,Name,Email,Password")] User user)
        {
            if (id != user.Id)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(user);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!UserExists(user.Id))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }
                return RedirectToAction(nameof(Index));
            }
            return View(user);
        }

        // GET: User/Delete/5
        public async Task<IActionResult> Delete(int id)
        {
            if (id == null || _context.USers == null)
            {
                return NotFound();
            }

            var user = await _context.USers
                .FirstOrDefaultAsync(m => m.Id == id);
            if (user == null)
            {
                return NotFound();
            }


            return View(user);
        }

        // POST: User/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            if (_context.USers == null)
            {
                return Problem("Entity set 'AppDbContext.USers'  is null.");
            }
            var user = await _context.USers.FindAsync(id);
            if (user != null)
            {
                _context.USers.Remove(user);
            }
            
            await _context.SaveChangesAsync();
            return RedirectToAction("Login");
        }

        private bool UserExists(int id)
        {
          return (_context.USers?.Any(e => e.Id == id)).GetValueOrDefault();
        }
    }
}
