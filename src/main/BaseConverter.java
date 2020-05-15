package main;

import java.util.Scanner;
import java.math.*;

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
					case "hex": 	fromHex(number.toUpperCase());break;

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
		hexadecimal = number;
		long dec = hexToDecimal(number);
		decimalToBinary(dec);
	}

	private static void fromBinary(String number) {
		binary = number;
		long dec = binaryToDecimal(number);
		decimalToHex(dec);
	}
	

	private static void fromDecimal(String number) {
		int dec = Integer.parseInt(number);
		decimal = number;
		decimalToHex(dec);
		decimalToBinary(dec);
		System.out.println();
	}

	private static int binaryToDecimal(String bi) {
		int numDigits = bi.length();
		int dec = 0;
		
		for(int i = 0; i<numDigits; i++) {
			int digit = Character.getNumericValue(bi.charAt(i));
			switch(digit) {
				case 0: break;//do nothing
				case 1: dec+=Math.pow(2, i);break; //add a power of 2
				default: throw new IllegalArgumentException("hi");//not binary
			}
		}
		
		decimal += dec;
		
		return dec;
	}
	
	private static int hexToDecimal(String hex) {
		int numDigits = hex.length();
		int dec = 0;
		
		for(int i = 0; i<numDigits; i++) {
			int digit = Character.getNumericValue(hex.charAt(numDigits -1- i));
			
			if(digit>15)
				throw new IllegalArgumentException("hi");//not hex
			
			dec += digit*Math.pow(16, i);
		}
		
		decimal += dec;
		
		return dec;
	}
	
	private static void decimalToBinary(long dec) {
		int exp;
		BigInteger bi = new BigInteger("0");
		BigInteger ten = new BigInteger("10");
		
		while(dec>0) {
			exp = 0;
			while(dec>=Math.pow(2, exp+1)) {//finding the smallest power of 2 smaller than dec
				exp++;
			}
			
			dec -= Math.pow(2, exp); //changing 
			bi = bi.add(ten.pow(exp)); //adding that number to the binary representation
		}
		
		binary += bi;
	}

	private static void decimalToHex(long dec) {
		int exp;
		int multiply;
		
		System.out.println("hi");
		
		while(dec>0) {
			exp = 0;
			while(dec>=Math.pow(16, exp+1)) {//finding the smallest power of 16 smaller than dec
				exp++;
			}
			
			multiply = (int) (dec/Math.pow(16, exp));//finding how many times the smalles power goes into dec
			
			switch(multiply) {//decide which symbol to use
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
