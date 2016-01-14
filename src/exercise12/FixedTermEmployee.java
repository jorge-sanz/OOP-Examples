package exercise12;

import java.math.BigDecimal;
import java.time.Year;

/**
 * FixedTermEmployee is a class that inherits from Employee and represents
 * a fixed-term employee.
 *
 * @author Jorge Sanz Perez
 */
public class FixedTermEmployee extends Employee {
	private int entranceYear;
	private BigDecimal salary;
	private BigDecimal extraSalary;
	
	/**
	 * Initializes a fixed-term employee with the specified values of name, age,
	 * id, salary, extra salary and entrance year.
	 * 
	 * @param name			the fixed-term employee's name
	 * @param age			the fixed-term employee's age
	 * @param id			the fixed-term employee's id
	 * @param salary		the fixed-term employee's salary
	 * @param extraSalary	the fixed-term employee's extraSalary
	 * @param entranceYear	the entrance year to the company 
	 */
	public FixedTermEmployee(String name, int age, String id,
			BigDecimal salary, BigDecimal extraSalary, int entranceYear) {
		super(name, age, id);
		this.salary = salary;
		this.extraSalary = extraSalary;
		this.entranceYear = entranceYear;
	}
	
	/**
	 * Returns his entrance year to the company.
	 * 
	 * @return entranceYear	the entrance year to the company
	 */
	public int getEntranceYear() {
		return entranceYear;
	}
	
	/**
	 * Returns his extra salary.
	 * 
	 * @return extraSalary	fixed-term employee's extra salary
	 */
	public BigDecimal getExtraSalary() {
		return extraSalary;
	}
	
	/**
	 * Sets his extra salary.
	 * 
	 * @param extraSalary	fixed-term employee's extra salary to be set
	 */
	public void setExtraSalary(BigDecimal extraSalary) {
		this.extraSalary = extraSalary;
	}
	
	/**
	 * Returns his salary.
	 * 
	 * @return salary	fixed-term employee's salary
	 */
	public BigDecimal getSalary() {
		return salary;
	}
	
	/**
	 * Sets his salary.
	 * 
	 * @param salary	fixed-term employee's salary to set
	 */
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	
	/**
	 * Returns number of years working at the company.
	 * 
	 * @return yearsAtCompany	number of years working at the company
	 */
	public int getYearsAtCompany() {
		return Year.now().getValue() - getEntranceYear();
	}
	
	/**
	 * Returns his annual salary.
	 * 
	 * @return annualSalary	annual salary
	 */
	public BigDecimal getAnnualSalary() {
		return getSalary()
				.multiply(new BigDecimal(12.00))
				.add(getExtraSalary()
						.multiply(new BigDecimal(
								(double) getYearsAtCompany())));
	}
}
