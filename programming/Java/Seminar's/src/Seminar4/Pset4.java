package Seminar4;

import java.util.Scanner;

public class Pset4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter any Digit");

		while (!sc.hasNextInt()) {

			System.out.println("This is 5");
			sc.next();
		}
		int a = sc.nextInt();

		if (a < 0) {
			System.out.println("This is a neg");
		} else {
			System.out.println("This is positive");
		}

	}

}
