using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Microsoft.EntityFrameworkCore;
using _0000DemoMVC.Models;

namespace _0000DemoMVC.Controllers
{
    public class SampleController : Controller
    {
        private readonly KDACDBContext _context = new KDACDBContext();


        // GET: Sample
        public async Task<IActionResult> Index()
        {
              return _context.Emps != null ? 
                          View(await _context.Emps.ToListAsync()) :
                          Problem("Entity set 'KDACDBContext.Emps'  is null.");
        }

        // GET: Sample/Details/5
        public async Task<IActionResult> Details(int? id)
        {
            if (id == null || _context.Emps == null)
            {
                return NotFound();
            }

            var emp = await _context.Emps
                .FirstOrDefaultAsync(m => m.No == id);
            if (emp == null)
            {
                return NotFound();
            }

            return View(emp);
        }

        // GET: Sample/Create
        public IActionResult Create()
        {
            return View();
        }

        // POST: Sample/Create
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("No,Name,Address")] Emp emp)
        {
            if (ModelState.IsValid)
            {
                _context.Add(emp);
                await _context.SaveChangesAsync();
                return RedirectToAction(nameof(Index));
            }
            return View(emp);
        }

        // GET: Sample/Edit/5
        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null || _context.Emps == null)
            {
                return NotFound();
            }

            var emp = await _context.Emps.FindAsync(id);
            if (emp == null)
            {
                return NotFound();
            }
            return View(emp);
        }

        // POST: Sample/Edit/5
        // To protect from overposting attacks, enable the specific properties you want to bind to.
        // For more details, see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("No,Name,Address")] Emp emp)
        {
            if (id != emp.No)
            {
                return NotFound();
            }

            if (ModelState.IsValid)
            {
                try
                {
                    _context.Update(emp);
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!EmpExists(emp.No))
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
            return View(emp);
        }

        // GET: Sample/Delete/5
        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null || _context.Emps == null)
            {
                return NotFound();
            }

            var emp = await _context.Emps
                .FirstOrDefaultAsync(m => m.No == id);
            if (emp == null)
            {
                return NotFound();
            }

            return View(emp);
        }

        // POST: Sample/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            if (_context.Emps == null)
            {
                return Problem("Entity set 'KDACDBContext.Emps'  is null.");
            }
            var emp = await _context.Emps.FindAsync(id);
            if (emp != null)
            {
                _context.Emps.Remove(emp);
            }
            
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }

        private bool EmpExists(int id)
        {
          return (_context.Emps?.Any(e => e.No == id)).GetValueOrDefault();
        }
    }
}
