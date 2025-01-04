using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace CRUD_BANK_TRANSACTIONS.Models
{
    public class Transaction
    {

        [Key] 
        public int TransactionId { get; set; }

        [Column(TypeName ="nvarchar(12)")]
        public string AccountName { get; set; }

        [Column(TypeName ="nvarchar(100)")]
        public string BenificiaryName { get; set; }

        [Column(TypeName ="nvarchar(100)")]
        public string BankName { get; set; }

        [Column(TypeName ="nvarchar(11)")]
        public string SwiftCode { get; set; }

        public int Amount { get; set; }

        public DateTime Date { get; set; }
    }
}
