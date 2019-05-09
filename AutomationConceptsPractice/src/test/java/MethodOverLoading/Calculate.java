package MethodOverLoading;


//Method overloading by changing data type of Arguments
public class Calculate {

	
	public static void main(String []args) {
	
	Calculate calculate = new Calculate();
	calculate.sum(5, 10);
	calculate.sum(5.4f, 1.6f);
	}
	
	
	//Method overloading by changing data types of arguments...
	
	public void sum(int a,int b) {
		int sum = a+b;
		System.out.println("Sum is : "+sum);
	}
	
	public void sum(float a,float b) {
		float sum = a+b;
		System.out.println("Sum is : "+sum);
	}
	
}
