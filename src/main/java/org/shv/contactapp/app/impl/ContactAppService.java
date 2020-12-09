package org.shv.contactapp.app.impl;

import java.util.Optional;

import org.shv.contactapp.app.api.ContactView;
import org.shv.contactapp.app.api.IContactAppService;
import org.shv.contactapp.domain.api.Contact;
import org.shv.contactapp.domain.api.IContactApi;
import org.shv.contactapp.exception.ContactNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ContactAppService implements IContactAppService {

	private final IContactApi contactApi;
	
	public ContactAppService(IContactApi contactApi) {
		this.contactApi = contactApi;
	}
	
	@Override
	public ContactView findContact(Long contactId) {
		Optional<Contact> optionalCountact = contactApi.findContact(contactId);
		
		return optionalCountact.map(c -> {
			return new ContactView(c.getFirstName(), c.getLastName(), c.getEmail());
		}).orElseGet(() -> {
	    	  throw new ContactNotFoundException(contactId);
	    });
	}
	
	@Override
	public ContactView createContact(ContactView contactView) {
		
		Contact newContact = new Contact(null,contactView.getFirstName(), contactView.getLastName(), contactView.getEmail());
		
		Contact createdContact = contactApi.createContact(newContact);
		
		ContactView createdContactView = new ContactView(createdContact.getFirstName(), createdContact.getLastName(), createdContact.getEmail());
	
		return createdContactView;
	}

	@Override
	public ContactView editContact(ContactView contactView, Long contactId) {
		
		Contact contactToEdit = new Contact(contactId,contactView.getFirstName(), contactView.getLastName(), contactView.getEmail());
		
		Optional<Contact> optionalContact = contactApi.editContact(contactToEdit, contactId);
		
		
		return optionalContact.map(c -> {
			return new ContactView(c.getFirstName(), c.getLastName(), c.getEmail());
		}).orElseGet(() -> {
	    	  throw new ContactNotFoundException(contactId);
	    });
	}

	@Override
	public void deleteContact(Long contactId) {
		contactApi.deleteContact(contactId);
	}

}
