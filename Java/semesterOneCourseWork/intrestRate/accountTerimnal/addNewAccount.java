package Java.semesterOneCourseWork.intrestRate;

import java.util.*;

public class addNewAccount {
	static ArrayList<Account> accounts = new ArrayList<Account>();
	static Scanner input = new Scanner(System.in);

	static String setFullName() {
		System.out.println("Enter Your full name");
		String fullName = input.nextLine();
		return fullName;
	}

	static double setBalance() {
		System.out.println("Enter the initail balance: ");
		double balance = input.nextDouble();
		return balance;
	}

	static void run() {

		boolean adding = true;
		while (adding) {
			Account account = new Account();
			account.setFullName(setFullName());
			account.setBalance(setBalance());
			account.setInterestRate(4.5);
			accounts.add(account);
			for (int i = 0; i < accounts.size(); i++) {
				System.out.println(accounts.get(i).getFullName() + " " + accounts.get(i).getDate());
			}

			System.out.println("do you want to add another account?");

			String again = input.next();
			if (again.startsWith("n")) {
				adding = !adding;
			} else {
				continue;
			}

		}
	}
}
