import java.lang.reflect.Method;

/**
 * Course: Advanced Computing (DAC) @ Sunbeam Infotech
 * Author: Nilesh Ghule <nilesh@sunbeaminfo.com>
 * Date: Nov 4, 2024
 */

public class Middleware {
	@SuppressWarnings("deprecation")
	public static Object invokeMethod(String className, String methodName, Class[] argTypes, Object... argValues) {
		try {
			// load the given class and get its metadata
			Class c = Class.forName(className);
			// create an object of the class
			Object obj = c.newInstance();
			// find the method of given name and argument in the class
			Method m = c.getDeclaredMethod(methodName, argTypes);
			// ensure that method is accessible
			m.setAccessible(true);
			// call the method on given object with given args and collect the result
			Object result = m.invoke(obj, argValues);
			// return the result
			return result;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
