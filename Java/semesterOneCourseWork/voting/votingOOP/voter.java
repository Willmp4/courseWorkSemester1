package Java.semesterOneCourseWork.voting.votingOOP;

/**
 * This is a programme declaring the voter object.
 */
import java.util.Scanner; //imports scanner

public class voter extends Attributes {

  private String name;
  private int numOfVotes;
  private Scanner input = new Scanner(System.in);

  public voter(String name, int numOfVotes) {
    this.name = name;
    this.numOfVotes = numOfVotes;
  } //Is the constructor for voter

  public voter() {
    this.name = null;
    this.numOfVotes = 0;
  } //This is to set the default values

  @Override
  public String getName() {
    return name;
  } //Return the name of the voter

  @Override
  public int getNumOfVotes() {
    return numOfVotes;
  } //Returns the number of votes

  @Override
  public void setName() {
    name = input.nextLine();
  } //Uses scanner to get user input for the name

  @Override
  public void setNumOfVotes() {
    numOfVotes++;
  } //Increments numOfVotes by 1

  @Override
  public void showAttributes() {
    System.out.println("Name of voter: " + name + " with votes " + numOfVotes);
  }
}
