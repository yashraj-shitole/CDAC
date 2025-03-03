using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace VotingApp.Models
{
    public class Candidate
    {

        [Key]
        public int Id { get; set; }


        [Column(TypeName ="nvarchar(20)")]
        public string _name { get; set; }
        [Column(TypeName ="nvarchar(20)")]
        public string _party { get; set; }
        [Column]
        public int _votes { get; set; }


    }
}
