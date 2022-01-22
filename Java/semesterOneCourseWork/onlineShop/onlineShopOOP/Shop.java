/**
 * This is the logic for the shopping and would be classified as the controller in a module - view - controller design pattern
 * Using 3 arrays and a product class I was able to simulate an online shop.
 * The product class has some attributes that are easily accessed by using the getters.
 * @author William Bruckmann
 */
package Java.semesterOneCourseWork.onlineShop.onlineShopOOP;

import java.util.*;

public class Shop {

  private Product[] products = new Product[7]; // Create an array of pp spaces for the product type
  private String[] items = new String[products.length];

  private Product[] cart = new Product[products.length]; // Create an array of products length
  private int[] amount = new int[products.length]; // Create an array to show the amount of items entered
  private static Scanner input = new Scanner(System.in);

  /**
   * Uses the Product contractors to set the name price and Store ID
   * Init different products using the constructor
   */

  Product iPhone = new Product("Iphone", 1200.00, 1);
  Product Galaxy = new Product("Galaxy", 800.00, 2);
  Product LG = new Product("Lg tv", 1000.00, 3);
  Product RED = new Product("Red", 700.00, 4);
  Product Tesla = new Product("Tesla", 69420.00, 5);
  Product BMW = new Product("Bmw", 30000.00, 6);
  Product Dell = new Product("Dell", 400.00, 7);

  int total = 0; // Total

  /**
   * This a method to display the menu of Products
   * Shows the items from products to the user
   * As @ArrayList products is of Product type I can access the getters and setters using a for loop
   */
  private void menu() {
    System.out.println("+==================================+"); //Top of menu
    System.out.println("\t* Sunderland *"); //Title
    for (int i = 0; i < products.length; i++) {
      System.out.println(
        "+  " +
        products[i].getIndex() + //Gets he index
        "." +
        "\t" +
        products[i].getName() + //Gets name
        "\t" +
        "£" +
        products[i].getPrice()
      );
    }
    System.out.println("+==================================+"); //Print the end of the menu
  }

  /**
   *
   * @param title is what show if its the basket or
   * receipt
   *
   * Similar to @Method Menu()
   * Uses the getters and setters of Product to display different attributes
   *
   * Also Uses @Method getTotal() which returns the total cost of the cart
   */
  private void giveReceipt(String title) {
    // Method to print out the receipt
    System.out.println(title);

    System.out.println("Your items: \n");
    for (int k = 0; k < products.length; k++) {
      if (cart[k] != null) {
        // Prints out some of the product attributes and the amount of products
        // Also prints out the total cost for each item
        System.out.println(
          cart[k].getName() +
          " [" +
          amount[k] +
          "] x " +
          (cart[k].getPrice() * amount[k]) + // Gets the price and the returns the product of price times amount,
          "£\n"
        );
      }
    }
    System.out.println("Total cost is: £" + getTotal() + " \n");
  }

  /**
   *
   * @return total
   *
   * Uses a for loop to go through the none empty spaces in cart and += to total the getPrice and amount
   */
  private double getTotal() {
    total = 0; //Sets total to 0
    for (int k = 0; k < products.length; k++) {
      if (cart[k] != null) { // only check none empty index's
        total += cart[k].getPrice() * amount[k]; // Price * quan for every element that isn't empty
      }
    }
    return total; //Return the total
  }

  /**
   * Method to return an Item
   * uses a for loop to iterate and check if item match's up with any item in the cart
   */
  private void returnItem() {
    giveReceipt("Cart"); // Shows cart to show what has been removed
    System.out.println("Enter the product ID you wish to return!");
    System.out.println("You can only enter a integer: ");
    Scanner input2 = new Scanner(System.in);
    int item = input2.nextInt();
    if (amount[item - 1] > 0) {
      // To check if there is an item is that space
      for (int i = 0; i < products.length; i++) {
        // Go up to the length of items
        if (item == i) {
          // If item = i then set amount[i]to 0 and and cart[i] = 0
          amount[i - 1] = 0;
          cart[i] = 0;
        }
      }
    } else {
      System.out.println("You do not have this item!!!");
      //If there is no value greater than 0 in the amount[i] position then they don't have this item
    }
  }

