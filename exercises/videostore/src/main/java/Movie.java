public class Movie {
	public static final int CHILDRENS=2;
	public static final int REGULAR=0;
	public static final int NEW_RELEASE=1;

	private String _title;
	private Price _priceCode;

	public Movie(String title, int priceCode) {
		_title=title;
		setPriceCode(priceCode);
	}
	public int getPriceCode() {
		return _priceCode.getPriceCode();
	}
	public void setPriceCode(int arg) {
		switch (arg){
			case Movie.CHILDRENS:
				_priceCode = new ChildrenPrice();
				break;
			case Movie.NEW_RELEASE:
				_priceCode = new NewReleasePrice();
				break;
			case Movie.REGULAR:
				_priceCode = new RegularPrice();
				break;
			default:
				throw new IllegalArgumentException("Incorrect Price Code");
		}
	}
	public String getTitle() {
		return _title;
	}

	public double getCharge(int daysRented) {
		return _priceCode.getCharge(daysRented);
	}

	public int getFrequentRenterPoints(int daysRented) {
		return _priceCode.getFrequentRenterPoints(daysRented);
	}
}


abstract class Price {
	protected int frequentRenterPoints = 1;
	abstract int getPriceCode();
	abstract double getCharge(int daysRented);

	public int getFrequentRenterPoints(int daysRented) {
		return frequentRenterPoints;
	}
}

class ChildrenPrice extends Price{

	@Override
	int getPriceCode() {
		return Movie.CHILDRENS;
	}

	@Override
	double getCharge(int daysRented) {
		double result = 1.5;
		if (daysRented > 3)
			result +=(daysRented-3) * 1.5;
		return result;
	}
}

class NewReleasePrice extends Price{

	@Override
	int getPriceCode() {
		return Movie.NEW_RELEASE;
	}

	@Override
	double getCharge(int daysRented) {
		return daysRented * 3;
	}

	@Override
	public int getFrequentRenterPoints(int daysRented) {
		if(daysRented > 1){
			return frequentRenterPoints+1;
		}
		return frequentRenterPoints;
	}
}

class RegularPrice extends Price{

	@Override
	int getPriceCode() {
		return Movie.REGULAR;
	}

	@Override
	double getCharge(int daysRented) {
		double result = 2;
		if (daysRented > 2)
			result +=(daysRented-2) * 1.5;
		return result;
	}
}