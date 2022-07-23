package bankSystem;

import java.util.Scanner;
/**
 * 
 * @author MSI
 *
 */
public class SavingsAccount extends Account {
	private static double interestRate = 0.01;
	
	
	public SavingsAccount(){
		super(); 
	}
	public SavingsAccount(String firstName, String lastName, String dateOfBirth,
			String street, String city, String country, String postalCode){
		super(firstName, lastName, dateOfBirth, street, city, country, postalCode); 
	}
	public void makeInterestDeposit() {
		this.balance += this.balance*interestRate;
	}
	public void makeInterestDeposit(double amount) {
		this.balance += amount;
		this.balance += this.balance * interestRate;
	}
	
    public static double getInterestRate(){
        return interestRate;
    }

    public static void setInterestRate(){
        System.out.println("The new interests rate: ");
         Scanner sc = new Scanner(System.in);
         double t=sc.nextDouble();
         interestRate=t;
    }
	public String toString() {
		String desc = super.toString(); 
		return desc;
	}
}