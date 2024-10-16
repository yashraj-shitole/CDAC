import java.util.*;

public class Assignment02_Question01 {

	
//	Q1. Accept a integer number and when the program is executed print the binary, octal and
//	hexadecimal equivalent of the given number.
//	Sample Output:
//	java Test
//	Enter Number : 20
//	Given Number :20
//	Binary equivalent :10100
//	Octal equivalent :24
//	Hexadecimal equivalent :14
//	Hint : Use Wrapper Class (toBinaryString() , toOctalString(), toHexString())
	
	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		
		System.out.print("Enter a number: ");
		int i=sc.nextInt();
		
		System.out.println("Given Number: "+i);
		
		String a= Integer.toBinaryString(i);
		System.out.println("Binary Number: "+a);
		
		a=Integer.toOctalString(i);
		System.out.println("Octal Number: "+a);
		
		a=Integer.toHexString(i);
		System.out.println("Hex Number: "+a);
		
		
		
		
	}

}
