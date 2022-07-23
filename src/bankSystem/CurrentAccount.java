package bankSystem;

import java.util.Scanner;
/**
 * 
 * @author MSI
 *
 */
public class CurrentAccount extends Account {
	private double negativeAllowed;
	
	public CurrentAccount(){
		super(); 
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the allowed negative balance for the client: ");
		negativeAllowed = s.nextDouble();
	}
	public CurrentAccount(String firstName, String lastName, String dateOfBirth,
			String street, String city, String country, String postalCode, double limit){
		super(firstName, lastName, dateOfBirth, street, city, country, postalCode); 
		negativeAllowed = limit;
	}
	
	public double getNegativeAllowed() {
		return negativeAllowed;
	}
	public void setNegativeAllowed(double negativeAllowed) {
		this.negativeAllowed = negativeAllowed;
	}
	public void updateAccount() {
		super.updateAccount();
		System.out.println("Do you want to make changes on client's allowed negative balance? ");
		if(this.client.changeInfo()) {
			System.out.println("Enter the new client's allowed negative balance: ");
			Scanner sb = new Scanner(System.in);
			this.negativeAllowed = sb.nextDouble();
		}
	}
	
	public String toString() {
		String desc = super.toString(); 
		desc += "\nThe allowed negative balance: $" + negativeAllowed;
		double toWithdraw = balance + negativeAllowed;
		desc += "\n"+this.client.getFullName() +", you're not allowed to withdraw more than: $" + toWithdraw+".";
		return desc;
	}
	
	public void makeWithdrawal(double amount) {
		if(balance + negativeAllowed >= amount)
			balance -= amount;// super.setSolde(solde - s);
		else
			System.out.println("Insuffisant balance !");
			
	}
	
	public void makeWithdrawal() {
		Scanner sc = new Scanner(System.in);
		double amount = 0.0;
		System.out.println("Enter the amount of money to withdraw: ");
		amount = sc.nextDouble();
		if(balance + negativeAllowed < amount)
			System.out.println("Insuffisant balance !");
		else
			balance -= amount;
	}
	
	public void makeTransfer(Account other, double amount) {
		if(this.balance + this.negativeAllowed < amount)
			System.out.println("The client "+this.client.getFullName()
									+ "'s balance is insuffisant");
		else {
			balance -= amount;
			other.makeDeposit(amount);
			System.out.println("Successful bank transfer with an amount of $"+amount+ "from "+
					this.client.getFullName() + " to " + other.client.getFullName()+ ".");
			System.out.println(this);
			System.out.println(other);
		}
	}
		
}