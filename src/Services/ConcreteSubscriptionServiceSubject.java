/**
 * @author Rachel Renegado <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 * 
 *  @version 1.2 added documentation
 *  @since 1.0
 *  
 * ConcreteSubscriptionServiceSubject impliments the Observer design pattern
 * and represents a Concrete Subject class. 
 * 
 * Renters (concrete observers) will 
 * create an instance of this class to register and remove their subscription.
 * 
 * Landlord will get the only instance of this class and call add property 
 * when they add a property to the database.
 */

package Services;

import java.io.*;
import java.util.*;
import Employee.Property;
import BackEnd.DatabaseController;
import Services.SubscriptionServiceSubject;
import Services.SubscribedObserver;

public class ConcreteSubscriptionServiceSubject implements SubscriptionServiceSubject{
	private static ConcreteSubscriptionServiceSubject onlyInstance;
	private DatabaseController dbControl;
	static private ArrayList<SubscribedObserver> subscribers;
	static private ArrayList<Property> newProperty;

	public ConcreteSubscriptionServiceSubject() {
		dbControl = new DatabaseController();
		subscribers = new ArrayList<SearchObserver>();
		newProperty = new ArrayList<Property>();
	}

	/**
	 * Adds new subscriber to the list of saved subscribers. 
	 * 
	 * This method is made static such that any element is able to use it.
	 *
	 * @param subscriber The renter (SearchObserver) wishing to subscribe 
	 */
	static public void registerSubscribedObserver(SubscribedObserver subscriber) {
		subscribers.add(subscriber);
		subscribers.update(newProperty);
	}

	/**
	 * Removes subscriber from the list of saved subscribers. 
	 * 
	 * This method is made static such that any element is able to use it.
	 *
	 * @param subscriber The renter (SearchObserver) wishing to unsubscribe 
	 */
	static public void removeSubscribedObserver(SubscribedObserver subscriber) {
		subscribers.remove(subscriber);
	}

	/**
	 * Notifies and updates all the subscribers when a new property is added
	 * 
	 * This method is made static such that any element is able to use it.
	 */
	static public void notifyAllSubscribedObservers() {
		for (int i = 0; i < subscribers.size(); i++) {
			SubscribedObserver subscribers = subscribers.get(i);
			subscribers.update(newProperty);
		}
	}

	/**
	 * Removes subscriber from the list of saved subscribers. 
	 * 
	 * This method is made static such that any element is able to use it.
	 *
	 * @param subscriber The renter (SearchObserver) wishing to unsubscribe 
	 */
	public void addProperty(Property p) {
		newProperty.add(p);
		notifyAllSubscribedObservers();
	}

	/**
	 * Returns the onlyInstance of ConcreteSubscriptionServiceSubject.
	 * Used by Landlord to get the only instance. Impliments the Singleton 
	 * design pattern
	 * 
	 * This method is made static such that any element is able to use it.
	 *
	 * @return The only instance of ConcreteSubscriptionServiceSubject
	 */
	public static ConcreteSubscriptionServiceSubject getOnlyInstance() {
		if (onlyInstance == null)
			onlyInstance = new ConcreteSubscriptionServiceSubject();
		return onlyInstance;
	}
}
