using Microsoft.EntityFrameworkCore;

namespace _0001DemoMVC.Models
{
    public class KDACDBContext : DbContext
    {
        public DbSet<Emp> Emps { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer("Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=KDACDB;Integrated Security=True;");
            base.OnConfiguring(optionsBuilder);
        }
    }
}
