import com.sunbeam.Arithmetic;

/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Nov 4, 2024
 */

public class ReflectionTester2 {

	public static void main(String[] args) {
		Object res1 = Middleware.invokeMethod("java.util.Date", "toString", null);
		System.out.println("Date.toString() -- " + res1);
	
		Class[] argTypes = { Integer.class, Integer.class };
		Object[] argValues = { 22, 7 };
		
		Object res2 = Middleware.invokeMethod("com.sunbeam.Arithmetic", "add", argTypes, argValues );
		System.out.println("Arithmetic.add() -- " + res2);
	
		Object res3 = Middleware.invokeMethod("com.sunbeam.Arithmetic", "multiply", argTypes, argValues);
		System.out.println("Arithmetic.multiply() -- " + res3);
	}

}
