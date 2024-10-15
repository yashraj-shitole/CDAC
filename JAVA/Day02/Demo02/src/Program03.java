public class Program03 {

	public static void main(String[] args) {
		boolean status = true;
		// we cannot convert boolean type into any other type;s
		// int n1 = (int) status; // NOT OK

		// process of converting narrower type of data
		// into wider type of data is called as widening
		int n1 = 10;
		double n2 = n1; // widening

		// process of converting wider type of data
		// into narrower type of data is called as narrowing
		// During narrowing explicit typecasting is mandatory
		// Their are high chances of data loss during narrowing
		double n3 = 12.34;
		int n4 = (int) n3; // narrowing
	}

}
