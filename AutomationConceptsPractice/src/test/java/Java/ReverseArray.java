package Java;

import com.google.common.net.InetAddresses;

public class ReverseArray {
	 
//	  static void reverse(int a[], int n) 
//	    { 
//	        int[] b = new int[n]; 
//	        int j = n; 
//	        for (int i = 0; i < n; i++) { 
//	            b[j - 1] = a[i]; 
//	            j = j - 1; 
//	        } 
//	  
//	        /*printing the reversed array*/
//	        System.out.println("Reversed array is: \n"); 
//	        for (int k = 0; k < n; k++) { 
//	            System.out.println(b[k]); 
//	        } 
//	    } 
//	  
//	    public static void main(String[] args) 
//	    { 
//	        int [] arr = {10, 20, 30, 40, 50}; 
//	        
//	        reverse(arr, arr.length); 
//	    } 
	
	
	static void reverseArray(String[]a,int length) {
		 String[]b = new String[length];
		 int j=length;
		 
		 for(int i=0;i<length;i++) {
			 b[j-1]= a[i];
			 j=j-1;
		 }
		 
		 //for loop for printing array
		 System.out.println("Reverse array is :");
		 for(int k=0;k<length;k++) {
			 
			 System.out.println(b[k]);
		 }
	}
	
	public static void main(String[] args) {
		String [] a= {"Hii","Hello","Hru?"};
		reverseArray(a, a.length);
	}
}
