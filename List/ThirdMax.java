/*
 *@author Prakhar Khandelwal
 *
*/

// Compute Third max in a List in O((n^2)/2) without sorting.

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;

class Solution{

	private static String MISMATCH = "Oops! You have entered wrong input, Please enter it again.";
	private static String ELEMENT_COUNT_MSG = "Enter the element count you want to insert:";
	private static String elementPosition(int i){
		return "Enter element at "  + (i+1) + ": ";
	}
	private static int N;
	private static int MIN = -2147483648;
	private static List<Integer> array= new ArrayList<>();
	private static Scanner scanner;

	public static void main(String arg[]){
 		scanner=new Scanner(System.in);
		System.out.println(ELEMENT_COUNT_MSG);
		N=scanner.nextInt();
		readInput(0);
		scanner.close();

		int sec=MIN,max=MIN,third=MIN;

		// for N==1 set max as input entered 
		if(N==1){
			max=array.get(0);
		}

		//main logic
		for(int j=0;j<N-1;j++){
			if(array.get(j)<=array.get(j+1)){
				if(array.get(j+1)>max){  // for max.
					sec=max;
					max=array.get(j+1);
				}
				if(array.get(j)>=sec)  // for second max
					sec=array.get(j);
				for(int k=j-1;k>=0;k--){   // for third max.
					if(array.get(k)<sec  && array.get(k)>=third)
						third=array.get(k);
				}		 
			 }else{
				if(array.get(j)>=max) // for max.
						max=array.get(j);
				if(array.get(j+1)>=sec) // for second max.
					sec=array.get(j+1);
				else if(array.get(j+1)>=third) // for third max.
					third=array.get(j+1);
			 }
		}
	     	System.out.println("MAX = "+ max +  " Second MAX =" + sec + " Third MAX = "+ third); 
	}

	private static void readInput(int i){
	 	if(i==N)return;
	 	try{
	 		System.out.println(elementPosition(i));
	 		int a = scanner.nextInt();
			array.add(a);
			readInput(i+1);		
	  	}catch(InputMismatchException exception){
	  		System.out.println(MISMATCH);
	  		scanner.next();
	  		readInput(i);
	  	}
	}
}
