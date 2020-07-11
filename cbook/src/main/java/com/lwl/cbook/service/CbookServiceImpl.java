package com.lwl.cbook.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.lwl.cbook.domain.Contact;
import com.lwl.cbook.repo.CbookRepo;
import com.lwl.cbook.service.exception.ContactAlreadyExistsException;
import com.lwl.cbook.service.exception.ContactNotFoundException;

@Service
public class CbookServiceImpl implements CbookService {

	private static final Logger log = LoggerFactory.getLogger(CbookServiceImpl.class);

	@Autowired
	private CbookRepo cbookRepo;
	
	public Contact addContact(Contact contact) throws ContactAlreadyExistsException {
		Assert.notNull(contact,"Contact object can't be null");
		Assert.notNull(contact.getName(),"Contact name can't be null or empty");
		Assert.notNull(contact.getMobile(),"Contact mobile can't be null or empty");

		Contact savedContact = cbookRepo.save(contact);
		log.info("Contact is saved with id:{}", savedContact.getId());
		return savedContact;
	}

	public Contact updateContact(Contact contact) throws ContactAlreadyExistsException {
		Assert.notNull(contact,"Contact object can't be null");
		Assert.notNull(contact.getName(),"Contact name can't be null or empty");
		Assert.notNull(contact.getMobile(),"Contact mobile can't be null or empty");
		Assert.notNull(contact.getId(),"Contact id can't be null or empty");

		Contact updatedContact = cbookRepo.save(contact);
		log.info("Contact is saved with id:{}", updatedContact.getId());
		return updatedContact;
	}

	public boolean deleteContact(String cid) {
		Assert.notNull(cid,"Contact id can't be null or empty");
		Optional<Contact> opt = cbookRepo.findById(cid);
		if(opt.isPresent()) {
			cbookRepo.deleteById(cid);
			log.info("Contact with id:{} is deleted succcessfully",cid);
			return true;
		}
		log.info("Contact with id:{} couldn't be deleted or not found",cid);
		return false;
	}

	public List<Contact> allContacts() {
		List<Contact> contacts = cbookRepo.findAll();
		log.info("Total contacts found in DB:{} ",contacts.size());
				
		return contacts;
	}

	public List<Contact> search(String str) {
		Assert.notNull(str, "Search string can't be null or empty");
		List<Contact> contacts= cbookRepo.findByNameLike(str);
		log.info("Total {} contacts found for given search string {}", contacts.size(),str);
		return contacts;
	}

	public Contact getContactById(String cid) throws ContactNotFoundException {
		Assert.notNull(cid, "Contact id can't be null or empty");
		Optional<Contact> opt = cbookRepo.findById(cid);
		if(opt.isPresent()) {
			return opt.get();
		}
		log.info("Contact is not found for given id:{}",cid);
		throw new ContactNotFoundException("Contact is not found for given id:"+cid);
	}
	

}
