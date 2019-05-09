package Java;

import java.util.Scanner;

public class ReverseString {

	
	public static void main(String [] args) {
		
//		String org,rev="";
//		Scanner sc = new Scanner(System.in);
//		
//		System.out.println("Enter String to reverse..");
//		org = sc.nextLine();
//		
//		int length = org.length();
//		
//		for(int i = length-1;i>=0;i--) {
//			rev = rev +org.charAt(i);
//		
//			System.out.println("Reverse of String :"+rev);
//		}
//		

		
		String a="";
		for(int i=1;i<6;i++) {
			a=a+"*";
			System.out.println(a);
			
		}
		
		System.out.println("***********************************");
		int n=5;
		 int i, j; 
		  
	        // outer loop to handle number of rows 
	        //  n in this case 
	        for(i=0; i<n; i++) 
	        { 
	  
	            // inner loop to handle number spaces 
	            // values changing acc. to requirement 
	            for(j=2*(n-i); j>=0; j--) 
	            { 
	                // printing spaces 
	                System.out.print(" "); 
	            } 
	             
	            //  inner loop to handle number of columns 
	            //  values changing acc. to outer loop 
	            for(j=0; j<=i; j++) 
	            { 
	                // printing stars 
	                System.out.print("* "); 
	            } 
	              
	            // ending line after each row 
	            System.out.println(); 
	        } 
	}
}
