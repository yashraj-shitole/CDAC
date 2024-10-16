import java.util.*;

public class Assignment02_Question02 {

//	Q2. Display food menu to user. User will select items from menu along with the quantity. (eg 1.
//	Dosa 2. Samosa 3. Idli ... 10 . Generate Bill ) Assign fixed prices to food items(hard code the prices)
//	When user enters 'Generate Bill' option , display total bill & exit.
//	(No need of any class, and no need to display the food details. Only display the total of orderd
//	food)
	
	
	public static void main(String[] args) {
		
int choice=1;
double totalBill=0;

Scanner sc=new Scanner(System.in);

		while(choice!=0) {
			
			
			System.out.println("-----------MENU-----------");
			System.out.println(" 1. Dosa - 30/- \n 2. Samosa - 12/- \n 3. Idli - 20/- \n 4. Missal - 40/- \n 5. Pav Bhaji - 40/- \n 6. Generate Bill");
			choice=sc.nextInt();
			
			switch (choice) {
			case 1:{
				totalBill += 30;
				break;
			}
			case 2:{
				totalBill += 12;
				break;
			}
			case 3:{
				totalBill += 20;
				break;
			}
			case 4:{
				totalBill += 40;
				break;
			}
			case 5:{
				totalBill += 40;
				break;
			}
			
			
			case 6:{
				System.out.println("Total Bill : "+totalBill);
				choice=0;
				break;
			}
				

			default:
				System.out.println("Wrong Choice");
				break;
			}
		}

	}

}
