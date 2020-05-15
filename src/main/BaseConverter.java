package main;

import java.util.Scanner;

public class BaseConverter {
	int decimal = 0;
	String binary = "";
	String hex = "";
	
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
				case "decimal":	fromDecimal(); break;
				case "binary": 	fromBinary();break;
				case "hex": 	fromHex();break;
				case "done":	isDone = true; break;
				default: 			System.out.println("I do not recognize that command");
			}
		}
		input.close();
	}


	private static void fromHex() {
		// TODO Auto-generated method stub
		
	}


	private static void fromBinary() {
		// TODO Auto-generated method stub
		
	}


	private static void fromDecimal() {
		// TODO Auto-generated method stub
		
	}
}
