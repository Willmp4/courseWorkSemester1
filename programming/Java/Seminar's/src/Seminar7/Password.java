package Seminar7;
import java.util.*;
public class Password {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        String pword = "Gurt";
        int k = 5;
        int count =0;
        boolean play = true;
        
        
        while(play)
        {
        	System.out.println("Try and guess the password: ");
        	System.out.println("You have 5 tries!");
		        while (count != k)
		        {	
		        	
		        	String user = input.nextLine();
		        	count++;
		        	if(!user.equals(pword)) 
		        	{
		        		
		        	System.out.println("Access denied! ");
		        	System.out.println("Try again!");
		        	System.out.println("You have " + (k-count));
		        	
		        	}
		        	
		        	else if (count >= 5 && !user.equals(pword))
		        	{
		        		System.out.println("You are out of tries, better luck next time hacker!");
		        	}
		        	
		        	
		        	else 
		        	{
		        		System.out.println("Access granted! ");
		        		break;
		        	}
		        	
				}
		        count = 0;
		        
		        System.out.println("Do you want to play again? y or no: ");
		        String play_again = input.nextLine();
		        if(play_again.startsWith("n"))
		        {
		        	play = false;
		        	System.out.println("Thanks for playing! ");
		        	
		        }
		        else 
		        {
		        	continue; 
		        }
        }
	}

}
