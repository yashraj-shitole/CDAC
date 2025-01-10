using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace _0001DemoMVC.Models
{
    [Table("Emp")]
    public class Emp
    {
        [Column("No", TypeName = "int")]
        [Key]
        public int No { get; set; }

        [Column("Name", TypeName = "varchar")]
        [StringLength(50)]
        [Required(ErrorMessage = "Name is Must.")]
        public string Name { get; set; }

        [Column("Address", TypeName = "varchar")]
        [StringLength(50)]
        [Required(ErrorMessage = "Address is Must.")]
        public string Address { get; set; }
    }
}
