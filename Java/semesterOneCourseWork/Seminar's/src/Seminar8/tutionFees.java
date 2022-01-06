package Seminar8;

import java.util.Scanner;

public class tutionFees 
{

	public static void main(String[] args) 
	{
		double fees = 9000;
		double target = 27000;	
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter you age: ");
		while(!input.hasNextInt())
		{
			System.out.println("Please enter a digit: ");
			input.nextLine();
		}
		int age = input.nextInt();
		
		while(fees <= target)
		{
			age++;
			System.out.println(fees);
			fees = calc(fees);
		}
		System.out.println("You will be " + age + " When your fees will be £27000");
		
	}
	static double calc(double fees)
	{
		double newfees = (fees * 1.06);
		return newfees;
		
	}

}
