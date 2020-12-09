package org.shv.contactapp.server;

import org.shv.contactapp.app.api.ContactView;
import org.shv.contactapp.app.api.IContactAppService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller providing basic rest endpoints for contact manipulation
 * 
 * @author sharapov
 *
 */
@RestController
public class ContactRestServer {

	  private final IContactAppService contactAppService;
	  
	  public ContactRestServer(IContactAppService contactAppService) {
		  this.contactAppService = contactAppService;
	  }
	  
	  @GetMapping(path = "/contacts/{contactId}", consumes = "application/json", produces = "application/json")
      public ResponseEntity<ContactView> findContact(@PathVariable Long contactId) {
		    
		    ContactView foundContact = contactAppService.findContact(contactId);
		    
	        return new ResponseEntity<>(foundContact, new HttpHeaders(), HttpStatus.OK);
	  }
	  
	  @PostMapping(path = "/contacts", consumes = "application/json", produces = "application/json")
      public ResponseEntity<ContactView> createContact(@RequestBody ContactView contactView) {
		    
		    ContactView createdContact = contactAppService.createContact(contactView);
		    
	        return new ResponseEntity<>(createdContact, new HttpHeaders(), HttpStatus.CREATED);
	  }
	  
	  @PutMapping(path = "/contacts/{contactId}", consumes = "application/json", produces = "application/json")
      public ResponseEntity<ContactView> editContact(@RequestBody ContactView contactView, @PathVariable Long contactId) {
		  
		    ContactView updatedContact = contactAppService.editContact(contactView, contactId);
		    
	        return new ResponseEntity<>(updatedContact, new HttpHeaders(), HttpStatus.OK);
	  }
	  
	  @DeleteMapping(path = "/contacts/{contactId}", consumes = "application/json", produces = "application/json")
      public ResponseEntity<Void> deleteContact(@PathVariable Long contactId) {
		  
		    contactAppService.deleteContact(contactId);
		    
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }
	  
	  
	
}
