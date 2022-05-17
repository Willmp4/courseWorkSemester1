package Java.semesterOneCourseWork.voting.votingOOP;

/*
Abstract Attributes class to define what the voter object should have for attributes.

getName() to grab the name of user -> used for displaying name to user
getNumOfVotes() to grab the number of votes the voter has -> used to display the number of votes the object has

setName() to set the name of the user -> set to the user input
setNumOfVotes() to increment the number of votes by one
@author William Bruckmann
*/
public abstract class Attributes {

  public abstract String getName();

  public abstract void setName();

  public abstract int getNumOfVotes();

  public abstract void setNumOfVotes();

  public abstract void showAttributes();
}
