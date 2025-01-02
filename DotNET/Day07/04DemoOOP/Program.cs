using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _04DemoOOP
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Editor editor = new Editor(null);

            //SpellCheckerFactory spellCheckerFactory = new SpellCheckerFactory();
            //ISpellChecker hindiChecker =
            //     spellCheckerFactory.GetChecker("hindi");
            //    Editor editor = new Editor(hindiChecker);

            Editor editor = new Editor(new MadiyaSpellChecker());
            editor.DoCheck("abcd");
            Console.ReadLine();
        }
    }
    public class Editor
    {
        private ISpellChecker _checker;

        public Editor(ISpellChecker checker)
        {
            if (checker==null)
            {
                _checker = new EnglishSpellChecker();
            }
            else
            {
                _checker = checker;
            }
        }
        public void DoCheck(string word)
        {
            _checker.SpellCheck(word);  
        }
    }
    public interface ISpellChecker
    {
        void SpellCheck(string word);
    }
    public class EnglishSpellChecker: ISpellChecker
    {
        //All environment set up for English Language Check!!
        public void SpellCheck(string word)
        {
            Console.WriteLine("English SpellCheck Done!");
        }
    }
    public class HindiSpellChecker: ISpellChecker
    {
        //All environment set up for Hindi Language Check!!
        public void SpellCheck(string word)
        {
            Console.WriteLine("Hindi SpellCheck Done!");
        }
    }
    public class MadiyaSpellChecker : ISpellChecker
    {
        public void SpellCheck(string word)
        {
            Console.WriteLine(  "Spellcheck done in Madiya");
        }
    }
    public class SpellCheckerFactory
    {
        public ISpellChecker GetChecker(string choice)
        {
            if (choice==null)
            {
                return new EnglishSpellChecker();
            }
            if (choice == "hindi")
            {
                return new HindiSpellChecker();
            }
            else 
            {
                return new EnglishSpellChecker();
            }

        }
    }
}
