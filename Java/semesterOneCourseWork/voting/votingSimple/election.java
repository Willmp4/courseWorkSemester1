package Java.semesterOneCourseWork.voting.votingSimple;

/**
 * This is a programme thaat acts as an election simulatore 
 * Allows the user to keep entering names until they won't to stop and then displays the winner with the number of votes
 * Also displays all the votes enterd 
 * @author William Bruckmann
 */
import java.util.*;
import java.util.stream.Collectors;

public class election {
	static ArrayList<String> names = new ArrayList<String>();
	static HashMap<String, Integer> choices = new HashMap<String, Integer>();
	static boolean run = true;
	static Scanner input = new Scanner(System.in);

	static String choices() {
		System.out.println("Enter the name you want to vote for: ");
		String element = input.next();
		return element;
		// Get user input
	}

	static String addToList(String element) {
		if (!names.contains(element)) {
			choices.put(element, 1);
			// if the list does not contain the previously returned string add it in to a
			// hashmap
		} else {
			choices.replace(element, choices.get(element) + 1);
			// else replace the key the same string but incamnet the value by one
		}
		return element;
		// return what choice() returned as well
	}

	public static void main(String[] args) {
		System.out.println("This is an election programme");
		System.out.println("Enter votes and the programme will show you all the votes and say who the winner is.");
		while (run) {
			String x = choices();
			// assing the return value to x
			names.add(addToList(x));
			// add the return value of addToList to hashmap or incrament value of key
			List<String> finalCH = names.stream().distinct().collect(Collectors.toList());
			// list to filter out duplicate entries
			// As not to print out multiple of the same names at the termination of the
			// programme
			int max = Collections.max(choices.values());
			// to generate the max value in choices map
			List<String> keys = new ArrayList<>();
			// list to find most voted for person
			for (java.util.Map.Entry<String, Integer> entry : choices.entrySet()) {
				if (entry.getValue() == max) {
					keys.add(entry.getKey());
				}
				// add entries to key if max == the value of that entry
				// first iteration max always =1 because there is only one entry
				// add it to keys
				// if two different strings are entered after then both become elements
				// if the first string is entered again then a list is created for the keys with
				// the value 2
			}
			System.out.println("Do you want to vote again?: Enter -1 if no");
			while (!input.hasNextInt()) {
				System.out.println("Enter -1 to end it and 1 to vote again: ");
				input.next();
				// check is the user enters an int
			}
			int runOff = input.nextInt();
			if (runOff == -1) {
				run = false;
				// controls the loop end it when false
				System.out.println("Vote " + "\tVotes");
				for (int i = 0; i < finalCH.size(); i++) {
					// go through for the size of finalCHlist
					System.out.println(finalCH.get(i) + "\t" + choices.get(finalCH.get(i)));
					// gets the key ith key from finalCH and the value of the corresponding keys
				}
				if (keys.size() <= 1) {
					System.out.println(keys.get(0) + " is the winner!");
				} else {
					System.out.println(keys + " is the winner!");
				}
			} else {
				continue;
				// if the user enters anything apart from -1 then continue;
			}
		}
	}
}
