package org.shv.contactapp.app.api;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The class represents the view of the contact
 *  
 * TODO: Introduce resource metadata to hold links and location (if resource was created)
 * 
 * @author sharapov
 *
 */
public class ContactView {

    @JsonProperty(value = "firstName")
	private final String firstName;
	
    @JsonProperty(value = "lastName")
	private final String lastName;
	
    @JsonProperty(value = "email")
	private final String email;

    @JsonCreator
	public ContactView(@JsonProperty(value = "firstName") String firstName, 
			@JsonProperty(value = "lastName") String lastName, 
			@JsonProperty(value = "email") String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}
	
    public int hashCode() {
    	return Objects.hash(firstName, lastName, email);
    }
    
    public boolean equals(Object obj) {
    	if(this == obj) {
    		return true;
    	}
    	
    	if(obj instanceof ContactView) {
    		ContactView otherContact = (ContactView) obj;
    		return Objects.equals(getFirstName(), otherContact.getFirstName()) 
    				&& Objects.equals(getLastName(), otherContact.getLastName()) 
    				&& Objects.equals(getEmail(), otherContact.getEmail()); 
    	}
    	
    	return false;
    }
    
}
