package org.shv.contactapp.domain.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.shv.contactapp.domain.api.Contact;
import org.shv.contactapp.domain.api.IContactApi;
import org.shv.contactapp.repository.IContactRepository;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class ContactApi implements IContactApi {

	private final IContactRepository contactRepository;
	
	public ContactApi(IContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	@Override
	public Optional<Contact> findContact(Long contactId) {
		return contactRepository.findById(contactId);
	}
	
	@Override
	public Contact createContact(Contact contact) {
		return contactRepository.save(contact);
	}

	@Override
	public Optional<Contact> editContact(Contact contact, Long id) {
		Optional<Contact> optionalContact = contactRepository.findById(id);
		
		if(optionalContact.isPresent()) {
			Contact existingContact = optionalContact.get();
			existingContact.setFirstName(contact.getFirstName());
			existingContact.setLastName(contact.getLastName());
			existingContact.setEmail(contact.getEmail());
	    	  
	        return Optional.of(contactRepository.save(existingContact));

		}
		
	    return Optional.empty();
	}

	@Override
	public void deleteContact(Long contactId) {
		contactRepository.deleteById(contactId);
	}
}
