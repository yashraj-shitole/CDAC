using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Reflection;

namespace _14DemoReflection
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string path = "C:\\KDAC Dot Net\\KDAC_AUG_24\\MathsLib\\bin\\Debug\\MathsLib.dll";

            //string path = "C:\\KDAC Dot Net\\KDAC_AUG_24\\02DemoOOP\\bin\\Debug\\02DemoOOP.exe";

            Assembly assembly = Assembly.LoadFrom(path);

            Type[] types = assembly.GetTypes();


            foreach (Type type in types) 
            {
                #region Print Basic Details found using reflection
                Console.WriteLine(type.FullName);
                //Console.WriteLine("Type Name: {0}", type.FullName);
                //Console.WriteLine("Is Class? {0}", type.IsClass);
                //Console.WriteLine("Is Generic? {0}", type.IsGenericType);
                //Console.WriteLine("Is Abstract? {0}", type.IsAbstract);
                #endregion

                #region Find Serializable Attribute Applied on Class! and Print Details
                //Attribute[] allAttributesOnType =
                //   type.GetCustomAttributes().ToArray();

                //bool isItSerializable = false;

                //foreach (Attribute attribute in allAttributesOnType)
                //{
                //    if (attribute is SerializableAttribute)
                //    {
                //        isItSerializable = true;
                //        break;
                //    }
                //}

                //if (isItSerializable)
                //{
                //    Console.WriteLine("{0} is marked as Serializable", type.Name);
                //}
                //else
                //{
                //    Console.WriteLine("{0} is NOT marked as Serializable", type.Name);
                //    //throw new Exception(string.Format("{0} is NOT marked as Serializable", type.Name));
                //}
                #endregion

                MethodInfo[] methods = type.GetMethods();
                foreach (MethodInfo method in methods)
                {
                    //Console.WriteLine("Method Name : {0}", method.Name);
                    //Console.WriteLine("Is Public? {0}", method.IsPublic);
                    //Console.WriteLine("Is Generic? {0}", method.IsGenericMethod);

                    string methodDetails = "";

                    methodDetails = methodDetails + " -- " + method.ReturnType;
                    methodDetails = methodDetails + " " + method.Name + " ( ";

                    ParameterInfo[] allParams = method.GetParameters();
                    foreach (ParameterInfo param in allParams)
                    {
                        methodDetails = methodDetails + 
                            string.Format("{0} {1} ,", param.ParameterType, param.Name);
                    }

                    methodDetails = methodDetails.TrimEnd(',');

                    methodDetails = methodDetails + " ) ";

                    Console.WriteLine(methodDetails);
                }
            
            }
        }
    }
}
