using System.Reflection;
using ORMAttributes;

namespace _16DemoReflection
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string path = "C:\\KDAC Dot Net\\KDAC_AUG_24\\POCO\\bin\\Debug\\net6.0\\POCO.dll";
            string queryFile = "C:\\KDAC Dot Net\\Queries.sql";

            Assembly assembly = Assembly.LoadFrom(path);

            Type[] allTypes = assembly.GetTypes();

            foreach (Type type in allTypes)
            {
                if (!type.Name.Contains("Attribute"))
                {
                    //Console.WriteLine(type.Name);

                    string query = "";

                    Attribute []attributesOnType =
                        type.GetCustomAttributes().ToArray();

                    foreach (Attribute attribute in attributesOnType)
                    {
                        if (attribute is Table)
                        {
                            Table table = (Table)attribute;
                            //Console.WriteLine(table.TableName);
                            query = query + 
                                    "create table " + table.TableName
                                    + "( ";
                            break;
                        }
                    }

                    PropertyInfo[] properties = type.GetProperties();

                    foreach (PropertyInfo property in properties) 
                    {
                      Attribute []propertyAttributes=
                            property.GetCustomAttributes().ToArray();

                        foreach (Attribute attribute in propertyAttributes)
                        {
                            if (attribute is Column )
                            {
                                Column column = (Column)attribute;
                                query = query + column.ColumnName + " " +
                                        column.ColumnType + ",";
                                break;
                            }
                        }

                    }

                    query = query.TrimEnd(',');
                    query = query + " );";

                    FileStream fileStream = null;

                    if (File.Exists(queryFile))
                    {
                       fileStream = new FileStream(queryFile, FileMode.Append, FileAccess.Write);
                    }
                    else
                    {
                        fileStream = new FileStream(queryFile, FileMode.OpenOrCreate, FileAccess.Write);
                    }

                    StreamWriter writer = new StreamWriter(fileStream);
                    writer.Write(query);
                    writer.Close();
                    fileStream.Close();

                    writer = null;
                    fileStream = null;

                    Console.WriteLine("DONE Writing Query!");
                }
            }
        }
    }
}
