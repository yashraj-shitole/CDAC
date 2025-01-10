namespace _000DemoMVC.Models
{
    
    public interface ISpellChecker
    {
        void DoCheck(string word);
    }

    public class EnglishSpellChecker : ISpellChecker
    {
        public void DoCheck(string word)
        {
           //Some code here
        }
    }

    public class HindiSpellChecker : ISpellChecker
    {
        public void DoCheck(string word)
        {
            //Some code here
        }
    }

}
