package org.shv.contactapp.repository;

import org.shv.contactapp.domain.api.Contact;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IContactRepository extends JpaRepository<Contact, Long> {

}