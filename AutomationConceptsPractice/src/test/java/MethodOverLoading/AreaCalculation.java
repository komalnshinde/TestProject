package MethodOverLoading;

//Method overloading by changing no. of argument.
public class AreaCalculation {

	public static void main(String []args) {
		
		AreaCalculation calculate = new AreaCalculation();
		calculate.area(5, 4);
		calculate.area(5, 4, 2);
	}
	
	
	public void area(int l,int b) {
		int area = l*b;
		System.out.println("Area is :"+ area);
	}
	
	public void area(int l,int b,int h) {
		int area = l*b*h;
		System.out.println("Area is :"+ area);
	}
}
