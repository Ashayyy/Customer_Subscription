package Codes;
import java.util.*;
import java.time.Period;
import java.time.*;
public class CustomerSubscriptionOps {

	public static void DetectCustomer_ThreeMonthUnpaid(List<Customer> list){
		
		for(Customer c : list) {
		  long months = Period.between(c.getLastTransactionDate(), LocalDate.now()).toTotalMonths();
		  if(months>=3)
		  {
			  System.out.println(c);
		  }
		}
		
	}
	
	public static void Remove_CustomerSixMonthUnpaid(List<Customer> list)
	{
		Boolean status = false;
		for(Customer c : list)
		{
			long months = Period.between(c.getLastTransactionDate(), LocalDate.now()).toTotalMonths();
			if(months>=6)
			{
				status = true;
				list.remove(c);
			}
		}
		if(status)
			System.out.println("Customer removed Successfully..!!");
		else
			System.out.println("No Customer is Unpaid for 6 month.");
	}
	
}
