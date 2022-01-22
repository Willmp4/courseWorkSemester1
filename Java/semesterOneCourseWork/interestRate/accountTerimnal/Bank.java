import Java.semesterOneCourseWork.interestRate.Account;
import java.util.*;

public class Bank {

  private ArrayList<Account> accounts;
  static Scanner input = new Scanner(System.in);

  public Bank(String bankName) {
    this.accounts = new ArrayList<Account>();
    System.out.println(bankName + "Is open for business!");
  } //Constructor for bank object

  private String inputFullName() {
    System.out.println("Please enter your full name!");
    input.skip("\\R?"); //Makes sure not to skip nextLine()
    String fullName = input.nextLine();
    return fullName;
  } //Method for setting the name

  private double inputBalance() {
    System.out.println("Please enter your intial balance: ");
    while (!input.hasNextFloat()) {
      input.next();
      System.out.println("Please enter only digits: ");
    }
    double balance = input.nextDouble();
    return balance;
  } //Method to set the balance

  public void run() {
    while (true) {
      //Uses the setters to ask the user for inputs.
      Account account = new Account();
      account.setFullName(inputFullName());
      account.setBalance(inputBalance());
      account.withdraw(2500);
      account.deposit(3000);
      account.setInterestRate(4.5);
      account.setID(1122);
      accounts.add(account); //Add account to accounts.

      System.out.println("Full Name \t Balance\tTime Created");
      for (int i = 0; i < accounts.size(); i++) { //Print all elements of accounts
        System.out.println(
          account.getID() +
          " " +
          accounts.get(i).getFullName() +
          " " +
          accounts.get(i).getBalance() +
          " " +
          accounts.get(i).getMonthlyInterestRate() +
          " " +
          accounts.get(i).getDate()
        );
        System.out.println();
      }
      System.out.println("Do you want to add a new account?");
      String again = input.next();

      if (again.startsWith("n")) { //Break while loop
        break;
      } else {
        continue;
      }
    }
  }
}
