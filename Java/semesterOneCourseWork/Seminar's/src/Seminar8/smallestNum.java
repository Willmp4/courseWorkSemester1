package Seminar8;

import java.util.*;


public class smallestNum {

	public static void main(String[] args)
	{
		int count = 0;
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> inputs = new ArrayList<Integer>();
		
		boolean run = true;
		
		while (run)
		{
			System.out.println("Enter numbers and I will return the smallest one: ");
			System.out.println("Enter number: ");
			while(!input.hasNextFloat())
			{
				System.out.println("Enter a real number");
				input.next();
			}
			int num = input.nextInt();
			inputs.add(num);
			count ++;
			if(count > 3)
			{
				System.out.println("Do you want to add another number: ");
				String runAgain = input.next();
				if (runAgain.startsWith("n"))
				{
					run = false;
					Collections.sort(inputs);
					System.out.println("The smallest number was " + inputs.get(0));
				}
				else
					{
						continue;
					}
			}
			else
			{
				continue;
			}
				
			}
		}
		
	}


