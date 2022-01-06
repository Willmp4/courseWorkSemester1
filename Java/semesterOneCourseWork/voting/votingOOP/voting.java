package Java.semesterOneCourseWork.voting.votingOOP;

/**
 * This is the logic for using voter -> Would be the controller in a Model - Controller - view structer 
 * It has methodes to:
 * addToList -> to check weather the input has been entered before
 * tie -> To check weather there is a tie, meaning there is more than one voter with the same numOfVotes
 * getMostVotes -> To display the voter with the most numOfVotes based on weather there is a tie or not  
 */
import java.util.*;

public class voting {
	static Scanner input = new Scanner(System.in);// Scanner named input

	/**
	 * @param list
	 * @param names
	 *              !Wasn't able to find a way to only use one param and check if
	 *              voter is in the voter ArrayList
	 *              Methode to init a voter object (to be used in a while loop) ->
	 *              uses voter no args consructor create object -> asks user for
	 *              input using .setName()->Uses scanner from .util
	 * 
	 *              If statment check weather @param names has the user input as one
	 *              of the elements(.contains())
	 * 
	 *              If (false)->
	 *              there is no element from getName() equal to one insdie @param
	 *              names
	 *              Then set numOfVotes to 1 -> add this voter object to @param list
	 *              -> add getName() to @param names
	 * 
	 *              If true->
	 *              Use a for loop to check which @param list.get(i).getName()
	 *              from @param list
	 *              .get(j) accesses the positon of the @param list which is a voter
	 *              object meaning the .getters() and .setters() can be implamented
	 *              .setNumOfVotes() incraments the element which was equal to the
	 *              newly instantiated object voter.getName()
	 * 
	 */
	static void addToList(ArrayList<voter> list, ArrayList<String> names) {
		System.out.println("Enter the name you want to vote for: ");
		voter voter = new voter();
		voter.setName();
		if (!names.contains(voter.getName())) {
			voter.setNumOfVotes();
			list.add(voter);
			names.add(voter.getName());
		} else {
			for (int i = 0; i < list.size(); i++) {
				if (voter.getName().equals(list.get(i).getName())) {
					list.get(i).setNumOfVotes();
				}
			}
		}
	}

	/**
	 * @param list
	 * @return boolean
	 *         !This methode will check the elements more than once which is not
	 *         effecient
	 *         Sets maxNum useing methode getMostVostes()
	 *         Methode that uses two for loops to check every element of int type
	 *         from getNumOfVotes()
	 *         If any element match in @param list and that match is greater than
	 *         maNum
	 *         -> @return true
	 *         Else there is no match @return false
	 */
	public static boolean tie(ArrayList<voter> list) {
		int maxNum = getMostVotes(list);
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < i; j++) {
				if ((list.get(i).getNumOfVotes() == list.get(j).getNumOfVotes())
						&& list.get(j).getNumOfVotes() >= maxNum) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * @param list
	 * @return int maxNum
	 *         Methode to @return the maxNum of votes within @param list
	 *         The first for loop is to find the maxNum by setting a temp variable
	 *         to each of the numOfVotes and comparing it to the current maxNUm
	 *         e.g list[1,4,3,7,6]
	 *         Iteration 1 -> temp = 1, maxNum = 1
	 *         Iteration 2 -> temp = 4, maxNum = 4
	 *         Iteration 3 -> temp = 3, temp is not > than maxNum -> maxNum = 4
	 *         Iteration 4 -> temp = 7, maxNum = 7
	 *         Iteration -> temp = 6, temp is not > than maxNum -> maxNum = 7
	 *         maxNum = 7
	 */
	public static int getMostVotes(ArrayList<voter> list) {
		int tempNum;
		int maxNum = 0;

		for (int i = 0; i < list.size(); i++) {
			tempNum = list.get(i).getNumOfVotes();

			if (tempNum > maxNum) {
				maxNum = tempNum;
			}
		}
		return maxNum;
	}

	/**
	 * @param list
	 *             Use for loop to find which maxNum == one of the voter objects
	 *             in @param list
	 *             Then diplay the matching objects atrributes
	 */
	public static void showWinner(ArrayList<voter> list) {
		int maxNum = getMostVotes(list);

		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).getNumOfVotes() == maxNum) {
				System.out.println("Name of winner " + list.get(j).getName() +
						" Num. of votes " +
						maxNum);
				break;
			}
		}
	}

}