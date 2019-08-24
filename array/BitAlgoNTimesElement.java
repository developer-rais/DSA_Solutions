import java.io.*;
import java.util.*;

class BitAlgoNTimesElement
{

/*

https://www.geeksforgeeks.org/find-the-element-that-appears-once/

Given an array where every element occurs N times, except one element which occurs M times . 
Find the element that occurs M times. Expected time complexity is O(n) and O(1) extra space.
Where n>m

Input 
3
2
1
10
12 1 12 3 12 1 1 2 3 3

*/

public static void main(String args[]) throws IOException
{

	BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

	int n=Integer.parseInt(reader.readLine());
	int m=Integer.parseInt(reader.readLine());
	int t=Integer.parseInt(reader.readLine());

	for(int x =0;x<t;x++)
	{
		int size=Integer.parseInt(reader.readLine());
		String numbers[]=reader.readLine().trim().split("\\s+");
         int arr[]=new int[32];
         for(int i=0;i<size;i++)
         {
           int number=Integer.parseInt(numbers[i]);
           int bitIndex=31;
           while(number!=0)
           	{
           	 if((number&1)!=0)
           	 	arr[bitIndex]++;
           	 bitIndex--;
           	 number=number>>1;
           	}

         }

         StringBuilder builder=new StringBuilder();

         for(int i=0;i<32;i++)
         {
         	if((arr[i]%n)!=0)
         		builder.append('1');
         	else
         		builder.append('0');

         }
         System.out.println(Integer.parseInt(builder.toString(),2));
	}

}
}