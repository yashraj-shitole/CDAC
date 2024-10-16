import java.util.Scanner;

public class Question01 {

	
	//	Q1. Accept 2 double values from User (using Scanner). Check data type. If arguments are not
	//	doubles, supply suitable error message & terminate.
	//	If numbers are double values, print its average.
	//	Hint : Check Scanner class for the methods
		
	
		public static void main(String[] args) 
		{
			
			double ino1 = 0;
			double ino2 = 0;
			
			double d1 = 0.0;
			double d2 = 0.0;
			
			boolean iflag1 = false ;
			boolean iflag2 = false;
			
			Scanner sc = new Scanner(System.in);	
			System.out.println("Enter the First No :");
			if(!sc.hasNextInt() && sc.hasNextDouble())
			{
				ino1 = sc.nextDouble();
				System.out.println("Entered No is correct "+ino1);
				iflag1 = true;
				
				
				System.out.println("Enter the Second No :");
				if(!sc.hasNextInt() && sc.hasNextDouble())
				{
					ino2 = sc.nextDouble();
					System.out.println("Entered 2nd no is correct "+ino2);
					iflag2 = true;
					if(iflag1 == iflag2)
					{
						double avg = (ino1 + ino2)/2;
						System.out.println("Average of two no is :" +avg);	
		
					}
					
					else
					{
						System.out.println("Second No is not Double ");
					}
					
				}
				else
				{
					System.out.println("Second No is Incorrect ...");
				}
			
				
			}
			
			else
			{
				System.out.println("Entered no is Not correct...");
			}
		}

		
			
			
	}
