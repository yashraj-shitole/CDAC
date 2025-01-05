using Microsoft.EntityFrameworkCore;

namespace _002DemoMVC.Model
{
    public class KDACDBContext : DbContext
    {
        public DbSet<Emp> Emps { get; set; }
        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer("Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=KDACDB;Integrated Security=True");
            base.OnConfiguring(optionsBuilder);
        }
    }
}
