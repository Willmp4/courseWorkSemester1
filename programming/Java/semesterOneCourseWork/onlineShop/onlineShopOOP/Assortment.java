package Java.semesterOneCourseWork.onlineShop.onlineShopOOP;

/*
Abstract Assortment class to define what the product object should have as attributes.

getName() to grab the name of user -> used for displaying name to user
getPrice() to grab the price of the object -> used for calculations to display the total cost of a product
getIndex() to grab the index of a price -> going to use ArrayList has a basket and index with corresponded with index in list 
setIndex() to set the index of a product
@author William Bruckmann
*/
public abstract class Assortment {

  // Abstract Class to list out the properties of the product class
  public abstract String getName();

  public abstract double getPrice();

  public abstract int getIndex();

  public abstract void setIndex(int index);

  public abstract void showFeatures();
}
