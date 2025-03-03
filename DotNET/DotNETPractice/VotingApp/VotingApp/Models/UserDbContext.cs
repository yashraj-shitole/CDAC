using Microsoft.EntityFrameworkCore;

namespace VotingApp.Models
{
    public class UserDbContext : DbContext
    {
        public UserDbContext(DbContextOptions<UserDbContext> options) : base(options) 
        { }
        public DbSet<User> users { get; set; }
        public DbSet<Candidate> candidates { get; set; }
    }
}
