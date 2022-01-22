package Java.semesterOneCourseWork.onlineShop.onlineShopOOP;

/**
 * This is the main methods which init an instance of shopOnline and calls
 * shop() and giveReceipt()
 * Inside of the store, there are some products that you can add to your
 * shopping cart.
 * Can show the shopping cart.

 * They can discard an item.
 * When the user finish's it displays what they have bought and the total cost
 * shopping.
 *
 * @author William Bruckmann p
 */
public class Main {

  public static void main(String[] args) {
    Shop shop = new Shop();
    shop.run();
  }
}
