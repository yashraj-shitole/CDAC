using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace VotingApp.Models
{
    public class User
    {
        [Key]
        public int Id { get; set; }  // Make the property public

        [Column(TypeName = "nvarchar(50)")]
        public string FirstName { get; set; }  // Use public properties with getters and setters

        [Column(TypeName = "nvarchar(50)")]
        public string LastName { get; set; }

        [Column(TypeName = "nvarchar(100)")]
        public string Email { get; set; }

        [Column(TypeName = "nvarchar(255)")]
        public string Password { get; set; }

        [Column(TypeName = "date")]
        public DateTime Dob { get; set; }

        [Column(TypeName = "bit")]
        public bool Status { get; set; }

        [Column(TypeName = "nvarchar(20)")]
        public string Role { get; set; }
    }
}
