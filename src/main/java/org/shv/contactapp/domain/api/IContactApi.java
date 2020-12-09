package org.shv.contactapp.domain.api;

import java.util.Optional;


public interface IContactApi {

	
	/**
	 * Finds contact by id
	 * @param contactId Id of the contact to find
	 * @return Contact found contact
	 */
     Optional<Contact> findContact(Long contactId);

	/**
	 * Creates contact
	 * @param contact to created holding contact details
	 * @return Contact created contact
	 */
     Contact createContact(Contact contact);
	
	
	/**
	 * Updates existing contact
	 * @param  new contact  holding contact details
	 * @param contactId Id of the contact to edit
	 * @return Contact  contact that was edited
	 */
	 Optional<Contact> editContact(Contact contact, Long id);
	
	 
	 /**
	  * Deletes contact by id
	  * @param contactId Id of the contact to delete
	  */
	 void deleteContact(Long contactId);

}
