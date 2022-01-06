package Seminar6;

import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a digit: ");
		
		double a = input.nextDouble();
		System.out.println("Enter a digit: ");
		
		double b = input.nextDouble();
		
		System.out.println("Which operator do you want to use: ");
		char operator = input.next().charAt(0);
		switch(operator ) {
		case '+' :
			System.out.println("a + b = " + (a + b));
			break;
		case '-' : System.out.println(a-b); break;
		case '/' : System.out.println(a/b); break;
		default:
		}
	}

}
