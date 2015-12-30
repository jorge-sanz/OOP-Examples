package exercise12;

import java.util.GregorianCalendar;
import java.math.BigDecimal;

/**
 * Freelancer is a class that inherits from Employee class and represents a 
 * freelance worker.
 *
 * @author Jorge Sanz Perez
 */
public class Freelancer extends Employee {
	private GregorianCalendar entranceDate;
	private GregorianCalendar departureDate;
	private BigDecimal salary;
	
	/**
	 * Initializes a freelancer with the specified values of name, age,
	 * id and entrance/departure dates data.
	 * 
	 * @param name				the freelancer's name
	 * @param age				the freelancer's age
	 * @param id				the freelancer's id
	 * @param salary			the freelancer's salary
	 * @param yearOfEntrance	the year that the freelancer joined the company
	 * @param monthOfEntrance	the month that the freelancer joined the company
	 * @param dayOfEntrance		the day that the freelancer joined the company
	 * @param yearOfDeparture	the year that the freelancer left the company
	 * @param monthOfDeparture	the month that the freelancer left the company
	 * @param dayOfDeparture	the day that the freelancer left the company
	 */
	public Freelancer(String name, int age, String id, BigDecimal salary,
			int yearOfEntrance,int monthOfEntrance, int dayOfEntrance,
			int yearOfDeparture, int monthOfDeparture, int dayOfDeparture) {
		super(name, age, id);
		this.salary = salary;
		this.entranceDate = new GregorianCalendar(yearOfEntrance, 
				monthOfEntrance, dayOfEntrance);
		this.departureDate = new GregorianCalendar(yearOfDeparture, 
				monthOfDeparture, dayOfDeparture);
	}

	/**
	 * Returns the date when the freelancer joined the company.
	 * 
	 * @return entraceDate	the date when the freelancer joined the company
	 */
	public GregorianCalendar getEntranceDate() {
		return entranceDate;
	}

	/**
	 * Sets the date when the freelancer joined the company.
	 * 
	 * @param entranceDate	the date when the freelancer joined the company to 
	 * 						set
	 */
	public void setEntranceDate(GregorianCalendar entranceDate) {
		this.entranceDate = entranceDate;
	}

	/**
	 * Returns the date when the freelancer left the company.
	 * 
	 * @return departureDate	the date when the freelancer left the company
	 */
	public GregorianCalendar getDepartureDate() {
		return departureDate;
	}

	/**
	 * Sets the date when the freelancer left the company.
	 * 
	 * @param departureDate the date when the freelancer left the company to set
	 */
	public void setDepartureDate(GregorianCalendar departureDate) {
		this.departureDate = departureDate;
	}
	
	/**
	 * Returns the freelancer's salary.
	 * 
	 * @return salary	the freelancer's salary
	 */
	
	
	/**
	 * Sets the freelancer's salary.
	 * 
	 * @param salary	the freelancer's salary to set
	 */
	
}
