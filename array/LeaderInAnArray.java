/**
 * 
 */
package com.rais.array;

/**
 * @author rais
 *
 */
/* 


An element of array is leader if it is greater than or equal to all the elements 
to its right side. Also, the rightmost element is always a leader.


*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class LeaderInAnArray {
	public static void main (String[] args) throws Exception{
	    
	    // Using builder to avoid TLE in competitive coding.
	    BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	    
	   int testCases=Integer.parseInt(reader.readLine());
	   
	   for(int i=0;i<testCases;i++)
	   {
	       // Using stack because of its FILO property
          Stack<Integer> result=new Stack<Integer>();
	        int arraySize=Integer.parseInt(reader.readLine());
	        if(arraySize==0)
	        System.out.println();
	        
	        String numbers[]=reader.readLine().trim().split("\\s+");
	      result.push(Integer.parseInt(numbers[arraySize-1]));
	       
	        for(int j=numbers.length-2;j>=0;j--)
	        {
	            int num=Integer.parseInt(numbers[j]);
	            if( num>=result.peek())
	            {
	                result.push(num);
	            }
	        }
	        // Using StringBuilder to save Sysout time.
	        StringBuilder  resultPrinter=new StringBuilder();
	       while(!result.empty())
	       resultPrinter.append(result.pop()+" ");
	        System.out.println(resultPrinter.toString());
	   }

	}
}