package Seminar7;

import java.util.*;
public class Password2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        String pword = "Gurt";
        int k = 5;
        boolean play = true;
        while (play)
        {
        	int count = 0;
            System.out.println("Try and guess the password: ");
            System.out.println("You have 5 tries!");
	        while (count != k)
	        {	
	        	count++;
	        	String user = input.nextLine();
	        	
	        	if (user.equals(pword))
	        	{
	        		System.out.println("Access granted! ");
	        		break;
	        	}
	        	else if(user !=pword) 
	        	{
	        		if (count == 5) 
	        		{
	        			System.out.println("You are out of tries, better luck next time hacker!");
	        		}
	        		else 
	        		{
		        	System.out.println("Access denied! ");
		        	System.out.println("Try again!");
		        	System.out.println("You have " + (k-count));
	        		}
	        	}	
	        }
	        System.out.println("Do you want to play again? y or n");
	        String play_again = input.nextLine();
	        
	        if (play_again.startsWith("n"))
	        {
	        	System.out.println("Thanks for playing!");
	        	play = false;
	        }
	        
	        continue;
	      }
	}
}
	

