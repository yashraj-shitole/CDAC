namespace ORMAttributes
{
    public class Table: Attribute
    {
		private string _TableName;

		public string TableName
		{
			get { return _TableName; }
			set { _TableName = value; }
		}

	}

	public class Column : Attribute
	{
		private string _ColumnName;

		public string ColumnName
		{
			get { return _ColumnName; }
			set { _ColumnName = value; }
		}

		private string _ColumnType;

		public string ColumnType
		{
			get { return _ColumnType; }
			set { _ColumnType = value; }
		}



	}
}
