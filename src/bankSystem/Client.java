package bankSystem;

import java.util.Scanner;
/**
 * 
 * @author MSI
 *
 */
public class Client {
	private long id;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private Address address;
	private static int numberOfclients = 0;
	
	public Client(String firstName, String lastName, String dateOfBirth,
									String street, String city, String country, String postalCode) {
		this.id = numberOfclients++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.address = new Address(street, city, country, postalCode);
	}
	
	public Client() {
		this.id = numberOfclients++;
		System.out.println("Enter the client's first name: ");
		Scanner sf = new Scanner(System.in);
		this.firstName = sf.next();
		System.out.println("Enter the client's last name: ");
		Scanner sl = new Scanner(System.in);
		this.lastName = sl.next();
		System.out.println("Enter the client's date of birth: ");
		Scanner sd = new Scanner(System.in);
		this.dateOfBirth = sd.next();
		this.address = new Address();
	}
	
	public void updateClient() {
		System.out.println("Do you want to change client's first name? ");
		if(changeInfo()) {
			System.out.println("Enter the new client's first name: ");
			Scanner sf = new Scanner(System.in);
			this.firstName = sf.next();
		}
		System.out.println("Do you want to change client's last name? ");
		if(changeInfo()) {
			System.out.println("Enter the new client's last name: ");
			Scanner sl = new Scanner(System.in);
			this.lastName = sl.next();
		}
		System.out.println("Do you want to change client's date of birth? ");
		if(changeInfo()) {
			System.out.println("Enter the new client's date of birth: ");
			Scanner sd = new Scanner(System.in);
			this.dateOfBirth = sd.next();
		}
		System.out.println("Do you want to change client's street name? ");
		if(changeInfo()) {
			System.out.println("Enter the new client's street name: ");
			Scanner ss = new Scanner(System.in);
			this.address.setStreet(ss.next());
		}
		System.out.println("Do you want to change client's city? ");
		if(changeInfo()) {
			System.out.println("Enter the new client's city: ");
			Scanner sc = new Scanner(System.in);
			this.address.setCity(sc.next());
		}
		System.out.println("Do you want to change client's country? ");
		if(changeInfo()) {
			System.out.println("Enter the new client's country: ");
			Scanner sy = new Scanner(System.in);
			this.address.setCountry(sy.next());
		}
		System.out.println("Do you want to change client's postal code? ");
		if(changeInfo()) {
			System.out.println("Enter the new client's postal code: ");
			Scanner sp = new Scanner(System.in);
			this.address.setPostalCode(sp.next());
		}
	}
	
	public boolean changeInfo() {
		Scanner sc = new Scanner(System.in);
		String change = sc.next();
		if(change.equals("y") || change.equals("yes") 
				|| change.equals("Y") || change.equals("Yes") || change.equals("YES"))
			return true;
		else
			return false;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return firstName +" "+ lastName;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "\nID: "+ this.id + "\nFirst name: "+ this.firstName+"\nLast name: " + this.lastName + "\nDate of birth: " + this.dateOfBirth
				+ this.address.toString();
	}
	
}
