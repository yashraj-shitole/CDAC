using ORMAttributes;

namespace POCO
{
	[Table(TableName = "Employee")]
	public class Emp
    {
		private int _No;
		private string _Name;
		private string _Address;

		[Column(ColumnName = "Address", ColumnType = "varchar(50)")]
		public string Address
		{
			get { return _Address; }
			set { _Address = value; }
		}

        [Column(ColumnName = "Name", ColumnType = "varchar(50)")]
        public string Name
		{
			get { return _Name; }
			set { _Name = value; }
		}

        [Column(ColumnName = "No", ColumnType = "int")]
        public int No
		{
			get { return _No; }
			set { _No = value; }
		}

	}

	[Table(TableName ="Customer")]
	public class Customer
	{
		private int _CID;
		private string _CName;

		[Column(ColumnName ="CName", ColumnType = "varchar(100)")]
		public string CName
		{
			get { return _CName; }
			set { _CName = value; }
		}

        [Column(ColumnName = "CNo", ColumnType = "int")]
        public int CID
		{
			get { return _CID; }
			set { _CID = value; }
		}

	}
}
