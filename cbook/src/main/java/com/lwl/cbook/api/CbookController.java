package com.lwl.cbook.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lwl.cbook.domain.Contact;
import com.lwl.cbook.service.CbookService;
import com.lwl.cbook.service.exception.ContactAlreadyExistsException;
import com.lwl.cbook.service.exception.ContactNotFoundException;

@RestController
@RequestMapping("/api/v1/cbook")
public class CbookController {
	@Autowired
	private CbookService cbookService;
	
	@PostMapping("/addnewcontact")
	public Contact addContact(@RequestBody Contact contact) throws ContactAlreadyExistsException {
		return cbookService.addContact(contact);
	}
	
	@GetMapping("/allcontacts")
	public List<Contact> allContacts(){
		return cbookService.allContacts();
	}
	
	@PutMapping("/updatecontact")
	public Contact updateContact(@RequestBody Contact contact) throws ContactAlreadyExistsException{
		return cbookService.updateContact(contact);
	}
	
	@GetMapping("/search/{str}")
	public List<Contact> search(@PathVariable("str") String str){
		return cbookService.search(str);
	}
	
	@GetMapping("/getcontactbyid/{cid}")
	public Contact getContact(@PathVariable("cid") String cid) throws ContactNotFoundException{
		return cbookService.getContactById(cid);
	}
	
	@DeleteMapping("/deletecontact/{cid}")
	public String deleteContact(@PathVariable("cid")String cid) {
		boolean isDeleted = cbookService.deleteContact(cid);
		return isDeleted ? "Contact with id: "+cid+" is deleted successfully":"Contact with id"+cid+"not found"; 
	}
}