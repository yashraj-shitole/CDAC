import java.util.Scanner;

public class Program02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Abstraction

		System.out.println("Enter name - ");
		String name = sc.next();
		System.out.println("Enter age - ");
		int age = sc.nextInt();

		System.out.println("Name = " + name);
		System.out.println("Age = " + age);
	}

}
