package Java.semesterOneCourseWork.intrestRate;

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
	}

	public Account() {
		this.nameID = 0;
		this.fullName = null;
		this.annualInterestRate = 0;
		this.balance = 0;
		this.dateCreated = LocalDateTime.now();
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getID() {
		return nameID;
	}

	public void setID(int nameID) {
		this.nameID = nameID;
	}

	public double getInterestRate() {
		return annualInterestRate;
	}

	public void setInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDateTime getDate() {
		return dateCreated;
	}

	public double calculateMonthlyInterest() {
		double monthlyInterestRate = annualInterestRate / 12;
		return this.balance * monthlyInterestRate;
	}

	public double addMonthlyInterest() {
		return this.balance + calculateMonthlyInterest();
	}

	public void withdraw(double withAmt) {
		this.balance -= withAmt;
	}

	public void deposit(double depAmt) {
		this.balance += depAmt;
	}

	public double getMonthlyInterestRate() {
		return annualInterestRate / 12;
	}
}