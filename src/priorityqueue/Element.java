package priorityqueue;

public class Element<E> {
	private E object;
	private int priority;
	
	/**
	 * Initializes an element with the specified values of object associated 
	 * and priority.
	 * 
	 * @param object	object value
	 * @param priority	element priority
	 */
	public Element(E object, int priority) {
		this.object = object;
		this.priority = priority;
	}
	
	/**
	 * Returns the object value.
	 * 
	 * @return object	object value
	 */
	public E getObject() {
		return object;
	}
	
	/**
	 * Returns the element priority.
	 * 
	 * @return priority		element priority
	 */
	public int getPriority() {
		return priority;
	}
	
	/**
	 * Returns negative number, zero or positive number if (this)'s priority
	 * is less, equal or higher than b's priority respectively.
	 * 
	 * @return negative number, zero or positive number if (this)'s priority
	 * is less, equal or higher than b's priority respectively.
	 */
	public int compareTo(Element<E> b) {
		return getPriority() - b.getPriority();
	}
	
}
