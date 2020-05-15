package main;

import java.util.Scanner;

public class BaseConverter {
	static String decimal = "";
	static String binary = "";
	static String hex = "";
	
	public static void main(String[] args) {
		inputs();
	}
	
	
	private static void inputs(){
		Scanner input = new Scanner(System.in);
		boolean isDone = false;
		String nextAction;
		
		while(!isDone) {
			System.out.println("What would you like to do?");
			nextAction = input.nextLine().toLowerCase();
			
			switch(nextAction) {
				case "decimal":	
				case "binary": 	
				case "hex": 	EnterNum(input,nextAction); break;
				case "done":	isDone = true; break;
				default: 		System.out.println("I do not recognize that command");
			}
		}
		input.close();
	}
	
	private static void EnterNum(Scanner input, String type) {
		boolean isValid = false;
		String number = "";
		
		while(!isValid) {
			try {
				System.out.println("Please enter a number:");
				number = input.nextLine();
				
				switch(type) {
					case "decimal":	fromDecimal(number); break;
					case "binary": 	fromBinary(number);break;
					case "hex": 	fromHex(number);break;

				}
				
				isValid = true;
			}catch(Exception e) {
				System.out.println("ERROR!");
				System.out.println(number + " is not valid for " + type);
			}
		}
	}


	private static void fromHex(String number) {
		
	}


	private static void fromBinary(String number) {
		
	}


	private static void fromDecimal(String number) {
		
	}
}
