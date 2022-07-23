package bankSystem;

import java.util.Scanner;
/**
 * 
 * @author MSI
 *
 */
public class Address {
	private String street;
	private String city;
	private String country;
	private String postalCode;
	
	public Address() {
		System.out.println("Enter the client's street name: ");
		Scanner sf = new Scanner(System.in);
		this.street = sf.next();
		System.out.println("Enter the client's city: ");
		Scanner sl = new Scanner(System.in);
		this.city = sl.next();
		System.out.println("Enter the client's country: ");
		Scanner sc = new Scanner(System.in);
		this.country = sc.next();
		System.out.println("Enter the client's postal code: ");
		Scanner sd = new Scanner(System.in);
		this.postalCode = sd.next();
	}

	public Address(String street, String city, String country, String postalCode) {
		this.street = street;
		this.city = city;
		this.postalCode = postalCode;
		this.country = country;
	}


	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "\nAddress: "+street+", " + city+", "+ postalCode +", " + country;
	}
	
}
