using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace _002DemoMVC.Model
{
    [Table("Emp")]
    public class Emp
    {
        [Key]
        [Column("No", TypeName = "int")]
        public int No { get; set; }

        [Column("Name", TypeName = "varchar")]
        [StringLength(50)]
        public string Name { get; set; }

        [Column("Address", TypeName = "varchar")]
        [StringLength(50)]
        public string Address { get; set; }
    }
}
