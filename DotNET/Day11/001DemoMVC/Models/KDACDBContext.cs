using Microsoft.EntityFrameworkCore;
namespace _001DemoMVC.Models
{
    public class KDACDBContext: DbContext
    {
        public DbSet<Emp> Emps { get; set; }
        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer("Data Source=JET;Initial Catalog=KDACDB;Integrated Security=True");
            base.OnConfiguring(optionsBuilder);
        }
    }
}
