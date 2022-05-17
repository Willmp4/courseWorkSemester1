package Seminar8;

import java.util.Scanner;

public class isEven {
	static Scanner input = new Scanner(System.in);
	static int isNum()
	{
		System.out.println("Please enter a number: ");
		while(!input.hasNextInt())
		{
			System.out.println("Pleae eneter a vaild number: ");
			input.next();
		}
		int num = input.nextInt();
		return num;
	}
	static void IsEven()
	{
		int choice = isNum();
		if(choice % 2 == 0)
		{
			System.out.println("This is a odd number" + choice);
			
			
		}
		else
		{
			System.out.println("This is an odd number! ");
		}
		
		
		
	}
	public static void main( String[] args)
	{
		IsEven();
	}

}
