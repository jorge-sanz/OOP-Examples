package exercise12;

/**
 * Employee is a class which represent an employee of a company.
 *
 * @author Jorge Sanz Perez
 */
public class Employee {
	private String name;
	private int age; 
	private String id;
	
	/**
	 * Initializes an employee with the specified values of name, age and id.
	 * 
	 * @param name	employee name
	 * @param age	employee age
	 * @param id	employee id
	 */
	public Employee(String name, int age, String id) {
		this.name = name;
		this.age = age;
		this.id = id;
	}
	
	/**
	 * Returns the employee's name.
	 * 
	 * @return name	the employee's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the employee's name.
	 * 
	 * @param name	the employee's name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the employee's age.
	 * 
	 * @return age	the employee's age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the employee's age.
	 * 
	 * @param age the employee's age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Returns the employee's id.
	 * 
	 * @return id	the employee's id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the employee's id.
	 * 
	 * @param id the employee's id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Returns a string description of the employee.
	 * 
	 * @return description	string description of the employee
	 */
	@Override
	public String toString(){
		String description = "Employee " + getName() + ". Age: " + getAge()
				+ ". ID: " + getId() + ".";
		return description;
	}
}
