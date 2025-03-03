using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace Studets_REST_API
{
    public class POCO
    {

    }

    [Table(name:"Students")]
    public class Student
    {
        [Key]
        public int Id { get; set; }

        public string Name { get; set; }

        [Column(TypeName ="bit")]
        public bool Gender { get; set; }

        [Column(TypeName ="date")]
        public DateTime dob { get; set; }
        public int age { get; set; }
        public int standard { get; set; }


        public Student()
        {

        }

        public Student(int id, string name, bool gender, DateTime dob, int age, int standard)
        {
            Id = id;
            Name = name;
            Gender = gender;
            this.dob = dob;
            this.age = age;
            this.standard = standard;
        }
    }



    public class MyDbContext : DbContext
    {
        public DbSet<Student> Students { get; set; }

        public MyDbContext()
        {

        }

        public MyDbContext(DbContextOptions<MyDbContext> options) : base(options)
        {
        }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer("Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=class;Integrated Security=True;");
            base.OnConfiguring(optionsBuilder);
        }

    }
}
