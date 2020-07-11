package com.lwl.cbook.service;

import java.util.List;

import com.lwl.cbook.domain.Contact;
import com.lwl.cbook.service.exception.ContactAlreadyExistsException;
import com.lwl.cbook.service.exception.ContactNotFoundException;

public interface CbookService {
	
	public Contact addContact(Contact contact)throws ContactAlreadyExistsException;
	public Contact updateContact(Contact contact)throws ContactAlreadyExistsException;
	public boolean deleteContact(String cid);
	public List<Contact> allContacts();
	public List<Contact> search(String str);
	public Contact getContactById(String cid)throws ContactNotFoundException;
}
