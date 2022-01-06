/** 
 * This is the logic for the shopping and would be classified as the controller in a moduel - view - controller design pattern
 * Using 3 arrays and a prodcut class I was able to simualte an online shop.
 * The product class has some attributes that are easily accessed by using the getters.
 * @author William Bruckmann
*/
package Java.semesterOneCourseWork.onlineShop.onlineShopOOP;

import java.util.*;

public class shopOnline {
	static private Product[] items = new Product[8];// Creats an array of pp spaces for the product type
	static private Product[] cart = new Product[items.length];// Creats an array of products length
	static private int[] amount = new int[items.length];// Creats an array to show the amount of items entered
	static private Scanner input = new Scanner(System.in);

	// Init different products using the constructor
	static Product iPhone = new Product("Iphone", 1200.00, 1);
	static Product Galaxy = new Product("Galaxy", 800.00, 2);
	static Product LG = new Product("Lg tv", 1000.00, 3);
	static Product RED = new Product("Red", 700.00, 4);
	static Product Tesla = new Product("Tesla", 69420.00, 5);
	static Product BMW = new Product("BMW", 30000.00, 6);
	static Product Dell = new Product("Dell", 400.00, 7);
	static Product Ball = new Product("Ball", 12.00, 8);

	static int total = 0;// Total

	static void menu() {
		// Shows the items from products to the user
		System.out.println("+==================================+");
		System.out.println("\t* Sundaland *");
		for (int i = 0; i < items.length; i++) {
			System.out.println(
					"+  " + items[i].getIndex() + "." + "\t" + items[i].getName() + "\t" + "£" + items[i].getPrice());
		}
		System.out.println("+==================================+");
	}

	public static void giveReceipt() {
		// Methode to print out the receipt
		System.out.println("Receipt");

		System.out.println("Your items: \n");
		for (int k = 0; k < items.length; k++) {
			if (cart[k] != null) {
				// Prints out some of the product attributes and the amount of products
				// Also prints out the total cost for each item
				System.out.println(
						cart[k].getName() + " [" + amount[k] + "] x " + (cart[k].getPrice() * amount[k]) + "£\n");
			}
		}
		System.out.println("Total cost is: " + getCost() + " $\n");
	}

	public static double getCost() {
		// Methode to get the total cose
		total = 0;
		for (int k = 0; k < items.length; k++) {
			if (cart[k] != null)
			// If the cart at the ith position isn't empty then
			// give the product of the price and using the amounth array get the quan
			{
				total += cart[k].getPrice() * amount[k];
			}
		}
		return total;
	}

	public static void showCart() {
		// Methode to show the basket.
		System.out.println("Your Items: ");
		for (int i = 0; i < items.length; i++) {
			if (cart[i] != null)
			// If there is an item at the ith index position then print out the attributes.
			{
				System.out.println(
						"\t" + cart[i].getIndex() + " (" + cart[i].getName() + ")" + "\t" + "(" + amount[i] + ")");
			}
		}
		System.out.println("Total \t" + getCost());// Prints out the total
	}

	static void returnItem() {
		// Methode to return an Item
		// uses a for loop to itarate and check if item matchs up with any item in the
		// cart
		showCart();// Shows cart to show what has been removed
		System.out.println("Enter the product ID you wish to return!");
		Scanner input2 = new Scanner(System.in);
		int item = input2.nextInt();
		if (amount[item - 1] > 0) {
			// To check if there is an item is that space
			for (int i = 0; i < items.length; i++) {
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

	static void shop() {
		items[0] = iPhone;
		items[1] = Galaxy;
		items[2] = LG;
		items[3] = RED;
		items[4] = Tesla;
		items[5] = BMW;
		items[6] = Dell;
		items[7] = Ball;
		// Adds all the items to a list
		boolean shopping = true;
		while (shopping) {
			menu();// Shows menu
			System.out.println("Enter the store ID of the item you want\n");

			while (!input.hasNextInt()) {
				System.out.println("Please enter a store ID");
				input.next();
			}
			int choice = input.nextInt();
			if (choice <= items.length && choice > 0) {
				for (int i = 0; i < items.length; i++) {
					if ((choice - 1) == i) {
						System.out.println("works");
						cart[i] = items[i];
						amount[i]++;
					}
				}
			} else {
				// Otherwise its not on the menu
				System.out.println("Please select one of the options!");
			}
			System.out.println("DO you want to buy another item? Enter any key\n" +
					"To return the item enter 'Return'\n" +
					"To see the cart enter 'Show'\n" +
					"To finish shopping enter 'Finish");
			String again = input.next();
			if (again.equalsIgnoreCase("finish")) {
				// If the user enters finish then change shopping to false
				System.out.println("Thanks for shopping!");
				shopping = false;
			} else if (again.equalsIgnoreCase("Return")) {
				// Run return item
				returnItem();
			} else if (again.equalsIgnoreCase("show")) {
				// Show the cart
				showCart();
			}

		}
	}
}