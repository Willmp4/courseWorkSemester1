package Seminar9;

import java.util.*;

public class Avrg10nums 
{
	static int total = 0;
	static ArrayList<Integer>num = new ArrayList<Integer>(); 
	static Scanner input = new Scanner(System.in);
	
	static int checkNum()
	{
		while(!input.hasNextInt())
		{
			System.out.println("Please enter a valid digit: ");
			input.next();
		}
		int num = input.nextInt();
		return num;
	}
	static int addNumToList()
	{
		int avg = 0; 
		while(num.size() <11)
		{
			System.out.println("Please enter a number");
			int x = checkNum();
			num.add(x);
			System.out.println(num);
		}
		for (int i = 0; i<num.size();i++)
		{
			total += num.get(i);
		}
		avg = total /num.size();
		return avg;
	}
	public static void main(String[] args)
	{
		System.out.println("Enter 10 numbers: ");
		int x = addNumToList();
		System.out.println("The total of all the numbers are " + total);
		System.out.println("The avrg of all the number you entered is: " + x);
	}
}
