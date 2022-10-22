package juno.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSubject {

	private List<Observer> observers = new ArrayList<>();
	
	/**
	 * Adds the specified Observer object to
	 * the observers List
	 * @param observer An Observer object
	 */
	public void attach(Observer observer) {
		this.observers.add(observer);
	}

	
	/**
	 * Remove the specified Observer object from
	 * the observers List
	 * @param observer An Observer object
	 */
	public void detach(Observer observer) {
		if(this.observers.contains(observer)) {
			this.observers.remove(observer);
		}
	}
	
	
	/**
	 * 
	 */
	public void updateAll() {
		this.observers.stream().forEach(observer -> observer.update());
	}
	
	
	/**
	 * Returns true if the specified observer is present
	 * in the observers List, otherwise return false.
	 * @param observer An Observer object
	 * @return A boolean
	 */
	public boolean contains(Observer observer) {
		return this.observers.contains(observer);
	}
}
