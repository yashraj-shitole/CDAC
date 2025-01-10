using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace _0000DemoMVC.Models
{
    [Table("Emp")]
    public class Emp
    {
        [Column("No", TypeName ="int")]
        [Key]
        public int No { get; set; }

        [Column("Name", TypeName = "varchar")]
        [StringLength(50)]
        [Required(ErrorMessage ="Name is Must.")]
        public string Name { get; set; }

        [Column("Address", TypeName = "varchar")]
        [StringLength(50)]
        [Required(ErrorMessage = "Address is Must.")]
        public string Address { get; set; }

        //[Column("Age", TypeName = "int")]
        //[Range(18, 60, ErrorMessage = "Age is not in range!")]
        //[Required(ErrorMessage ="Age is required.")]
        //public int Age { get; set; }


        //[Column("EmailAddress", TypeName = "varchar")]
        //[StringLength(50)]
        //[Required(ErrorMessage = "Email Address is required.")]
        //[RegularExpression("'[a-z0-9]+@[a-z]+\\.[a-z]{2,3}'", ErrorMessage ="Email pattern is wrong!")]
        //public string EmailAddress { get; set; }
    }
}
