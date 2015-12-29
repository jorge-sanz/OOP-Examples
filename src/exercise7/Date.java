package exercise7;

import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;

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
	 * @param day			day of the date
	 * @param month			month of the date
	 * @param year			year of the date
	 * @param isExtended	value which represents the if the format of the
	 * 						date is extended or shortened
	 */
	public Date(int day, int month, int year, boolean isExtended) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.isExtended = isExtended;
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
	 * @param day	new day of the date.
	 */
	public void setDay(int day) {
		if (isAValidDate(day, getMonth(), getYear())) {
			this.day = day;
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
	 * @param month	new month of the date
	 */
	public void setMonth(int month) {
		if (isAValidDate(getDay(), month, getYear())) {
			this.month = month;
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
	 * @param year	year of the date
	 */
	public void setYear(int year) {
		if (isAValidDate(getDay(), getMonth(), year)) {
			this.year = year;
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
	public void increase() {
		setDay(getDay() + 1);
		if (!isAValidDate(getDay(), getMonth(), getYear())) {
			 
		}
	}
	
	/**
	 * Prints the date with the current format.
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
	 * Check if a date is a valid date. Returns true or throws an specific
	 * exception depending on what is wrong.
	 * <br>
	 * This method is based on the real Gregorian Calendar rules.
	 */
	private boolean isAValidDate(int day, int month, int year) {
		boolean isAValidDate = false;
		
		if (integerArrayContainsANumber(LONGEST_MONTHS, month)) {
			if (1 <= day && day <= 31) {
				isAValidDate = true;
			}
		} else {
			if (month == 2) {
				if (isALeapYear(year)) {
					if (1 <= day && day <= 29) {
						isAValidDate = true;
					}
				} else {
					if (1 <= day && day <= 28) {
						isAValidDate = true;
					}
				}
			} else {
				if (1 <= day && day <= 30) {
					isAValidDate = true;
				}
			}
		}
		
		return isAValidDate;
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
