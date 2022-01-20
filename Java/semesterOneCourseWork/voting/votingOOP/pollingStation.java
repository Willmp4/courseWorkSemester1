package Java.semesterOneCourseWork.voting.votingOOP;

/**
 * This is the logic for using voter -> Would be the controller in a Model - Controller - view structer
 * It has methodes to:
 * addToList -> to check weather the input has been entered before
 * tie -> To check weather there is a tie, meaning there is more than one voter with the same numOfVotes
 * getMostVotes -> To display the voter with the most numOfVotes based on weather there is a tie or not
 */
import java.util.*;
import javafx.css.StyleableStringProperty;

public class pollingStation {

  private ArrayList<voter> list = new ArrayList<voter>(); // Array list for voter objects
  private ArrayList<String> names = new ArrayList<String>(); // Array list for names of user inputs
  static Scanner input = new Scanner(System.in); // Scanner named input

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
  private void addToList(ArrayList<voter> list, ArrayList<String> names) {
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
  private boolean tie(ArrayList<voter> list) {
    int maxNum = getMostVotes(list);
    for (int i = 0; i < list.size(); i++) {
      for (int j = 0; j < i; j++) {
        if (
          (list.get(i).getNumOfVotes() == list.get(j).getNumOfVotes()) &&
          list.get(j).getNumOfVotes() >= maxNum
        ) {
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
  private int getMostVotes(ArrayList<voter> list) {
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
  private void showWinner(ArrayList<voter> list) {
    int maxNum = getMostVotes(list);

    for (int j = 0; j < list.size(); j++) {
      if (list.get(j).getNumOfVotes() == maxNum) {
        System.out.println(
          "Name of winner " + list.get(j).getName() + " Num. of votes " + maxNum
        );
        break;
      }
    }
  }

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
  public void voting() {
    System.out.println("Welcome to the polling station, \nget ready to vote!");
    while (true) {
      addToList(list, names);
      System.out.println("do you want to vote again?");
      String again = input.next();
      if (again.startsWith("n")) {
        System.out.println("Name Num. of votes");
        for (int i = 0; i < list.size(); i++) {
          System.out.println(
            list.get(i).getName() + " \t" + list.get(i).getNumOfVotes()
          );
        }
        if (tie(list)) {
          int x = getMostVotes(list);
          System.out.println("There has been a tie! ");
          System.out.println(
            "Please enter the a name from the list to break the tie"
          );
          input.skip("\\R?");
          String tie = input.nextLine();
          boolean isTie = true;
          while (isTie) {
            if (names.contains(tie)) {
              System.out.println(tie + " won with " + (x + 1) + " Votes");
              isTie = false;
            } else {
              System.out.println("Please enter one of the names from the list");
              input.skip("\\R?");
              tie = input.nextLine();
            }
          }
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
