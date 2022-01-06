package Seminar7;
import java.util.*;
public class guessingGame {
	public static void main(String args[])
    {
		boolean play = true;
        while(play)
        {
            Scanner input = new Scanner(System.in);
            int count =1;
            int random = (int)(Math.random() * 100 + 1);
            System.out.println("I am thinking of a number between 1 and 100: ");
            System.out.println("Can you guess the number? ");
            System.out.println("Enter your guess: ");
            
            while(!input.hasNextInt())
            {
                input.nextLine();
                System.out.println("Please enter a vaild digit");
            }
            int guess = input.nextInt();
        
            while (guess !=random)
            {
            	if ((Math.abs(random- guess)) <= 10)
                {
            		
                    System.out.println("You are within 10 ");
                }
                else if( guess > random)
                {
                    System.out.println("Lower");
                }
                else if( guess < random )
                {   
                    System.out.println("Higher");
                }
                
            
                System.out.println("Try again: ");
                while(!input.hasNextInt())
                {
                    input.nextLine();
                    System.out.println("Please enter a cunt digit");
                }
                guess = input.nextInt();
                count++;
            }
            System.out.println("Congrats you got it in " + count + " gusses!");
            
            
            System.out.println("Do you want to play again: Y or N");
            String play_again = input.next();
            
            if (play_again.startsWith("n")) 
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
