package Java.semesterOneCourseWork.interestRate;

import java.time.LocalDateTime;

public class Account {

  private int nameID = 0;
  private String fullName;
  private double balance = 0;
  private double annualInterestRate = 0;
  private LocalDateTime dateCreated;

  public Account(int nameID, double balance, String fullName) {
    this.fullName = fullName;
    this.nameID = nameID;
    this.balance = balance;
  } //This is the constructor

  public Account() {
    this.nameID = 0;
    this.fullName = null;
    this.annualInterestRate = 0;
    this.balance = 0;
    this.dateCreated = LocalDateTime.now();
  } //This is the default Account() constructor

  public String getFullName() {
    return fullName;
  } //Return name

  public void setFullName(String fullName) {
    this.fullName = fullName;
  } //Set name

  public int getID() {
    return nameID;
  } //Return NameId

  public void setID(int nameID) {
    this.nameID = nameID;
  } //Set ID

  public double getInterestRate() {
    return annualInterestRate;
  } //Return the annual Interest rate

  public void setInterestRate(double annualInterestRate) {
    this.annualInterestRate = annualInterestRate;
  } //Set the annual interest rate

  public double getBalance() {
    return balance;
  } //Return balance

  public void setBalance(double balance) {
    this.balance = balance;
  } //Set balance

  public LocalDateTime getDate() {
    return dateCreated;
  } //return type date

  public double calculateMonthlyInterest() {
    double monthlyInterestRate = annualInterestRate / 12;
    return this.balance * monthlyInterestRate;
  } //Return the monthly interest rate

  public void withdraw(double withAmt) {
    this.balance -= withAmt;
  } //Take away some amount from balance

  public void deposit(double depAmt) {
    this.balance += depAmt;
  } // add some amount to balance

  public double getMonthlyInterestRate() {
    return annualInterestRate / 12;
  } //Return monthly interest rate
}
