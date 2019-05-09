package Java;

import org.testng.annotations.Test;

import com.AutomationConceptsPractice.ArithmeticCustomException;

public class Exception {
	@Test(priority = 1, enabled = true)
	public void handelingExceptions() throws ArithmeticCustomException {

		int a = 0;
		int b = 100;
		try {

			System.out.println("Devide by zero." + b / a);

		} catch (ArithmeticException e) {
			System.out.println("Running catch block...");
			System.out.println("Exception thrown :" + e.getMessage());
			System.out.println("Exception thrown :" + e.getCause());
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("No such element exception");
		} finally {
			System.out.println("Running finally block...");
			System.gc();
		}
	}
}
