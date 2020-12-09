package org.shv.contactapp.app.api;

/**
 * TODO: introduce security check and validation
 * 
 * @author sharapov
 *
 */
public interface IContactAppService {

	
	/**
	 * Finds contact by id
	 * @param contactId Id of the contact to find
	 * @return ContactView found contact
	 * @throws ContactNotFoundException when contact is not found
	 */
    ContactView findContact(Long contactId);
	
	
	/**
	 * Creates contact
	 * @param contactView contact view holding contact details
	 * @return ContactView created contact
	 */
     ContactView createContact(ContactView contactView);
	
	
	/**
	 * Updates contact
	 * @param contactView new contact view holding contact details
	 * @param contactId Id of the contact to edit
	 * @return ContactView edited contact
	 * @throws ContactNotFoundException when contact to be edited is not found
	 */
	 ContactView editContact(ContactView contactView, Long contactId);
	
	 
	 /**
	  * Deletes contact by id
	  * @param contactId Id of the contact to delete
	  */
	 void deleteContact(Long contactId);
}
