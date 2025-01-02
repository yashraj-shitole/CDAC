using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

namespace _08DemoEvent
{
    internal class Program
    {
        static void Main(string[] args)
        {
            //Button button = new Button();
            KDACStudent student = new KDACStudent();

            //button.Text = "Add Record To DB";
            student.Name = "Devarshi";

            //EventHandler pointer1 = new EventHandler(CodeForRecordAdditionInDB);
            ProposalAnswerHandler Sanyam =
                new ProposalAnswerHandler(OnProposalAcceptGoTOAryaVeg);

            ProposalAnswerHandler Krishna =
                new ProposalAnswerHandler(OnProposalRejectGoTOPyasa);

            //button1.Click += pointer1;
            student.ProposalAccepted += Sanyam;
            student.ProposalRejected += Krishna;

            Console.WriteLine("Kya hai?");

            //As if user does left mouse click on the area of button
            student.Propose(Console.ReadLine());

            Console.ReadLine();
        }

        //public void CodeForRecordAdditionInDB(object sender, EventArgs e)
        //{
            //Your code here...
        //}
        public static void OnProposalAcceptGoTOAryaVeg()
        {
            Console.WriteLine("HAPPY PARTYY!!!");
        }

        public static void OnProposalRejectGoTOPyasa()
        {
            Console.WriteLine("SAD PARTYY!!!");
        }
    }

  //public delegate void EventHandler(object sender, EventArgs e);
    public delegate void ProposalAnswerHandler();
    
    //public class Button
    public class KDACStudent
    {
        public event ProposalAnswerHandler ProposalAccepted;
        public event ProposalAnswerHandler ProposalRejected;
        //public event EventHandler Click

        private string _Name;

        //public string Text;
        public string Name
        {
            get { return _Name; }
            set { _Name = value; }
        }


        public void Propose(string message)//as if click happens
        {
            //was the click "left click" and on button area?? 
            if (message == "i am from kdac")
            {
                ProposalRejected();
                //Click(this,new EventArgs());
            }
            else
            {
                ProposalAccepted();
            }
        }
    }

}
