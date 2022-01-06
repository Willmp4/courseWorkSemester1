package Seminar9;

import java.util.*;

public class duplicateString {

		static double total = 0;
		static int count = 0;
		static ArrayList<String>duplicateNum = new ArrayList<String>(); 
		static ArrayList<String>finalnums = new ArrayList<String>(); 
		static Scanner input = new Scanner(System.in);

		static void addNumToList()
		{
			
			for (int i=0; i<10; i++)
			{
				System.out.println("Enter a string: ");
			    String r = input.nextLine();
			    if(!finalnums.contains(r))
			    {
			    	finalnums.add(r);
			    }
			    else if (!duplicateNum .contains(r))
			    {
			    	finalnums.add(r);
			    	duplicateNum.add(r);
			    }
			    else
			    {
			    	finalnums.add(r);
			    }
			}
		}
		public static void main(String[] args)
		{
			addNumToList();
			System.out.println(finalnums);
			Collections.sort(duplicateNum);
			System.out.println("This was the duplicate strings.");
			System.out.print(duplicateNum);
		}
	}