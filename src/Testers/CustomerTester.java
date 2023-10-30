package Testers;

import Codes.*;
import java.time.*;
import java.util.*;

import java.time.LocalDate;
import java.util.Scanner;

public class CustomerTester {

	public static void main(String[] args) throws InputInvalidException{

		try (Scanner sc = new Scanner(System.in);) {
			List<Customer> customer = new ArrayList<>(); // size=0; initialcapacity = 10
			int choice;
			System.out.println("1. Sign up ( New User )\r\n" 
			                 + "2. Sign in (login)\r\n" 
				 			 + "3. Change password\r\n"
							 + "4. Unsubscribe customer  \r\n" 
							 + "5. Display all customers.\r\n"
							 + "6. Sort Data by Customer Email.\n"
							 + "7. Sort Data by Date of Birth\n"
							 + "8. Sort by Date Of Birth and last name \n"
							 + "9. Show All Customer Whose subscription is pending since 3 months\n"
							 + "10. Remove Customer Whose Subscription is pending since 6 months\n" 
							 + "11. Exit \r\n" + "");
			

			do {
				System.out.println("Enter your choice ");
				choice = sc.nextInt();

				try {

					
					switch (choice) {

					case 1: {
						//LocalDate d;
						System.out.println(
								"Enter Customer first name , last name , email , password , registeration Amount , Date of Birth( Year - Month - Day) \n Date Of Subscription and Service Plan - SILVER(1000), GOLD(2000), DIAMOND(5000), PLATINUM(10000)");
			             Customer c = CustomerValidation.ParseandValidate(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), LocalDate.parse(sc.next()),LocalDate.parse(sc.next()) , sc.next(), customer);
			  					customer.add(c);
			  			System.out.println("Customer Added Successfully..!!");
					}
						break;
					case 2: {
                               System.out.println("Enter Your email and Password ");
                               CustomerValidation.Check(sc.next(), sc.next(), customer);
					}
						break;
					case 3: {
						System.out.println("Enter your Email ID ");
						String mail = sc.next();
						
						CustomerValidation.CheckEmail(mail, customer);
						
						System.out.println("Enter Old password ");
						CustomerValidation.ValidatePassword(mail, sc.next(), customer);
						
						System.out.println("Enter new Password ");
						CustomerValidation.UpdatePassword(mail, sc.next(), customer);
						
						System.out.println("Password Update Successfully..!!");
					}
						break;
					case 4: {
						System.out.println("Enter the Customer Email-ID ");
			            CustomerValidation.Unsubscribe(sc.next(), customer);	
					}
						break;
					case 5: {
						      for(Customer c : customer) {
						    	  System.out.println(c);
						      }
					}
						break;
					case 6 :{
						     Collections.sort(customer);
					} 
					break;
					case 7 :{
						      Collections.sort(customer , new SortByDate() );
					}
					break;
					case 8 :{
						  Collections.sort(customer, new Comparator<Customer>()  {

							@Override
							public int compare(Customer o1, Customer o2) {
								int res = o1.getDate().compareTo(o2.getDate());
								if(res == 0 )
								{
									return o1.getLastname().compareTo(o2.getLastname()) ;
								
								}
								return res;
							}
							  
							  
						  } );
					} 
					break;
					case 9:{
						CustomerSubscriptionOps.DetectCustomer_ThreeMonthUnpaid(customer);
						
					}break;
					case 10:{
						CustomerSubscriptionOps.Remove_CustomerSixMonthUnpaid(customer);
					}break;
					case 11:
						break;
					default:
						System.out.println("Invalid Input..!!");
						break;

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			} while (choice != 11);
		}
	}
}