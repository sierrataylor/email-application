package emailapp;

import java.util.Random;
import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int defaultPasswordLength = 10;
	private String department;
	private final String COMPANY_SUFFIX = "company.com";
	private String alternateEmail;
	private int mailboxCapacity =500;
	
	//Constructor for first and last name
	public Email(String first, String last) {
		this.firstName = first;
		this.lastName = last;
		
		//Call a method asking for the department which will return the department
		this.department = setDepartment();

		//Call method that sets a random password
		this.password = randomPassword(defaultPasswordLength);
		
		//Combine elements to generate
		this.email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"
		+department+"_"+COMPANY_SUFFIX;
	}
	//ask for department

	private String setDepartment() {
		System.out.println("EMPLOYEE NAME: "+ firstName+" "+lastName +"\nDepartment Codes:"
				+ "\n1 for Sales"
				+ "\n2 for Development"
				+ "\n3 for Accounting \n0 for none"
				+ "\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int deptChoice = in.nextInt();
		switch(deptChoice) { 
			case 1 : 
				return "sales";
			case 2 : 
				return "dev";
			case 3 : 
				return "acct";
			default :
				return "";
		}
	}
	
	//generate random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz!@#$%";
		char[] password = new char[length];
		for(int i=0; i<length;i++) {
			int rand = (int)(Math.random()*passwordSet.length());

			/*(int) Math.random * passwordSet.length()*/
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password); 
	}
	
	//set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity; 
		//encapsulation: making public so we can set, but hiding the actual properties
	}
	
	//set alternate email
	public void setAlternateEmail(String altEmail) {
		if(altEmail.contains("@")&&(altEmail.contains(".com")||
				altEmail.contains(".net")||altEmail.contains(".edu"))) {
			this.alternateEmail = altEmail;
		}else {
			System.out.println("INVALID EMAIL");
		}
	}
	
	//change password
	public void changePassword(String password) {
		this.password = password;
	}
	
	//getters
	public String getAlternateEmail() {return alternateEmail;}

	public int getMailboxCapacity() {return mailboxCapacity;}
	
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "DISPLAY NAME: "+firstName+" "+lastName+
				"\nCOMPANY EMAIL: "+email+
				"\nMAILBOX CAPACITY: "+mailboxCapacity + "mb";
	}
}