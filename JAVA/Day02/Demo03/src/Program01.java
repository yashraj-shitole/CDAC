
public class Program01 {

	public static void main(String[] arr) {
		System.out.println("Hello");
		String s1 = arr[0];
		String s2 = arr[1];
		System.out.println("arr[0] = " + s1);
		System.out.println("arr[1] = " + s2);

		int n1 = Integer.parseInt(s1); // unboxing
		int n2 = Integer.parseInt(s2);// unboxing
		System.out.println("Addition = " + (n1 + n2));

	}

}
