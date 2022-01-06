
package Java.semesterOneCourseWork.voting.votingOOP;

import java.util.Scanner;//imports scanner

public class voter extends Attributes {

	private String name;
	private int numOfVotes;
	private Scanner input = new Scanner(System.in);

	public voter(String name, int numOfVotes) {
		this.name = name;
		this.numOfVotes = numOfVotes;
	}

	public voter() {
		this.name = null;
		this.numOfVotes = 0;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getNumOfVotes() {
		return numOfVotes;
	}

	@Override
	public void setName() {
		name = input.nextLine();
	}

	@Override
	public void setNumOfVotes() {
		numOfVotes++;
	}

	@Override
	public void showAttributes() {
		System.out.println("Name of voter: " + name + " with votes " + numOfVotes);
	}

}