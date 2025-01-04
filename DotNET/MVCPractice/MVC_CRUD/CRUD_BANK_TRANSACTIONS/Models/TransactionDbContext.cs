using Microsoft.EntityFrameworkCore;

namespace CRUD_BANK_TRANSACTIONS.Models
{
    public class TransactionDbContext : DbContext
    {

        public TransactionDbContext(DbContextOptions<TransactionDbContext> options):base(options)
        {   
        }

        public DbSet<Transaction> Transactions { get; set; }

    }
}
