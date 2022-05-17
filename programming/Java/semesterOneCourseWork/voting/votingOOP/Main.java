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

/**
 * This is a programme that allows the user to enter names until they don't want to and then displays the string with the most entries.
 * There is a tie breaker which will be prompted if there is more than one voter with the same amount of votes.
 */
public class Main {

  public static void main(String[] args) {
    pollingStation polls = new pollingStation();
    polls.voting();
  }
}
