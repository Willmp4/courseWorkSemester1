package Java.semesterOneCourseWork.voting.votingOOP;

/**
 * This is a main methode for the election project.
 * 
 * The programme allows the user to keep entering names until they want to stop and then displays the name with the most votes
 * 
 * This programme uses an OOP programming model.
 * Uses an Abstaction by using an Abstract Class to list out what methode the voter object should have. 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends voting {
	/**
	 * Extends voting as to impalament all the methodes for it
	 */
	static ArrayList<voter> list = new ArrayList<voter>();// Array list for voter objects
	static ArrayList<String> names = new ArrayList<String>();// Array list for names of user inputs

	static Scanner input = new Scanner(System.in);

	/**
	 * This is the main methode
	 * Does not take any command line args
	 * 
	 * Runs addToList() with the two args of @param typeProductList and @param
	 * typeStringNames
	 * The while loop makes it so that the voter object will get init every time the
	 * user wants to vote again
	 * 
	 * Ask the user if they want to vote again
	 * if yes ->
	 * the user can keep entering new names
	 * if no -> display the winners using a for loop
	 * check if there is a tie in @param list
	 * 
	 * if true -> set x to the maxNum
	 * and then ->
	 * displays the newly inputed name and maxNum +1
	 * !There is no check to see if the new entry is in the @param list of voter
	 * objects ->
	 * !If there is a tie the user could enter a string not in @param list that
	 * would be displayed
	 * 
	 * if false-> then display the winner
	 */
	public static void main(String[] args) {
		while (true) {
			addToList(list, names);
			System.out.println("do you waWint to vote again");
			String again = input.next();
			if (again.startsWith("n")) {
				System.out.println("Name Num. of votes");
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).getName() + " " + list.get(i).getNumOfVotes());
				}
				if (tie(list)) {
					int x = getMostVotes(list);
					System.out.println("There has been a tie! ");
					System.out.println("Please enter the a name to break the tie");
					String tie = input.next();
					System.out.println(tie + " won with " + (x + 1) + " Votes");
				} else {
					showWinner(list);
				}
				break;
			} else {
				continue;
			}
		}
	}

}
