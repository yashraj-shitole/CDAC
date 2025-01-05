namespace _24DemoDBEF
{
    internal class Program
    {
        static void Main(string[] args)
        {
            KDACDBContext context = new KDACDBContext();

            var emps = context.Emps.ToList();

            foreach (var emp in emps)
            {
                 Console.WriteLine(emp.No + " | " + emp.Name + " | " + emp.Address);
            }

            //var customers = context.Customers.ToList();

            //foreach (var customer in customers)
            //{
            //    Console.WriteLine(customer.No + " | " + customer.Name + " | " + customer.Address);
            //}

            //context.Customers.Add(new Customer() { Name = "Milind", Address = "Satara" });
            //context.SaveChanges();

            //Customer customerToEdit = context.Customers.Find(3);
            //customerToEdit.Name = "Sumit";
            //customerToEdit.Address = "Vardha";
            //context.SaveChanges();


            //Customer customerToRemove = context.Customers.Find(3);
            //context.Customers.Remove(customerToRemove);
            //context.SaveChanges();

            Console.ReadLine();
        }
    }
}
