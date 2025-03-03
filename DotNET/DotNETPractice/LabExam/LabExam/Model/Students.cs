using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace LabExam.Model
{
    [Table("Students")]
    public class Students
    {

        [Key]
        [Column(name:"StudentId",TypeName ="int")]
        public int StudentId { get; set; }


        [Column(name: "StudentName", TypeName = "varchar")]
        [StringLength(25)]
        [Required(ErrorMessage = "Student name is must")]
        public String StudentName { get; set; }


        [Column(name: "StudentAge", TypeName = "int")]
        [Required(ErrorMessage = "StudentAge is must")]
        public int  StudentAge { get; set; }
    }
}
