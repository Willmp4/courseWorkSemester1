/**
 * This is the logic for the shopping and would be classified as the controller in a moduel - view - controller design pattern
 * Using 3 arrays and a prodcut class I was able to simualte an online shop.
 * The product class has some attributes that are easily accessed by using the getters.
 * @author William Bruckmann
 */
package Java.semesterOneCourseWork.onlineShop.onlineShopOOP;

import java.util.*;

public class Shop {

  private Product[] products = new Product[7]; // Creats an array of pp spaces for the product type
  private String[] items = new String[products.length];

  private Product[] cart = new Product[products.length]; // Creats an array of products length
  private int[] amount = new int[products.length]; // Creats an array to show the amount of items entered
  private static Scanner input = new Scanner(System.in);

  // Init different products using the constructor
  Product iPhone = new Product("Iphone", 1200.00, 1);
  Product Galaxy = new Product("Galaxy", 800.00, 2);
  Product LG = new Product("Lg tv", 1000.00, 3);
  Product RED = new Product("Red", 700.00, 4);
  Product Tesla = new Product("Tesla", 69420.00, 5);
  Product BMW = new Product("Bmw", 30000.00, 6);
  Product Dell = new Product("Dell", 400.00, 7);

  int total = 0; // Total

  private void menu() {
    // Shows the items from products to the user
    System.out.println("+==================================+");
    System.out.println("\t* Sundaland *");
    for (int i = 0; i < products.length; i++) {
      System.out.println(
        "+  " +
        products[i].getIndex() +
        "." +
        "\t" +
        products[i].getName() +
        "\t" +
        "£" +
        products[i].getPrice()
      );
    }
    System.out.println("+==================================+");
  }

  private void giveReceipt(String title) {
    // Methode to print out the receipt
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
          (cart[k].getPrice() * amount[k]) +
          "£\n"
        );
      }
    }
    System.out.println("Total cost is: £" + getTotal() + " \n");
  }

  /**
   *
   * @return
   */
  private double getTotal() {
    // Methode to get the total cose
    total = 0;
    for (int k = 0; k < products.length; k++) {
      if (cart[k] != null) { // give the product of the price and using the amounth array get the quan // If the cart at the ith position isn't empty then
        total += cart[k].getPrice() * amount[k];
      }
    }
    return total;
  }

  private void returnItem() {
    // Methode to return an Item
    // uses a for loop to itarate and check if item matchs up with any item in the
    // cart
    giveReceipt("Cart"); // Shows cart to show what has been removed
    System.out.println("Enter the product ID you wish to return!");
    System.out.println("You can only enter a intege: ");
    Scanner input2 = new Scanner(System.in);
    int item = input2.nextInt();
    if (amount[item - 1] > 0) {
      // To check if there is an item is that space
      for (int i = 0; i < products.length; i++) {
        // Go up to the lenght of items
        if (item == i) {
          // If item = i then take one away from that amount
          amount[i - 1]--;
          if (amount[i - 1] == 0) {
            // If amount == 0 then make cart[i] null
            cart[i - 1] = null;
          }
        }
      }
    } else {
      System.out.println("You do not have this item!!!");
    }
  }

  /**
   * This is the main Run methode, which uses all the methodes above to get the user to shop
   * Firstly I added the Product objects the Products object Array of prodcuts type, allowing me to use the getters and setters.
   *
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
    boolean shopping = true;
    while (shopping) {
      menu(); // Shows menu

      System.out.println("Enter the store ID or name of the item you want\n");
      input.skip("\\R?");
      //Found this online, stops the .nextLine() form being skipped.
      String choice = input.nextLine();

      System.out.println("Enter how many you would like: ");
      int quan = input.nextInt();
      try {
        //This try statment is try and convert the string the user entered into a Int
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
              //amount[0] = amount[0] + quan -> null = null + (userEntry)
              //Lets say the user then enters 1 again.
              // output - 1 = 0
              //cart[0] = products[0]; -> Iphone = Iphone(nothing changes)
              //amount[0] = amount[0](which is what the user previously entered ) + new quan
              cart[i] = products[i];
              amount[i] = amount[i] + quan;
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
        //This is formating the user entry so that its will awlays be capatilzed.
        //So they don't have to worry about Typos
        if (list.contains(output)) {
          //This is the implamentation of the list.
          //Lists allows me to use .contains.
          int count = 0;
          for (String entry : items) {
            if (choice.equalsIgnoreCase(entry)) {
              cart[count] = products[count];
              amount[count] = amount[count] + quan;
              break;
            } else {
              count++;
            }
          }
        } else {
          // Otherwise its not on the menu
          System.out.println("Please select one of the options!");
          continue;
        }
      }

      System.out.println(
        "Do you want to buy another item? Enter any key\n" +
        "To return the item enter 'Return'\n" +
        "To see the cart enter 'Show'\n" +
        "To finish shopping enter 'Finish'"
      );
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
