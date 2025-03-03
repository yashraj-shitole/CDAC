using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace LabExam.Model
{
    [Table("Courses")]
    public class Courses
    {
        [Key]
        [Column(name:"CourseId",TypeName ="int")]
        public int CourseId{ get; set; }


        [Column(name: "CourseName", TypeName = "varchar")]
        [StringLength(25)]
        [Required(ErrorMessage ="Course name is must")]
        public String CourseName { get; set; }


        [Column(name:"StudentId",TypeName ="int")]
        public int StudentId { get; set; }



    }
}
