using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace _07DemoDesktop
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            Button button1 = new Button();
            button1.Text = "Add Record To DB";
            button1.Width = 200;
            EventHandler pointer1 = new EventHandler(CodeForRecordAdditionInDB);

            button1.Click += pointer1;
            this.Controls.Add(button1);
        }

        public void CodeForRecordAdditionInDB(object sender, EventArgs e)
        {
            MessageBox.Show("Data Added in Database");
        }
    }
}
