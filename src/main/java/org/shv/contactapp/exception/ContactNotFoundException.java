package org.shv.contactapp.exception;


/**
 * Exception thrown when contact is not found
 * 
 * @author sharapov
 *
 */
public class ContactNotFoundException extends RuntimeException {
	public ContactNotFoundException(Long id) {
	    super("Could not find contact with id: " + id);
	  }
}

	  
	