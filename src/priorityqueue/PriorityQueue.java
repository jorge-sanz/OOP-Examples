package priorityqueue;

import java.util.ArrayList;

/**
 * PriorityQueue is a class which represents a queue with elements with
 * priority, which means that the first element you can extract is the one which
 * has the higher priority (order of priority: 1, 2, 3...). 
 *
 * @author Jorge Sanz Perez
 */
public class PriorityQueue<E> { 
	private ArrayList<Element<E>> queue;
	
	/**
	 * Initializes a priority queue.
	 */
	public PriorityQueue() {
		queue = new ArrayList<Element<E>>();
	}
	
	/**
	 * Adds an element with a priority associated to the priority queue.
	 * 
	 * @param element		element to add
	 * @param priority		priority level associated to the element
	 */
	public void add(E element, int priority) {
		Element<E> elementToAdd = new Element<E>(element, priority);
		
		if (getQueue().isEmpty()) {
			getQueue().add(elementToAdd);
		} else {
			for (int i = 0; i < getQueue().size(); i++) {
				if (elementToAdd.getPriority() 
						< getQueue().get(i).getPriority()) {
					getQueue().add(i, elementToAdd);
					break;
				}
				
				if (i == getQueue().size() - 1) {
					getQueue().add(elementToAdd);
				}
			} 
		}
	}
	
	/**
	 * Returns the head element of the queue.
	 * 
	 * @return headElement	head element of the queue
	 */
	public Element<E> peek() {
		return getQueue().get(0);
	}
	
	/**
	 * Return the head element of the queue and removes it from there.
	 * 
	 * @return headElement	head element of the queue.
	 */
	public Element<E> poll() {
		Element<E> headElement = getQueue().get(0);
		getQueue().remove(0);
		return headElement;
	}
	
	/*
	 * Returns the queue.
	 */
	private ArrayList<Element<E>> getQueue() {
		return queue;
	}
}
