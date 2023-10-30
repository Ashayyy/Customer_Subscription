//state  : customer id(int) ,first name, last name (string),email(string),password(string),registrationAmount(double),dob(LocalDate),plan(ServicePlan : enum)
//Must generate customer ids automatically : auto increment)
//PK(UID) : email

package Codes;
import java.util.*;
import java.time.LocalDate;
import java.lang.Comparable;

public class Customer implements Comparable<Customer> {
	private int custid;
	static int idcounter;
	private String firstname, lastname, email, password;
	private double regamount;
	private LocalDate dob;
	private LocalDate subscriptionDate;
	private ServicePlan plan;

	static {
		idcounter = 100;
	}

	public Customer
	(String firstname, String lastname, String email, String password, double regamount,
			LocalDate dob, LocalDate subscriptionDate,ServicePlan plan) {
		this.custid = ++idcounter;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.regamount = regamount;
		this.dob = dob;
		this.plan = plan;
		this.subscriptionDate=subscriptionDate;
	}
	
	public LocalDate getLastTransactionDate() {
		return this.subscriptionDate;
	}
	
	public Customer(String email) {
		this.email=email;
	}

	@Override
	public String toString() {
		return "CustomerClass [custid=" + custid + ", idcounter=" + idcounter + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", password=" + password + ", regamount=" + regamount
				+ ", dob=" + dob + ", plan=" + plan + "]";
	}

	public int getId()
	{
		return this.custid;
	}
	public String getPlan()
	{
	  return this.getPlan();	
	}
	
	public boolean equals(Object obj) {

		if (this.email.equals(((Customer) obj).email))
			return true;

		return false;
	}
	
	public LocalDate getDate() {
		return this.dob;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password=password;
	}
	

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public int compareTo(Customer o) {
		// TODO Auto-generated method stub
		return this.getEmail().compareTo(  ((Customer)o).getEmail() );

	}

	
}
