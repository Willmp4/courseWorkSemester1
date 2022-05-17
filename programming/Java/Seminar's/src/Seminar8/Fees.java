package Seminar8;

import java.util.Scanner;
public class Fees {
// One of many possible solutions...
 public static void main(String[] args) {
	 Scanner in = new Scanner(System.in);
	 System.out.println("Your univesrity fee is £9,000 and increases by 6% interest each year.");
	 System.out.print("Pleae enter your age: ");
	 int age = in.nextInt();

 double currentFee = 9000;
 double threeTimesFee = 3 * 9000;

 do
 {
 age++;
 currentFee = addInterest(currentFee);
 }
 while ( currentFee <= threeTimesFee);
 
 System.out.println("When you are " + age + " years old, your university fee with interest will have tripled to £27000.");
 }

 private static double addInterest(double fee){
 double newFee = fee * 1.06;
 return newFee;
 }
 }
