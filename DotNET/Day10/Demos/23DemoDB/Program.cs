using System.Data;
using Microsoft.Data.SqlClient;

namespace _23DemoDB
{
    internal class Program
    {
        static void Main(string[] args)
        {
            #region Simple DataTable
            //DataTable table = new DataTable("Emp");

            //DataColumn column1 = new DataColumn("No",  typeof(int));
            //DataColumn column2 = new DataColumn("Name", typeof(string));
            //DataColumn column3 = new DataColumn("Address", typeof(string));

            //table.Columns.Add(column1);
            //table.Columns.Add(column2);
            //table.Columns.Add(column3);

            //table.PrimaryKey = new DataColumn[] { column1 };

            //DataRow row1 = table.NewRow();
            //row1["No"] = 1;
            //row1["Name"] = "Santosh";
            //row1["Address"] = "Nagpur";

            //DataRow row2 = table.NewRow();
            //row2["No"] = 2;
            //row2["Name"] = "Sachin";
            //row2["Address"] = "Solapur";

            //DataRow row3 = table.NewRow();
            //row3["No"] = 3;
            //row3["Name"] = "Mohan";
            //row3["Address"] = "Dharashiv";

            //table.Rows.Add(row1);
            //table.Rows.Add(row2);
            //table.Rows.Add(row3);

            //table.WriteXml("C:\\KDAC Dot Net\\EmpData.xml");
            //table.WriteXmlSchema("C:\\KDAC Dot Net\\EmpSchema.xml");
            #endregion

            #region Multiple Tables in Dataset

            //DataTable table1 = new DataTable("Emp");

            //DataColumn column1 = new DataColumn("No", typeof(int));
            //DataColumn column2 = new DataColumn("Name", typeof(string));
            //DataColumn column3 = new DataColumn("Address", typeof(string));

            //table1.Columns.Add(column1);
            //table1.Columns.Add(column2);
            //table1.Columns.Add(column3);

            //table1.PrimaryKey = new DataColumn[] { column1 };

            //DataRow row1 = table1.NewRow();
            //row1["No"] = 1;
            //row1["Name"] = "Santosh";
            //row1["Address"] = "Nagpur";

            //DataRow row2 = table1.NewRow();
            //row2["No"] = 2;
            //row2["Name"] = "Sachin";
            //row2["Address"] = "Solapur";

            //DataRow row3 = table1.NewRow();
            //row3["No"] = 3;
            //row3["Name"] = "Mohan";
            //row3["Address"] = "Dharashiv";

            //table1.Rows.Add(row1);
            //table1.Rows.Add(row2);
            //table1.Rows.Add(row3);

            //DataTable table2 = new DataTable("Customer");
            //DataColumn column11 = new DataColumn("CNo", typeof(int));
            //DataColumn column22 = new DataColumn("CName", typeof(string));

            //table2.Columns.Add(column11);
            //table2.Columns.Add(column22);

            //DataRow row11 = table2.NewRow();
            //row11["CNo"] = 11;
            //row11["CName"] = "Hemant";

            //DataRow row12 = table2.NewRow();
            //row12["CNo"] = 12;
            //row12["CName"] = "Hetal";

            //table2.Rows.Add(row11);
            //table2.Rows.Add(row12);

            //DataSet dataSet = new DataSet();
            //dataSet.Tables.Add(table1);
            //dataSet.Tables.Add(table2);

            //dataSet.WriteXml("C:\\KDAC Dot Net\\DS.xml");
            //dataSet.WriteXmlSchema("C:\\KDAC Dot Net\\DSSchema.xml");

            #endregion

            #region DataTable Creation from Database table 

            //DataSet dataSet = new DataSet();

            //DataTable table1 = new DataTable("Emp");

            //DataColumn column1 = new DataColumn("No", typeof(int));
            //DataColumn column2 = new DataColumn("Name", typeof(string));
            //DataColumn column3 = new DataColumn("Address", typeof(string));

            //table1.Columns.Add(column1);
            //table1.Columns.Add(column2);
            //table1.Columns.Add(column3);

            //table1.PrimaryKey = new DataColumn[] { column1 };

            //string connectionDetails = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=KDACDB;Integrated Security=True;";
            //SqlConnection connection = new SqlConnection(connectionDetails);
            //connection.Open();

            //SqlCommand command = new SqlCommand("select * from Emp", connection);
            //SqlDataReader reader = command.ExecuteReader();

            //while (reader.Read())
            //{
            //    DataRow row = table1.NewRow();
            //    row["No"] = Convert.ToInt32(reader["No"]);
            //    row["Name"] = reader["Name"].ToString();
            //    row["Address"] = reader["Address"].ToString();

            //    table1.Rows.Add(row);
            //}

            //connection.Close();

            //dataSet.Tables.Add(table1);
            //dataSet.WriteXml("C:\\KDAC Dot Net\\emp.xml");
            //dataSet.WriteXmlSchema("C:\\KDAC Dot Net\\empTableDetails.xml");
            #endregion
        
            DataSet dataSet = new DataSet();

            string connectionDetails = "Data Source=(LocalDB)\\MSSQLLocalDB;Initial Catalog=KDACDB;Integrated Security=True;";
            SqlConnection connection = new SqlConnection(connectionDetails);

            SqlDataAdapter dataAdapter = 
                new SqlDataAdapter("select * from Emp", connection);

            dataAdapter.MissingSchemaAction = MissingSchemaAction.AddWithKey;
            SqlCommandBuilder builder =
                new SqlCommandBuilder(dataAdapter);

            dataAdapter.Fill(dataSet, "Emp");

            #region Add Row into Dataset & Update DB

            //DataRow row = dataSet.Tables["Emp"].NewRow();
            //row["Name"] = "Nandu";
            //row["Address"] = "Nandurbar";

            //dataSet.Tables["Emp"].Rows.Add(row);
            //dataAdapter.Update(dataSet, "Emp");

            #endregion

            #region Update Row into Dataset & Update DB
            DataRow row = dataSet.Tables["Emp"].Rows.Find(12);
            if (row != null)
            {
                row["Name"] = "Plaksha";
                row["Address"] = "Pune";

                dataAdapter.Update(dataSet, "Emp");
            }
            else
            {
                Console.WriteLine("Record not found!");
            }
            #endregion

            #region Delete Row from Dataset & Update DB

            //DataRow row = dataSet.Tables["Emp"].Rows.Find(11);
            //if (row != null)
            //{
            //    row.Delete();

            //    dataAdapter.Update(dataSet, "Emp");
            //}
            //else
            //{
            //    Console.WriteLine("Record not found!");
            //}
            #endregion

        }
    }
}
