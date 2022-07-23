package bankSystem;

import java.util.Scanner;
/**
 * 
 * @author MSI
 *
 */
public class Account{
	private long id; 
	protected Client client;
	protected double balance;
	protected static int numberOfAccounts = 0;
	
	public Account() {
		this.id = numberOfAccounts ++;
		this.client = new Client();
		this.balance = 0;
	}
	
	public Account(String firstName, String lastName, String dateOfBirth,
				String street, String city, String country, String postalCode) {
		this.id = numberOfAccounts ++;
		this.client = new Client(firstName, lastName, dateOfBirth, street, city, country, postalCode);
		this.balance = 0;
	}

	public long getId() {
		return id;
	}
	public Client getClient() {
		return client;
	}
	public double getBalance() {
		return balance;
	}
	public static int getNumberOfAccounts() {
		return numberOfAccounts;
	}
	
	public String toString() {
		return "Account's ID: "+ this.id +"\nClient info: " + this.client.toString() 
				+ "\nAccount's balance: $" + this.balance;
	}
	public void makeDeposit(double amount) {
		balance += amount;
	}
	public void makeDeposit() {
		Scanner sc = new Scanner(System.in);
		double amount = 0.0;
		System.out.println("Enter the amount of money to deposit: ");
		amount = sc.nextDouble();
		balance += amount;
		}
	public void makeWithdrawal(double amount) {
		if(balance < amount)
			System.out.println("Insuffisant balance !");
		else
			balance -= amount;
	}
	public void makeWithdrawal() {
		Scanner sc = new Scanner(System.in);
		double amount = 0.0;
		System.out.println("Enter the amount of money to withdraw: ");
		amount = sc.nextDouble();
		if(balance < amount)
			System.out.println("Insuffisant balance !");
		else
			balance -= amount;
	}
	public void makeTransfer(Account other, double amount) {
		if(this.balance < amount)
			System.out.println("Insuffisant balance !");
		else {
			this.balance -= amount;
			other.makeDeposit(amount);
		}
	}
	public char menuOperations() {
		System.out.println("Operations on the account "+ this.id +" of the client "+ this.client.getFullName() + ": ");
		System.out.println("Choose 'c' to consult account's info.");
		System.out.println("Choose 'u' to update account's data.");
		System.out.println("Choose 'd' to make a deposit.");
		System.out.println("Choose 't' to make a bank tranfer from the client" + this.client.getFullName()+"'s account to another account.");
		System.out.println("Choose 'w' to make a withdrawal.");
		if (this instanceof SavingsAccount)
			System.out.println("Choose 'i' to make a deposit interests.");
		System.out.println("Choose 'q' to quit.");
		System.out.println("Your choice: ");
		Scanner sc = new Scanner(System.in);
		char choice = sc.next().charAt(0);
		return choice;
	}
	public void operations() {
		char choice = 'a';
		while (choice != 'q') {
			choice = menuOperations();
			switch(choice) {
			case 'c' :
				System.out.println(this);
				break;
			case 'd' :
				makeDeposit();
				System.out.println(this);
				break;
			case 'u' :
				updateAccount();
				break;
			case 'w' :
				makeWithdrawal();
				System.out.println(this);
				break;
			case 'i':
				makeInterestDeposit();
			case 't' :
				double amount;
				System.out.println("Please enter the amount of money to transfer: ");
				Scanner sm = new Scanner(System.in);
				amount = sm.nextDouble();
				Account other = null;
				System.out.println("Please specify the account's type the transfer is made to.");
				System.out.println("1 : Normal Account.\n2 : Current Account.\n3 : Savings Account.");
				Scanner sc = new Scanner(System.in);
				int type = sc.nextInt();
				switch(type) {
				case 1:
					other = new Account();
					break;
				case 2:
					other = new CurrentAccount();
					break;
				case 3:
					other = new SavingsAccount();
					break;
				}
				this.makeTransfer(other, amount);
				System.out.println(this);
				System.out.println(other);
			}
		}
	}
	public void updateAccount() {
		this.client.updateClient();
		System.out.println("Do you want to make changes on client's balance? ");
		if(this.client.changeInfo()) {
			System.out.println("Enter the new client's balance: ");
			Scanner sb = new Scanner(System.in);
			this.balance = sb.nextDouble();
		}
	}
	public void makeInterestDeposit(){} 
	public void makeInterestDeposit(double s){} 
	public double getNegativeAllowed() {
		return 0;
	}
	public void setNegativeAllowed(double s) {}

}