package Java.semesterOneCourseWork.bmiCalc;

import java.util.Scanner;

public class bmiSimpleTerminal {

    static void println(String string) {
        System.out.println(string);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        println("Choose which method you would like to calculate your BMI in: \nEither Pounds/Inches or KG/Meters");
        println("");
        println("Enter 1 for in pounds/inches or 2 for Kg/Meters");

        while (!sc.hasNextInt()) {
            sc.next();
            println("Please enter a vaild number");
        }

        while (true) {
            // Will ask the user to keep entering numbers until the input is a 1 or 2
            int UserInput;
            UserInput = sc.nextInt();
            if (UserInput == 1) {
                CalcBMImethodOne();
                break;
            } else if (2 == UserInput) {
                CalcBMImethodTwo();
                break;
            } else {
                println("Enter a 1 or 2");
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
        println("Your BMI is " + bmi + " and that means " + result);
    }

    private static void CalcBMImethodOne()
    // Methode to calc the BMI in imperial messurements
    {
        Scanner scanner = new Scanner(System.in); // This is how to get user input
        println("Type weight here: pounds");
        while (!scanner.hasNextFloat()) {
            scanner.next();
            println("Enter a proper digit");
        }
        float weight = scanner.nextFloat();
        // Taking the weight of the user
        // Making sure its a float data type

        println("Type height: Inches");
        while (!scanner.hasNextFloat()) {
            scanner.next();
            println("Enter a proper digit");
        }
        float height = scanner.nextFloat();
        // Taking the height of the user
        // Making sure its a float data type

        float bmi = (weight * 703) / (height * height);
        // This is the formula to calc bmi (pounds/inches)

        PrintBMIResult(bmi);
        // prints out the result
    }

    private static void CalcBMImethodTwo()
    // Methode to calc the BMI in metric system
    {
        Scanner scanner = new Scanner(System.in);
        // This is how to get user input
        println("Type weight here: Kilograms");
        while (!scanner.hasNextFloat()) {
            scanner.next();
            println("Enter a proper digit");
        }
        float weight = scanner.nextFloat();
        // Assining the user input to weight of the user

        println("Type height: Meters");
        while (!scanner.hasNextFloat()) {
            scanner.next();
            println("Enter a proper digit");
        }
        float height = scanner.nextFloat();
        // Assining the user input to weight of the user

        float bmi = weight / (height * height); // This is the formula to calc bmi (kg/meters)

        PrintBMIResult(bmi);
        // prints out the result
    }
}