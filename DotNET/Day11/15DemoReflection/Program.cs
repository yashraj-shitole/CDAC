using System;
using System.IO;
using System.Reflection;

namespace _15DemoReflection
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string path = "C:\\KDAC Dot Net\\KDAC_AUG_24\\MathsLib\\bin\\Debug\\MathsLib.dll";
            Assembly assembly = Assembly.LoadFrom(path);
            Type[] types = assembly.GetTypes();


            foreach (Type type in types)
            {
                object dynamicallyCreatedObject =
                     assembly.CreateInstance(type.FullName);

                MethodInfo[] methods = type.GetMethods();
                foreach (MethodInfo method in methods)
                {
                    Console.WriteLine("Calling {0} Method", method.Name);
                    ParameterInfo[] allParams = method.GetParameters();

                    object[] parametersToMethod = 
                        new object[allParams.Length];

                    for (int i = 0; i < allParams.Length; i++)
                    {
                        Console.WriteLine("Enter value for {0} of type {1}",
                                            allParams[i].Name,
                                            allParams[i].ParameterType);

                        string parameterValueInString = Console.ReadLine();

                        object parameterInRespectiveType =
                            Convert.ChangeType(parameterValueInString,
                                                allParams[i].ParameterType);

                        parametersToMethod[i] = parameterInRespectiveType;
                    }

                    object output = 
                        type.InvokeMember(method.Name, 
                                          BindingFlags.Public |
                                          BindingFlags.Instance |
                                          BindingFlags.InvokeMethod,
                                          null, 
                                          dynamicallyCreatedObject,
                                          parametersToMethod);

                    Console.WriteLine("Output is {0}", output);
                    Console.WriteLine("-----------------------------");
                }
            }
        }
    }
}
