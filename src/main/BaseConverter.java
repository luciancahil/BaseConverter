package main;

import java.util.Scanner;

public class BaseConverter {
	String decimal = "";
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
		try {
			int n = 12/0;
		}catch(Exception e) {
			System.out.println("error!");
		}
	}
}
