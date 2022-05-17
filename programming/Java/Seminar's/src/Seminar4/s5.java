package Seminar4;

import java.util.Scanner;

public class s5 {
	public static void set5() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter age: ");
		int age;
		
		while(!sc.hasNextInt()) {
			
			System.out.println("Please enter an integer");
			sc.next();
		}
	age = sc.nextInt();
	 
		
	
	if (age<2) {
		System.out.println("infant");
		
	}
	
	else if ( age< 10 ) {
		System.out.println("child");
	}
	else if (age <= 19) {
		System.out.println("teenager");
	}
	else {
		System.out.println("adult");

	}
	}
	

	public static void main(String[] args) {
		
		
			set5();
		

}
}
