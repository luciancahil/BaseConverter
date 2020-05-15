package main;

import java.util.Scanner;

public class BaseConverter {
	static String decimal = "";
	static String binary = "";
	static String hexadecimal = "";
	
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
		
		output();
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
		System.out.println();
	}


	private static void decimalToBinary(int dec) {
		int exp;
		int bi = 0;
		
		while(dec>0) {
			exp = 0;
			while(dec>=Math.pow(2, exp+1)) {//finding the smallest power of 2 smaller than dec
				exp++;
			}
			
			dec -= Math.pow(2, exp); //changing 
			bi += Math.pow(10, exp); //adding that number to the binary representation
		}
		
		binary += bi;
		
	}


	private static void decimalToHex(int dec) {
		int exp;
		int hex = 0;
		int multiply;
		
		System.out.println("hi");
		
		while(dec>0) {
			exp = 0;
			while(dec>=Math.pow(16, exp+1)) {//finding the smallest power of 16 smaller than dec
				exp++;
			}
			
			multiply = (int) (dec/Math.pow(16, exp));//finding how many times the smalles power goes into dec
			
			switch(multiply) {
				case 10: hexadecimal += "A";break;
				case 11: hexadecimal += "B";break;
				case 12: hexadecimal += "C";break;
				case 13: hexadecimal += "D";break;
				case 14: hexadecimal += "E";break;
				case 15: hexadecimal += "F";break;
				default: hexadecimal += multiply;
			}
			
			dec -= multiply*Math.pow(16, exp); //changing 
		}
	}
	
	private static void output() {
		System.out.println("Decimal: " + decimal);
		System.out.println("Binary: " + binary);
		System.out.println("Hexadecimal: " + hexadecimal);
	}
}
