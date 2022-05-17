package Seminar4;

import java.util.Scanner;

public class Pset_2 {
	static void Upper() {
		Scanner sc = new Scanner(System.in);
		String p,q,r;
		
		System.out.println("Enter p");
		p = sc.nextLine();
		
		System.out.println("Enter q");
		q = sc.nextLine();
		
		System.out.println("Enter r");
		r = sc.nextLine();
		
		System.out.println(p.toUpperCase() + " " + q.toUpperCase() + " " +  r.toUpperCase());
		
		System.out.println(r.toLowerCase()+ " " + p.toLowerCase());
		
		System.out.println(p.chars().filter(ch -> ch != ' ').count() + q.chars().filter(ch -> ch != ' ').count()+ r.chars().filter(ch -> ch != ' ').count());
	}

	public static void main(String args[]) {
		boolean play = true;
		Scanner  sc = new Scanner(System.in);
		
		while (play) 
		{
			Upper();
			
			System.out.println("Do you want to play again? \n\n enter yes or no: ");
			
			if(sc.next().startsWith("n"))
			{
				play = !play;
				System.out.println("Thanks for using!");
			}
			continue;
	}

}
}
