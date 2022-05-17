package Seminar9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class findDuplicateNumbers {
	static double total = 0;
	static int count = 0;
	static ArrayList<Integer>duplicateNum = new ArrayList<Integer>(); 
	static ArrayList<Integer>finalnums = new ArrayList<Integer>(); 
	static Scanner input = new Scanner(System.in);

	static void addNumToList()
	{
		//Adds a 100 random numbers to a list
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		for (int i=0; i<100; i++)
		{
		    Integer r = rand.nextInt(100);
		    if(!finalnums.contains(r))
		    {
		    	finalnums.add(r);
		    }
		    else if(!duplicateNum.contains(r))
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
		Collections.sort(finalnums);
		System.out.println(finalnums);
		Collections.sort(duplicateNum);
		
		System.out.println("From 100 random numbers, the duplicate numbers where: ");
		System.out.println(duplicateNum);
	}
}

