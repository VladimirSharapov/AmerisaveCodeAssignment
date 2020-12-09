package org.shv.contactapp.domain.api;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * Entity class for holding contact details
 * @author sharapov
 *
 */
@Entity
public class Contact {

	    @Id @GeneratedValue
	    private  Long id;
	    
		private  String firstName;
		
		private  String lastName;
		
		private  String email;

		public Contact() {}
		
		public Contact(Long id, String firstName, String lastName, String email) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
		}

		public Long getId() {
			return id;
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
		
		public void setId(Long id) {
			this.id = id;
		}
		
	    public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public int hashCode() {
	    	return Objects.hash(getId(), getFirstName(), getLastName(), getEmail());
	    }
	    
	    public boolean equals(Object obj) {
	    	if(this == obj) {
	    		return true;
	    	}
	    	
	    	if(obj instanceof Contact) {
	    		Contact otherContact = (Contact) obj;
	    		
	    		return Objects.equals(getId(), otherContact.getId()) 
	    				&& Objects.equals(getFirstName(), otherContact.getFirstName()) 
	    				&& Objects.equals(getLastName(), otherContact.getLastName()) 
	    				&& Objects.equals(getEmail(), otherContact.getEmail()); 
	    	}
	    	
	    	return false;
	    }
	    
	
}
