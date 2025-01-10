using _000DemoMVC.Models;
using System.Reflection;

namespace _000DemoMVC
{
    public class Program
    {
        public static void Main(string[] args)
        {

            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container.
            //builder.Services.AddControllers();
            builder.Services.AddControllersWithViews();
            builder.Services.AddScoped(typeof(ISpellChecker), typeof(EnglishSpellChecker));
            builder.Services.AddScoped(typeof(ISpellChecker), typeof(HindiSpellChecker));

            var app = builder.Build();

            app.UseStaticFiles();

            app.UseRouting();

            app.UseAuthorization();

            app.MapControllerRoute(
                name: "default",
                pattern: "{controller=Home}/{action=Index}/{id?}");

            app.Run();
        }
    }
}