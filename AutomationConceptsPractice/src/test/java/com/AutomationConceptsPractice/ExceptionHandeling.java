package com.AutomationConceptsPractice;

import java.util.Scanner;

import org.testng.annotations.Test;

public class ExceptionHandeling {

	@Test(priority = 1, enabled = true)

	public void AgeValidator() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the age....");
		int age = sc.nextInt();
		if (age < 18) {
			System.out.println("Not applicable for voting...");
			throw new AgeValidatorException("Age is less than 18 years...Not applicable for voting...");
		} else if (age >= 18) {
			System.out.println("Applicable for voting...");

		}
	}

	@Test(priority = 2, enabled = true)
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
		} catch (Exception e) {
			System.out.println("No such element exception");
		} finally {
			System.out.println("Running finally block...");
		}
	}

}
