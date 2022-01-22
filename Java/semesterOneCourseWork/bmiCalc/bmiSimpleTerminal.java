package Java.semesterOneCourseWork.bmiCalc;

import java.util.Scanner;

/**
 * This is a programme to calculate a BMI result for the user. The programme takes in two inputs(weight and height). And using
 * either the imperial system or the metric system and using the respective formulas.
 * @author William Bruckmann
 */

public class bmiSimpleTerminal {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println(
      "Choose which method you would like to calculate your BMI in: \nEither Pounds/Inches or KG/Meters"
    );
    System.out.println("");
    System.out.println("Enter 1 for in pounds/inches or 2 for Kg/Meters");

    while (true) {
      while (!sc.hasNextInt()) {
        sc.next();
        System.out.println("Please enter a vaild number");
      }
      int UserInput = sc.nextInt();
      // Will ask the user to keep entering numbers until the input is a 1 or 2
      if (UserInput == 1) {
        CalcBMImethodOne();
        break;
      } else if (2 == UserInput) {
        CalcBMImethodTwo();
        break;
      } else {
        System.out.println("Enter a 1 or 2");
      }
    }
  }

  private static void PrintBMIResult(float bmi) {
    String result;
    if (bmi < 18.5) {
      result = "you are underweight";
    } else if (bmi < 24.9) {
      result = "you are healthy";
    } else if (bmi < 30) {
      result = "you are overweight";
    } else {
      result = "you are obese";
    }
    // This if else logic is to tell weather or not the bmi is to high or to low
    System.out.println("Your BMI is " + bmi + " and that means " + result);
  }

  private static void CalcBMImethodOne() { // Methode to calc the BMI in imperial messurements
    Scanner scanner = new Scanner(System.in); // This is how to get user input
    System.out.println("Type weight here: pounds");
    while (!scanner.hasNextFloat()) {
      scanner.next();
      System.out.println("Enter a proper digit");
    }
    float weight = scanner.nextFloat();
    // Taking the weight of the user
    // Making sure its a float data type

    System.out.println("Type height: Inches");
    while (!scanner.hasNextFloat()) {
      scanner.next();
      System.out.println("Enter a proper digit");
    }
    float height = scanner.nextFloat();
    // Taking the height of the user
    // Making sure its a float data type

    float bmi = (weight * 703) / (height * height);
    // This is the formula to calc bmi (pounds/inches)

    PrintBMIResult(bmi);
    // prints out the result
  }

  private static void CalcBMImethodTwo() { // Methode to calc the BMI in metric system
    Scanner scanner = new Scanner(System.in);
    // This is how to get user input
    System.out.println("Type weight here: Kilograms");
    while (!scanner.hasNextFloat()) {
      scanner.next();
      System.out.println("Enter a proper digit");
    }
    float weight = scanner.nextFloat();
    // Assining the user input to weight of the userz

    System.out.println("Type height: Meters");
    while (!scanner.hasNextFloat()) {
      scanner.next();
      System.out.println("Enter a proper digit");
    }
    float height = scanner.nextFloat();
    // Assining the user input to weight of the user

    float bmi = weight / (height * height); // This is the formula to calc bmi (kg/meters)

    PrintBMIResult(bmi);
    // prints out the result
  }
}
