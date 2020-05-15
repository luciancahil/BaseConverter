package main;

import java.util.Scanner;

public class BaseConverter {
	static String decimal = "";
	static String binary = "";
	static String hex = "";
	
	public static void main(String[] args) {
		decimalToBinary(11);
		System.out.println("Hi");
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
		int dec = Integer.parseInt(number);
		decimal = number;
		decimalToHex(dec);
		decimalToBinary(dec);
	}


	private static void decimalToBinary(int dec) {
		int bi = 0;
		int exp;
		
		while(dec>0) {
			exp = 0;
			while(dec>=Math.pow(2, exp)) {//finding the smallest power of 2 smaller than dec
				exp++;
			}
			
			dec -= Math.pow(2, exp-1); //changing 
			bi+= Math.pow(10, exp-1); //adding that number to the binary representation
		}
		
		binary += "" + bi;
	}


	private static void decimalToHex(int dec) {
		
	}
}
