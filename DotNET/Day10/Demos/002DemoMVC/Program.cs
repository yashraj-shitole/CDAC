namespace _002DemoMVC
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);
            builder.Services.AddControllers();
            builder.Services.AddEndpointsApiExplorer();
            builder.Services.AddSwaggerGen();

            var app = builder.Build();

            if (app.Environment.IsDevelopment())
            {
                app.UseSwagger();
                app.UseSwaggerUI();
            }

            app.UseCors((policyBuilder) => {
                policyBuilder.WithOrigins("*").WithMethods("*").WithHeaders("*");
            });
            app.UseAuthorization();
            app.MapControllers();
            app.Run();
        }
    }
}
