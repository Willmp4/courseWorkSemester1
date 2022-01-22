package Java.semesterOneCourseWork.onlineShop;

/**
 * This is a programme to display a set list of items and get the user to input an int
 * to select a product and then ask how many they want and then display there total cost
 * And show the user what they bought.
 */
import java.util.*;

public class onlineShopSimple {

  static HashMap<String, Integer> items_map = new HashMap<String, Integer>(); // HashMap for user entry
  static HashMap<Integer, String> items = new HashMap<Integer, String>(); // HashMap for Items store has
  static HashMap<String, Integer> prices = new HashMap<String, Integer>(); // HashMap for prices of items
  static Scanner input = new Scanner(System.in); // So user can input strings
  static ArrayList<String> items_list = new ArrayList<String>(); // ArrayList for items entered
  static String TEXT_RED = "\u001B[31m"; // To coulor Text
  static String TEXT_WHITE = "\u001B[37m";
  static int total = 0; // Total
  static int q = 0; // Quantity

  static void menu() {
    prices.put("Kombucha", 3);
    prices.put("Creatine", 25);
    prices.put("PS5\t", 200);
    prices.put("Puppies ", 50);
    // Puts items into items map: Key(string) value(int)
    items.put(1, "Kombucha");
    items.put(2, "Creatine");
    items.put(3, "PS5\t");
    items.put(4, "Puppies ");
    // Puts prices into prices map: Key(int) value(String)
    System.out.println(TEXT_RED + "+==================================+");
    System.out.println("\t* Sundaland *");
    for (int i = 1; i < prices.size() + 1; i++) {
      System.out.println(
        "+  " +
        i +
        "." +
        "\t" +
        items.get(i) +
        "\t" +
        "£" +
        prices.get(items.get(i))
      );
      // Prints out all the items within the list map.
      // .get() for HashMaps gets the value of the key.
      // prices.get(item.get(i)) will return the value(string) e.g i = 1 value =
      // Kombucha
    }
    System.out.println("+==================================+" + TEXT_WHITE);
  }

  public static int choice() {
    // Methode to get the user entry
    // Return an int
    System.out.println("What would you like to order?");
    System.out.println("Enter a item ID: ");
    while (!input.hasNextInt()) {
      // While loop to check user enters an int
      System.out.println("Enter a proper digit: ");
      input.next();
    }
    int number = input.nextInt();
    while (!(number <= items.size() && number > 0)) {
      // To check numbers match the Store ID
      System.out.println("Please enter a number between 1 and " + items.size());
      number = input.nextInt();
    }
    return number;
  }

  public static int quantity(int choice) {
    // Methode to get how many items the user wants
    System.out.println("How many " + items.get(choice) + "'s do you want?");
    while (!input.hasNextInt()) {
      System.out.println("Enter a proper digit: ");
      input.next();
    }
    int quan = input.nextInt();
    return quan;
  }

  public static void run() {
    int choice = choice();
    // Asks for the user input
    if (!items_map.containsKey(items.get(choice))) {
      // If the user enters an int which isn't in itemMap then put there choice in
      // itemMap and items_list
      // then ask for quantity
      q = quantity(choice);
      items_map.put(items.get(choice), q);
      // keep track of items and what the quantity is
      // To be used later to return the product of q and price of each product.
      items_list.add(items.get(choice));
      // To help with .get mothdes and use of index in recipte()
    } else {
      // If the choice is in ItemMap then ask how much more they want
      // Update the HashMap
      System.out.println(
        "How much more " + items.get(choice) + " do you want?"
      );
      int xq = input.nextInt();
      items_map.replace(items.get(choice), q += xq);
    }
  }

  public static void receipt(String title) {
    // Gives the receipt of what the user has already added to ItemsMap
    System.out.println(TEXT_RED + "************************");
    System.out.println("*" + "    YOUR " + title + "   \t*");
    System.out.println("*ITEMS" + "\tQuan\t TOTAl*");

    for (int i = 0; i < items_map.size(); i++) {
      System.out.println(
        "*" +
        items_list.get(i) +
        "  " +
        items_map.get(items_list.get(i)) +
        "\t" +
        " £" +
        (items_map.get(items_list.get(i)) * prices.get(items_list.get(i)))
      );
      // For i in num times user buys something, total = total + (value of each
      // key/quantity)*price of item using key
      // Because when .get is used the key returns the value which was q(quantity) and
      // times it by the price
      // which is by also using the .get method which cross reference using the items
      // list, producing the price
      total += items_map.get(items_list.get(i)) * prices.get(items_list.get(i));
    }
    System.out.println("*Total spent" + "\t £" + (total) + "\t*");
    System.out.println("************************");
  }

  public static String startAgain() {
    // Methode to ask the user if they want to add another item
    System.out.println(
      "Do you want another Item? \n5 to exit or any other to continue: "
    );
    System.out.println("Or enter basket or b to view your basket.");
    String again = input.next();

    return again;
  }

  public static void main(String[] args) {
    while (true) {
      menu();
      // Prints menu
      run();
      // Ask for choice, quan and amends apropriate Maps/List
      String again = startAgain();
      if (again.startsWith("5")) {
        System.out.println("Thanks for shopping!");
        break;
      } else if (again.startsWith("b")) {
        receipt("Basket");
      } else {
        continue;
      }
    }
    receipt("receipt");
    // Prints out receipt
  }
}
