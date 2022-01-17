import Java.semesterOneCourseWork.interestRate.Account;
import java.util.*;

public class bank {

  private ArrayList<Account> accounts;
  static Scanner input = new Scanner(System.in);

  public bank(String bankName) {
    this.accounts = new ArrayList<Account>();
    System.out.println(bankName + "Is open for business!");
  }

  private String inputFullName() {
    System.out.println("Please enter your full name!");
    input.skip("\\R?");
    String fullName = input.nextLine();
    return fullName;
  }

  private double inputBalance() {
    System.out.println("Please enter your intial balance: ");
    while (!input.hasNextFloat()) {
      input.next();
      System.out.println("Please enter only digits: ");
    }
    double balance = input.nextDouble();
    return balance;
  }

  public void run() {
    while (true) {
      Account account = new Account();
      account.setFullName(inputFullName());
      account.setBalance(inputBalance());
      account.setInterestRate(4.5);
      accounts.add(account);

      System.out.println("Full Name \t Balance\tTime Created");
      for (int i = 0; i < accounts.size(); i++) {
        System.out.println(
          accounts.get(i).getFullName() +
          " " +
          accounts.get(i).getBalance() +
          " " +
          accounts.get(i).getDate()
        );
        System.out.println();
      }
      System.out.println("Do you want to add a new account?");
      String again = input.next();

      if (again.startsWith("n")) {
        break;
      } else {
        continue;
      }
    }
  }
}