  /**
   * This is the main Run method, which uses all the method's above to get the user to shop
   * I made a list of Product type and filled the list with Products, allowing me to use the getters and setters.
   * This is the only method that is public so other classes can use the  @method run().
   * The User can enter the store ID or the name of the product because of the try and catch statements
   */
  public void run() {
    products[0] = iPhone;
    products[1] = Galaxy;
    products[2] = LG;
    products[3] = RED;
    products[4] = Tesla;
    products[5] = BMW;
    products[6] = Dell;

    for (int i = 0; i < products.length; i++) {
      //This is a for loop append the names of the products to a list for easy access.
      //Used for when the user inputs the name of the product instead of the store ID.
      items[i] = products[i].getName();
    }

    List<String> list = Arrays.asList(items);
    //Turns the array to a list, meaning I can use .contains
    // Adds all the items to a list
    boolean shopping = true; // If false then programme ends
    while (shopping) {
      menu(); // Shows menu

      System.out.println("Enter the store ID or name of the item you want\n");
      input.skip("\\R?");
      //Found this online, stops the .nextLine() form being skipped.
      String choice = input.nextLine();

      System.out.println("Enter how many you would like: ");
      int quant = input.nextInt();
      try {
        //This try statement is try and convert the string the user entered into a Int
        //This is used for matching up the product Id with the user entry.
        int output = Integer.parseInt(choice);
        if (output <= products.length && output > 0) {
          //To check if the user entry is actually apart of the list.
          for (int i = 0; i < products.length; i++) {
            //For loop to kind hte matching index to the user entry.
            if ((output - 1) == i) {
              //EG-> output = 1
              //output -1 = 0
              //cart[0] = products[0]; -> null = Iphone
              //amount[0] = amount[0] + quant -> null = null + (userEntry)
              //Lets say the user then enters 1 again.
              // output - 1 = 0
              //cart[0] = products[0]; -> Iphone = Iphone(nothing changes)
              //amount[0] = amount[0](which is what the user previously entered ) + new quant
              cart[i] = products[i];
              amount[i] = amount[i] + quant;
            }
          }
        } else {
          //If the output isn't between 0 and the length of products.
          // Its not on the menu
          System.out.println("Please select one of the options!");
          continue;
        }
      } catch (Exception e) {
        //If the Integer.parseInt(choice) fails, it means the user has typed in the name of a product
        String output =
          choice.substring(0, 1).toUpperCase() +
          choice.substring(1).toLowerCase(); //This is to UpperCase the first Char of choice.
        //This is formations the user entry so that its will always be capitalized.
        //So they don't have to worry about Typos
        if (list.contains(output)) {
          //This is the use  of the list.
          //Lists allows me to use .contains.
          int count = 0; // Act a a normal for loop.
          for (String entry : items) { //Entry is each individual Product names.
            //Can't use cart ArrayList because it contains objects reference.
            if (choice.equalsIgnoreCase(entry)) { //choice from outside the try and catch
              cart[count] = products[count]; //count is the index position
              amount[count] = amount[count] + quant; //Same for the try statement
              break;
            } else {
              count++; //If choice doesn't equal one entry then add one to count until choice does match
            }
          }
        } else {
          // Otherwise its not on the menu
          System.out.println("Please select one of the options!"); //This is if the choice isn't in List
          continue;
        }
      } //End of catch

      System.out.println(
        "Do you want to buy another item? Enter any key\n" +
        "To return the item enter 'Return'\n" +
        "To see the cart enter 'Show'\n" +
        "To finish shopping enter 'Finish'"
      ); //Ask the user to choose one of the options
      String again = input.next();
      if (again.equalsIgnoreCase("finish")) {
        giveReceipt("Receipt");
        // If the user enters finish then change shopping to false
        System.out.println("Thanks for shopping!");
        shopping = false;
      } else if (again.equalsIgnoreCase("Return")) {
        // Run return item
        returnItem();
      } else if (again.equalsIgnoreCase("show")) {
        // Show the cart
        giveReceipt("Cart");
      }
    }
  }
}
