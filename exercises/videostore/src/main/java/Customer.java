import java.util.*;

public class Customer {
	private String _name;
	private Vector _rentals =new Vector();

	public Customer(String name) {
		_name = name;
	}
	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}
	public String getName() {
		return _name;
	}

	public String statement() {
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + getName() +  "\n";

		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			//show figures for this rental
			result += "\t" + each.getMovie().getTitle()+ "\t" +
				String.valueOf(each.getCharge()) + "\n";
		}

		// add footer lines®
		result += "Amount owed is "+String.valueOf(getTotalCharge()) + "\n";
		result += "You earned "+String.valueOf(getTotalFrequentRenterPoints())
 					+ " frequent renter points\n";
		return result;
	}


	private double getTotalCharge(){
		double totalAmount = 0;
		Enumeration rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			totalAmount += each.getCharge();
		}
		return totalAmount;
	}

	private int getTotalFrequentRenterPoints(){
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			frequentRenterPoints += each.getFrequentRenterPoints();
		}
		return frequentRenterPoints;
	}

	public String htmlStatement() {
		Enumeration rentals = _rentals.elements();
		String result = "<H1>Rental Record for<EM> " +
				getName() +  "<EM></H1><P>\n";
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			//show figures for this rental
			result +=  each.getMovie().getTitle()+ ": " +
					String.valueOf(each.getCharge()) + "<BR>\n";
		}
		// add footer lines
		result += "<P>Amount owed is<EM> "+String.valueOf(getTotalCharge())
				+ "</EM><P>\n";
		result += "You earned <EM>"+String.valueOf(getTotalFrequentRenterPoints())+
				"</EM> frequent renter points<P>\n";
		return result;
	}
}
