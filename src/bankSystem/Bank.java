package bankSystem;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author MSI
 *
 */
public class Bank {
	private ArrayList<Account> accounts;
	private static int numberOfAcc = 0;
	
	public Bank() {
		accounts = new ArrayList<Account>();
	}
	public void createAccount() {
			Account account = null;
			System.out.println("Choose the type of bank account to create.");
			System.out.println("1 : Normal Account.\n2 : Current Account.\n3 : Savings Account.");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				account = new Account();
				break;
			case 2:
				account = new CurrentAccount();
				break;
			case 3:
				account = new SavingsAccount();
				break;
			}
			numberOfAcc++;
			accounts.add(account);
		}
	public void deleteAccount() {
		if(!isEmpty()) {
			System.out.println("Please Determine the account to delete.");
			Account deleteAccount = search();
			if(deleteAccount != null){
				accounts.remove(deleteAccount);
				numberOfAcc--;
			}else
				System.out.println("This account doesn't exist.");
		}
		else {
			System.out.println("The list of the bank's accounts is empty.");
		}
	}
	public String toString() {
		String desc  = "Available accounts: "+ this.numberOfAcc +"\n";
		StringBuilder builder = new StringBuilder();
		builder.append(desc);
		for (Account account : accounts) {
			builder.append("\nThe account "+account.getId()+":\n");
			builder.append(account.toString());
			builder.append("\n\n");
		}	
		String result = builder.toString();
		return result;
	}
	public char bankMenu() {
		System.out.println("Bank Options: ");
		System.out.println("Choose 'l' to list available accounts.");
		System.out.println("Choose 'a' to add an account.");
		System.out.println("Choose 'd' to delete an account.");
		System.out.println("Choose 't' to make a transfer from an account to another.");
		System.out.println("Choose 'o' to execute an operation on choosen account.");
		System.out.println("Choose 'q' to Quit.");
		System.out.println("Your Choice: ");
		Scanner sc = new Scanner(System.in);
		char choice = sc.next().charAt(0);
		return choice;
	}
	public void bankOperations() {
		char choice = 'a';
		while (choice != 'q') {
			choice = bankMenu();
			switch(choice) {
			case 'l' :
				System.out.println(this);
				break;
			case 'a' :
				createAccount();
				break;
			case 'd' :
				deleteAccount();
				break;
			case 't' :
				if(!isEmpty()) {
					double amount;
					System.out.println("Please enter the amount of money to transfer: ");
					Scanner sm = new Scanner(System.in);
					amount = sm.nextDouble();
					System.out.println("Choose the first account that's initializing the operation: ");
					Account firstAccount = search();
						if(firstAccount == null)
							System.out.println("This account doesn't exist.");
						else {	
							System.out.println("Choose the second account that's receiving the transfer: ");
							Account secondAccount = search();
								if(secondAccount == null)
									System.out.println("This account doesn't exist.");
								else
									firstAccount.makeTransfer(secondAccount, amount);
						}
				}
				else 
						System.out.println("The list of the bank's accounts is empty.");
				break;
			case 'o' :
				if(!isEmpty()) {
					Account account = search();
					if(account == null)
						System.out.println("This account doesn't exist.");
					else
						account.operations();
				}
				else 
						System.out.println("The list of the bank's accounts is empty.");
				break;
			}
		}
	}
	public Account search() {
		if(!isEmpty()) {
			System.out.println("Search by:\n1.Name\n2.Account's id\nEnter the number corresponding to your choice: ");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			Account resultAccount = null;
			if (choice == 1) {
				System.out.println("Enter the client's first name: ");
				Scanner scan = new Scanner(System.in);
				String firstName = scan.next();
				System.out.println("Enter the client's last name: ");
				Scanner scn = new Scanner(System.in);
				String lastName = scn.next();
				for(Account account : accounts)
				if(account.client.getFirstName().equals(firstName) && account.client.getLastName().equals(lastName))
					resultAccount = account;				
			}else if(choice == 2) {
				System.out.println("Entrer the account's id: ");
				Scanner scan = new Scanner(System.in);
				int number = scan.nextInt();
				if(number < 0 || number > accounts.size())
					resultAccount = null;
				else {
					for(Account account : accounts) {
						if(account.getId() == number)
							resultAccount = account;
					}
				}
			}else
				System.out.println("Please, choose an available choice.");
			return resultAccount;
		}
		else {
			System.out.println("The list of the bank's accounts is empty.");
			return null;
		}
	}
	
	public boolean isEmpty() {
		return numberOfAcc == 0;
	}
	
}

