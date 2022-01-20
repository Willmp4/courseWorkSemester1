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

public class Main {

  public static void main(String[] args) {
    pollingStation polls = new pollingStation();
    polls.voting();
  }
}
