package exercise7;

/**
 * Date is a class which represents a date from the Gregorian Calendar.
 * <br>
 * It contains methods to get the values of the date, a string representation
 * of the date and a method to updates the date by one day.
 *
 * @author Jorge Sanz Perez
 */
public class Date {
	private static final int[] LONGEST_MONTHS = {1, 3, 5, 7, 8, 10, 12};
	private static final String[] MONTHS = {"enero", "febrero", "marzo", 
			"abril",  "mayo", "junio", "julio", "agosto", "septiembre",
			"octubre", "noviembre", "diciembre"};
	
	private int day, month, year;
	private boolean isExtended;
	
	/**
	 * Initializes a date with the specified values of day, month, year and 
	 * a boolean to get if the date is extended or shortened.
	 * 
	 * @param day						day of the date
	 * @param month						month of the date
	 * @param year						year of the date
	 * @param isExtended				value which represents the if the format
	 * 									of the date is extended or shortened.
	 * 
	 * @throws DateOutOfRangeException	if date is out of range
	 */
	public Date(int day, int month, int year, boolean isExtended)
			throws DateOutOfRangeException {
		if (isAValidDate(day, month, year)) {
			this.day = day;
			this.month = month;
			this.year = year;
			this.isExtended = isExtended;
		} else {
			throw new DateOutOfRangeException("Date out of range");
		}
	}
	
	/**
	 * Returns the day of the date.
	 * 
	 * @return day	day of the date
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * Sets the day of the date.
	 * 
	 * @param day							day of the date to set
	 * 
	 * @throws DateOutOfRangeException 		if date is out of range
	 */
	public void setDay(int day) throws DateOutOfRangeException {
		if (isAValidDate(day, getMonth(), getYear())) {
			this.day = day;
		} else {
			throw new DateOutOfRangeException("Date out of range");
		}
	}
	
	/**
	 * Returns the month of the date.
	 * 
	 * @return month	month of the date
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * Sets the month of the date
	 * 
	 * @param month						month of the date to set
	 * 
	 * @throws DateOutOfRangeException	if date is out of range 
	 */
	public void setMonth(int month) throws DateOutOfRangeException {
		if (isAValidDate(getDay(), month, getYear())) {
			this.month = month;
		} else {
			throw new DateOutOfRangeException("Date out of range");
		}
	}
	
	/**
	 * Returns the year of the date.
	 * 
	 * @return year	year of the date
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * Sets the year of the date.
	 * 
	 * @param year						year of the date to set
	 * 
	 * @throws DateOutOfRangeException 	if date is out of range
	 */
	public void setYear(int year) throws DateOutOfRangeException {
		if (isAValidDate(getDay(), getMonth(), year)) {
			this.year = year;
		} else {
			throw new DateOutOfRangeException("Date out of range");
		}
	}
	
	/**
	 * Returns the value to know if the date format is extended or shortened.
	 * 
	 * @return isExtended	value to know if the date format is in an extended
	 *  					or shortened format
	 */
	public boolean isExtended() {
		return isExtended;
	}
	
	/**
	 * Converts the date into an extended format.
	 * 
	 * @return isExtended	new value to know if the date is in an extended or
	 * 						shortened format
	 */
	public void toExtendedFormat() {
		this.isExtended = true;
	}
	
	/**
	 * Converts the date into a shortened format.
	 * 
	 * @return isExtended	new value to know if the date is in an extended or
	 *						shortened format
	 */
	public void toShortenedFormat() {
		this.isExtended = false;
	}
	
	/**
	 * Updates the date by one day.
	 */
	public void increase() throws DateOutOfRangeException {
		if (isDayOutOfRange(getDay() + 1, getMonth(), getYear()))  {
			if (isMonthOutOfRange(getMonth() + 1)) {
				setDay(1);
				setMonth(1);
				setYear(getYear() + 1);
			} else {
				setDay(1);
				setMonth(getMonth() + 1);
			}
		} else {
			setDay(getDay() + 1); 
		}
	}
	
	/**
	 * Prints the date in the current format: short or extended.
	 */
	public void print() {
		if (isExtended()) {
			System.out.println(getDay() + " de " + MONTHS[getMonth()] 
					+ " de " + getYear());
		} else {
			System.out.println(getDay() + "/" + getMonth() + "/" + getYear());
		}
	}
	
	/*
	 * Returns true if it is a valid date and false if not.
	 * <br>
	 * This method is based on the real Gregorian Calendar rules.
	 */
	private boolean isAValidDate(int day, int month, int year) {
		boolean isAValidDate = false;
		
		if (!isDayOutOfRange(day, month, year) 
				&& !isMonthOutOfRange(month)) {
			return true;
		}
		
		return isAValidDate;
	}
	
	/*
	 * Returns true if a date is day-out-of-range and false if not.
	 */
	public boolean isDayOutOfRange(int day, int month, int year) {
		if (day <= 0) {
			return true;
		} else {
			if (integerArrayContainsANumber(LONGEST_MONTHS, month)) {
				if (day > 31) {
					return true;
				}
			} else {
				if (month == 2) {
					if (isALeapYear(year)) {
						if (day > 29) {
							return true;
						}
					} else {
						if (day > 28) {
							return true;
						}
					}
				} else {
					if (day > 30) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	/*
	 * Returns true if a date is month-out-of-range and false if not.
	 */
	public boolean isMonthOutOfRange(int month) {
		if (month < 1 && month > 12) {
			return true;
		}
		
		return false;
	}
	
	/*
	 * Check if a year is a leap-year.
	 */
	private boolean isALeapYear(int year) {
		boolean isALeapYear;
		
		if (year % 4 == 0 && year % 100 != 0
				|| year % 400 == 0) {
			isALeapYear = true;
		} else {
			isALeapYear = false; 
		}
		
		return isALeapYear;
	}
	
	/*
	 * Check if an integer array contains a specified number.
	 */
	private boolean integerArrayContainsANumber(int[] array, int number) {
		boolean integerArrayContainsANumber = false; 
		
		for (int i = 0; i < array.length; i++) {
			if (number == array[i]) {
				integerArrayContainsANumber = true;
			}
		}
		
		return integerArrayContainsANumber;
	}
}
