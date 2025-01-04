using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _24DemoDBEF
{
    [Table("Emp")]
    public class Emp
    {
        [Column("No", TypeName = "int")]
        [Key]
        public int No { get; set; }

        [Column("Name", TypeName = "varchar")]
        [StringLength(50)]
        public string Name { get; set; }

        [Column("Address", TypeName = "varchar")]
        [StringLength(50)]
        public string Address { get; set; }
    }

    [Table("Customer")]
	public class Customer
	{
        [Column("No", TypeName = "int")]
        [Key]
        public int No { get; set; }

        [Column("Name", TypeName = "varchar")]
        [StringLength(50)]
        public string Name { get; set; }

        [Column("Address", TypeName = "varchar")]
        [StringLength(50)]
        public string Address { get; set; }
    }

    [Table("Trainer")]
    public class Trainer
    {
        [Key]
        [Column("TrainerID", TypeName = "int")]
        public int TrainerID { get; set; }

        [Column("TrainerName", TypeName = "varchar")]
        [StringLength(50)]
        public string TrainerName { get; set; }

        [Column("BaseLocation", TypeName = "varchar")]
        [StringLength(50)]
        public string BaseLocation { get; set; }

        public List<Subject> Subjects { get; set; }
       
    }

    [Table("Subject")]
    public class Subject
    {
        [Key]
        [Column("SubjectID", TypeName = "int")]
        public int SubjectID { get; set; }

        [Column("SubjectName", TypeName = "varchar")]
        [StringLength(50)]
        public string SubjectName { get; set; }
        public List<Trainer> Trainers { get; set; }
    }

    public class KDACDBContext : DbContext
    {
        public DbSet<Customer> Customers { get; set; }
        public DbSet<Trainer> Trainers { get; set; }
        public DbSet<Subject> Subjects { get; set; }
        public DbSet<Emp> Emps { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer("Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=KDACDB;Integrated Security=True;");
            base.OnConfiguring(optionsBuilder);
        }
    }
}
