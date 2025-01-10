using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace LabExam.Models
{
    public class User
    {
        [Key]
        public int Id { get; set; }
        [Column(TypeName ="nvarchar(30)")]
        public string Name { get; set; }
        [Column(TypeName ="nvarchar(30)")]
        public string Email { get; set; }

        public string Password { get; set; }
    }
}
