package Seminar7;
import java.util.*;

public class passwordGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String pword = "Gurt";
        int k = 5 ;
        System.out.println("Try and guess the password: ");
        System.out.println("You have 5 tries!");
        for(int i = 1; i <=k; i++)
        {
            String user = input.nextLine();
            if (k ==i)
            {
                System.out.println("You failed!");
             }
            else if (user.equals(pword))
             {
                 System.out.println("Well done you got it!");
                 break;
             }
             else
             {
                System.out.println("You have " + (k-i) + " trys left! ");
                System.out.println("Try again: ");
             }
        }
        
    }
}




