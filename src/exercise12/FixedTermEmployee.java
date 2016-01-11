package exercise12;

/**
 * FixedTermEmployee is a class that inherits from Employee and represents
 * a fixed-term employee.
 *
 * @author Jorge Sanz Perez
 */
public class FixedTermEmployee extends Employee {
	private int entranceYear;
	
	/**
	 * Initializes a fixed-term employee with the specified values of name, age,
	 * id and entrance year.
	 * 
	 * @param name			the fixed-term employee's name
	 * @param age			the fixed-term employee's age
	 * @param id			the fixed-term employee's id
	 * @param salary		the fixed-term employee's salary
	 * @param extra			the fixed-term employee's extra
	 * @param entranceYear	the entrance year to the company 
	 */
	public FixedTermEmployee(String name, int age, String id,
			int entranceYear) {
		super(name, age, id);
		this.entranceYear = entranceYear;
	}
}
