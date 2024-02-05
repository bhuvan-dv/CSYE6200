package edu.neu.csye6200;

/**
 * 
 * @author Ruchika Sharma
 * 
 */

public class Driver {
	public static void main(String[] args) {
		System.out.println("============Main Execution Start===================\n\n");
         //Add your code in between these two print statements
		System.out.println("Integer Queue");
		Queue.demo();
		System.out.println("\n\nGeneric Queue");
		GenericQueue.demo();
		System.out.println("\n\nInteger Stack");
		Stack.demo();
		System.out.println("\n\nGeneric Stack");
		GenericStack.demo();
		System.out.println("\n\n============Main Execution End===================");
	}
}
