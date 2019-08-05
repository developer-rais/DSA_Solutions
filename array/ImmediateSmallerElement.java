
package com.rais.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

class ImmediateSmallerElement {
	public static void main(String[] args) {

		// Scanner scanner=new Scanner(System.in);
		try (Scanner scanner = new Scanner(System.in);) {
			int totalTestCases = scanner.nextInt();

			for (int testCaseNumber = 0; testCaseNumber < totalTestCases; testCaseNumber++) {
				int inputArraySize = scanner.nextInt();
				int inputArray[] = new int[inputArraySize];
				for (int i = 0; i < inputArraySize; i++)
					inputArray[i] = scanner.nextInt();
				
				if(inputArraySize==0)
					System.out.println();
				else
				printImmediateSmallerElements(inputArray, inputArraySize);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	public static void printImmediateSmallerElements(int inputArray[],
			int inputArraySize) {
		// LinkedList to handle duplicate element case.
		HashMap<Integer, LinkedList<Integer>> resultMap = new HashMap<Integer,  LinkedList<Integer>>();

		Stack<Integer> stack = new Stack<Integer>();

		stack.push(inputArray[0]);

		for (int i = 1; i < inputArraySize; i++) {
			if (stack.empty()) {
				stack.push(inputArray[i]);
				continue;
			}
			while ((!stack.empty()) && (inputArray[i] < stack.peek())) {
										
				
				LinkedList<Integer> linkedList=resultMap.get(stack.peek());
				if(linkedList==null)
					linkedList=new LinkedList<Integer>();
				
				linkedList.add(inputArray[i]);
				
				if(!resultMap.containsKey(stack.peek()))
					resultMap.put(stack.peek(), linkedList);
				stack.pop();
				
			}
			stack.push(inputArray[i]);

		}
		while (!stack.empty()) {
			LinkedList<Integer> linkedList=resultMap.get(stack.peek());
			if(linkedList==null)
				linkedList=new LinkedList<Integer>();
			
			linkedList.add(-1);
			
			if(!resultMap.containsKey(stack.peek()))
				resultMap.put(stack.peek(), linkedList);			
			stack.pop();
		}
		
		
		
		for (int i = 0; i < inputArraySize; i++)
		{
			LinkedList<Integer> linkedList=resultMap.get(inputArray[i]);
			System.out.print(linkedList.get(0)+" ");
			linkedList.remove(0);
		}
		System.out.println();
			
	}

}
