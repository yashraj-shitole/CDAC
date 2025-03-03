using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace MigrationDemo
{
    public class Poco
    {
    }

    [Table(name: "Students")]
    public class Student
    {
        [Key]
        public int Id { get; set; }

        [Column(TypeName = "nvarchar(20)")]
        public string Name { get; set; }

    }

    [Table(name: "School")]
    public class School
    {

        [Key]
        public int Id { get; set; }

        [Column(TypeName ="nvarchar(20)")]
        public int Name { get; set; }

    }

    public class MyDbContext : DbContext
    {

        public DbSet<Student> Students { get; set; }
        public DbSet<School> Schools { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder) {

            optionsBuilder.UseSqlServer("Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=class;Integrated Security=True;");
            base.OnConfiguring(optionsBuilder);
        }

    }
}
