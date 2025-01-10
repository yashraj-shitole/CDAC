using Microsoft.EntityFrameworkCore;

namespace LabExam.Models
{
    public class AppDbContext : DbContext
    {

         
     public DbSet<User> USers { get; set; }

        public AppDbContext(DbContextOptions<AppDbContext> options) : base(options) { }
    

}

}

