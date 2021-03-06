/**
 * @author Rachel Renegado <a href="mailto:rachel.renegado@ucalgary.ca">email</a>
 * 
 *  @version 1.0
 *  @since 1.0
 */

package Services;

import java.io.*;
import java.util.*;

public interface SubscriptionServiceSubject {
	public void registerSubscribedObserver(SubscribedObserver subscriber);

	public void removeSubscribedObserver(SubscribedObserver subscriber);

	public void notifyAllSubscribedObservers();

}
