//4. validation rules
//4.1 no dup customers 
//(i.e if the customer tries to register using existing email , throw exception)
//
//4.2 Validate plan
//plan must be of supported types
//4.3 reg amount must match with the plan

package Codes;

import java.time.LocalDate;
import java.util.*;

public class CustomerValidation {

	public static ServicePlan Plan(String plan)  {

		return ServicePlan.valueOf(plan.toUpperCase());
	}

	// --------------------------------------------------------------------------------------------------------

	public static boolean Validateamount(String plan, double regamount) throws InputInvalidException {

		if (ServicePlan.valueOf(plan.toUpperCase()).getPlan() != regamount)
			throw new InputInvalidException("Amount does not valid for plan..!!");

		return true;

	}
	
	
	//------------------------------------------------------------------------------------------------------------
	
	
	public static void UpdatePassword(String mail , String newpassword ,List<Customer> list)
	{
		for(Customer i : list)
		{
			if( i.getEmail().equals(mail) )
			{
				i.setPassword(newpassword);
			}
		}
	}

	//------------------------------------------------------------------------------------------------------------
	
	public static void CheckEmail(String email, List<Customer> customer) throws InputInvalidException{
		Customer c = new Customer(email);
		if( ! customer.contains(c) )
		{
			throw new InputInvalidException("Email ID doesn't Exists..!!");
		}
	}
	
	
	// ------------------------------------------------------------------------------------------------------------

	public static void ValidateEmail(String email, List<Customer> customer) throws InputInvalidException {
		Customer c = new Customer(email);

		if(!email.matches("[a-z]+[a-z0-9]+@[a-z]*\\.(com|org|net)"))
			throw new InputInvalidException("Invalid Email form..!! Email must contain 'AlphabeticContent@Type.com/org/net'.");
		
		if (customer.contains(c))
			throw new InputInvalidException("Email Already Exists..!!");
	}

	// ------------------------------------------------------------------------------------------------------------

	public static void ValidatePassword(String email, String password, List<Customer> customer)
			throws InputInvalidException {

		Customer c = new Customer(email);
		c = customer.get(customer.indexOf(c));
		if (!c.getPassword().equals(password)) {
			throw new InputInvalidException("Entered Password is Incorrect..!!");
		}

	}

	// ------------------------------------------------------------------------------------------------------------

	public static Customer ParseandValidate(String firstname, String lastname, String email, String password,
			double regamount, LocalDate dob, LocalDate dateOfSubscription ,String plan, List<Customer> customer) throws InputInvalidException {

		ServicePlan p = CustomerValidation.Plan(plan.toUpperCase());
		CustomerValidation.Validateamount(plan, regamount);
		CustomerValidation.ValidateEmail(email, customer);

		return new Customer(firstname, lastname, email, password, regamount, dob, dateOfSubscription,p);
	}

	// ------------------------------------------------------------------------------------------------------------

	public static void Check(String mail, String password, List<Customer> customer) throws InputInvalidException {

		Customer c = new Customer(mail);
		int index = customer.indexOf(c);
		
		if(index!=-1)
		{
			
			if( customer.get(index).getPassword().equals(password) )
				System.out.println("Welcome back , You Logged in Successfully..!!");
			
			else
				throw new InputInvalidException(" Invalid Password , Please Try Again..!! ");
		}
		
		else
		{
			throw new InputInvalidException(" Invalid Email ID..!! ");
		}
		
	}

	// ------------------------------------------------------------------------------------------------------------

	public static void Unsubscribe(String email, List<Customer> customer) {

		Customer c = new Customer(email);

		if (customer.contains(c)) {
			customer.remove(c);
			System.out.println("Customer Unsubscribed Successfully..!!");
		} else {
			System.out.println("Entered email does not Exists..!!");
		}

	}
}
