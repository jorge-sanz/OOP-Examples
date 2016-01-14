package exercise12;

import java.math.BigDecimal;

/**
 * TimeWorker is a class which represents a person who get paid per work hours.
 * <br>
 * It has defined a price per work hour and it has available data about the
 * amount of work hours in the last month.
 *
 * @author Jorge Sanz Perez
 */
public class TimeWorker extends Employee {
	private BigDecimal pricePerHour;
	private double workHoursInTheLastestMonth;
	
	/**
	 * Initializes a time worker with the specified values of name, age, id and
	 * price per hour.
	 * 
	 * @param name			time worker's name
	 * @param age			time worker's age
	 * @param id			time worker's id
	 * @param pricePerHour	time worker's price per hour
	 */
	public TimeWorker(String name, int age, String id, BigDecimal pricePerHour){
		super(name, age, id);
		this.pricePerHour = pricePerHour;
	}

	/**
	 * Returns the time worker's price per hour.
	 * 
	 * @return pricePerHour	the time worker's time per hour
	 */
	public BigDecimal getPricePerHour() {
		return pricePerHour;
	}

	/**
	 * Returns the work hours made in the lastest month.
	 * 
	 * @return workHoursInTheLastestMonth
	 */
	public double getWorkHoursInTheLastestMonth() {
		return workHoursInTheLastestMonth;
	}

	/**
	 * Sets the work hours made in the lastest month.
	 * 
	 * @param workHoursInTheLastestMonth
	 */
	public void setWorkHoursInTheLastestMonth(double workHoursInTheLastestMonth) {
		this.workHoursInTheLastestMonth = workHoursInTheLastestMonth;
	}
	
	/**
	 * Returns the salary of the month.
	 * 
	 * @return salary
	 */
	public BigDecimal getSalary() {
		return getPricePerHour()
				.multiply(new BigDecimal(getWorkHoursInTheLastestMonth()));
	}
}
