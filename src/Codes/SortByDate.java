package Codes;
import java.util.ArrayList;
import java.util.Comparator;
public class SortByDate implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {
		
		return (o1.getDate().compareTo(o2.getDate())) ;
	}

	
	

}
