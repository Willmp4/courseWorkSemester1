package Java.semesterOneCourseWork.onlineShop.onlineShopOOP;

/**
 * This is a product object
 * It will have 3 attributes:
 * Name, Price, Index
 * Will be used to create different prodcuts
 * Will also be used to create a product ArrayList
 * 
 * @author William Bruckmann
 */
public class Product extends Assortment {
    // Creating a product class to be used as a date type for an array
    private String name;
    protected double price;
    private int index;

    public Product(String name, double price, int index) {
        this.name = name;
        this.price = price;
        this.index = index;
        // System.out.println("PRODUCT!!!");
        // A constuctore for the product class
    }

    @Override
    public String getName() {
        return name;
    }// Get name

    @Override
    public double getPrice() {
        return price;
    }// Get price

    @Override
    public int getIndex() {
        return index;
    }// Get Index number

    @Override
    public void setIndex(int index) {
        this.index = index;
    }// Set index

    @Override
    public void showFeatures() {
        System.out.println("Name of product: " + name + "\n" +
                "Price: " + price + "\n");// Show to features of a product
    }
}
