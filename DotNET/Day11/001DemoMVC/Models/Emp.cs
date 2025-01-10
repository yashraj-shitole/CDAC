using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace _001DemoMVC.Models
{
    [Table("Emp")]
    public class Emp
    {
        [Key]
        [Column("No",TypeName ="int")]
        public int No { get; set; }

        [Column("Name", TypeName = "varchar")]
        [StringLength(50)]
        public string Name { get; set; }

        [Column("Address", TypeName = "varchar")]
        [StringLength(50)]
        public string Address { get; set; }
    }
}
