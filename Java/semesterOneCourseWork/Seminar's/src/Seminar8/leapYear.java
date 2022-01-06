package Seminar8;

import java.util.Scanner;

public class leapYear {
	static Scanner input = new Scanner(System.in);
	static int isNum()
	{
		System.out.println("Please enter a year to check weather it is a leap year: ");
		while(!input.hasNextInt())
		{
			System.out.println("Pleae eneter a vaild year: ");
			input.next();
		}
		int num = input.nextInt();
		return num;
	}
	static void calcLeapYear()
	{
		int num = isNum();
		if(num % 4 == 0)
		{
			System.out.println("The year you entered is a leap year!");
		}
		else
		{
			System.out.println("The year you entered was not a leap year! ");
		}
	}
	public static void main(String[] args) {
		
		calcLeapYear();
	}

}
