import java.util.*;
import java.util.Collection;
import java.util.stream.Collectors;

public class ikraamWay {

  static ArrayList<String> names = new ArrayList<String>();
  static ArrayList<Integer> count = new ArrayList<Integer>();
  static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println(
      "This is a voting programme, keep entering names until you and when you're done then \n it will display the winner and show all votes that have been enterd"
    );
    String name = "";
    while (true) {
      System.out.println("Enter the name you want to vote for!");
      name = input.next();
      if (names.contains(name)) {
        int i = names.indexOf(name);
        Integer j = count.get(i);
        j++;
        count.set(i, j);
      } else {
        names.add(name);
        count.add(1);
      }
      System.out.println("Do you want to vote again? Enter -1 to stop: ");
      String again = input.next();

      if (again.equalsIgnoreCase("-1")) {
        for (int i = 0; i < names.size(); i++) {
          System.out.println(names.get(i) + " " + count.get(i));
        }
        Integer maxi = Collections.max(count);
        if (!tie(count, maxi)) {
          for (int i = 0; i < names.size(); i++) {
            if (count.get(i) == maxi) {
              System.out.println(
                "The winner is " +
                names.get(i) +
                " with " +
                count.get(i) +
                " vote!"
              );
            }
          }
        } else {
          System.out.println("There has been a tie! ");
          System.out.println("Please enter the a name to break the tie");
          String tie = input.next();
          System.out.println(tie + " won with " + (maxi + 1) + " Votes");
        }
        break;
      } else {
        continue;
      }
    }
  }

  static boolean tie(ArrayList count, Integer max) {
    for (int i = 0; i < count.size(); i++) {
      for (int n = 0; n < i; n++) {
        String str = count.get(i).toString();
        int num = Integer.parseInt(str);
        if (count.get(i) == count.get(n) && num >= max) {
          return true;
        }
      }
    }
    return false;
  }
}
