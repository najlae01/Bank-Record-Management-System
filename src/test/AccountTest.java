package test;

import bankSystem.Account;
import bankSystem.CurrentAccount;
import bankSystem.SavingsAccount;

public class AccountTest {

	public static int passed = 0;
	public static int tested = 0;

	public static void main(String[] args) {
		//--------------------
		Account account1 = new Account("James", "Ken", "23/05/1990", "110 W 3rd St", "New York", "USA", 
				"NY 10012");
		Account account2  = new CurrentAccount("Sarah", "Williams", "01/03/1995", "44 W 4th St", "New York", "USA", 
				"NY 10004", 1000);
		Account account3  = new SavingsAccount("Keven", "White", "20/08/2000", "310 3rd Ave", "New York", "USA", 
				"NY 10010");
		
		// ********** Normal Account test
		test(1,"Normal Account", account1.getClient().getFullName().equals("James Ken") 
				&& account1.getClient().getDateOfBirth().equals("23/05/1990")
				&& account1.getClient().getAddress().toString().equals("\nAddress: 110 W 3rd St, New York, NY 10012, USA")
				&& account1.getBalance() == 0);
		
		// ********** Current Account test
		test(2,"Current Account", account2.getClient().getFullName().equals("Sarah Williams") 
				&& account2.getClient().getDateOfBirth().equals("01/03/1995")
				&& account2.getClient().getAddress().toString().equals("\nAddress: 44 W 4th St, New York, NY 10004, USA")
				&& account2.getBalance() == 0
				&& account2.getNegativeAllowed() == 1000);
		
		// ********** Savings Account test
		test(3,"Savings Account", account3.getClient().getFullName().equals("Keven White") 
				&& account3.getClient().getDateOfBirth().equals("20/08/2000")
				&& account3.getClient().getAddress().toString().equals("\nAddress: 310 3rd Ave, New York, NY 10010, USA")
				&& account3.getBalance() == 0);
		
		account1.makeDeposit(2000);
		account2.makeDeposit(1500);
		account3.makeDeposit(1000);

		// ********** makeDeposit methods tests
		test(4,"Make Deposit for a Normal Account", account1.getBalance() == 2000);
		test(5,"Make Deposit for a Current Account", account2.getBalance() == 1500);
		test(6,"Make Deposit for a Savings Account", account3.getBalance() == 1000);
		
		account1.makeWithdrawal(500);
		account2.makeWithdrawal(2000);
		account3.makeWithdrawal(400);
		
		// ********** makeWithdrawal methods tests
		test(7,"Make Withdrawal for a Normal Account", account1.getBalance() == 1500);
		test(8,"Make Withdrawal for a Current Account", account2.getBalance() == -500);
		test(9,"Make Withdrawal for a Savings Account", account3.getBalance() == 600);
		
		
		account1.makeTransfer(account2, 500);
		
		// ********** makeTransfer method test
		test(10,"Make Transfer", account1.getBalance() == 1000 && account2.getBalance() == 0);
		
		account3.makeInterestDeposit(1000);
		
		// ********** SavingAccount makeInterestDeposit method test
		test(11,"Make Interest Deposit", account3.getBalance() == 1616 );
		
		//--------------------
		System.out.println(passed+ " passed tests.");
	}

	public static void test(int testNumber, String message, boolean testStatus) {
		tested++;
		System.out.println("Test " + testNumber + " (" + message + ") " + (testStatus ? "passed" : "failed"));
		if (testStatus)
			passed++;
	}
}
