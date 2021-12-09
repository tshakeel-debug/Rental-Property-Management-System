package Employee;

import java.util.ArrayList;
public class Manager {

	private String username;
	private String password;
	private FeeController feeControl;
	private DatabaseController dbControl;
	private ArrayList <Property> properties = new ArrayList<Property>();
	
	public Manager() 
	{
		
	}
	public Manager (String username, String password)
	{
		this.username=username;
		this.password=password;
	} 
	
	public String getUsername()
	{
		return username;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setUsername(String username) 
	{
		this.username=username;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	} 

	public ArrayList<Property> getSummary()
	{
		
		return arrayProperty;
		
	}
	
	/**
	 * Generates grid bag constraints with provided values.
	 *
	 * @param propertyID Property id representing the property being changed
	 * @param state The new state of the property
	 * 
	 * @return If state change was successful
	 */
	public boolean changeState(int propertyID, String state) {
		return dbControl.changePropertyState(propertyID, state);

	}
	
}
