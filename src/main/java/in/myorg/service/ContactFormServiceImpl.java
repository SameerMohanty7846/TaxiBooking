package in.myorg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.myorg.dao.ContactFormCrud;
import in.myorg.model.ContactForm;

@Service
public class ContactFormServiceImpl implements ContactFormService {
	private ContactFormCrud contactFormCrud;
	

    @Autowired
	public void setContactFormCrud(ContactFormCrud contactFormCrud) {
		this.contactFormCrud = contactFormCrud;
	}



	@Override
	public ContactForm saveContactForm(ContactForm cf) {
		ContactForm c=	 contactFormCrud.save(cf);
		return c;
	}



	@Override
	public List<ContactForm> getAllContactInfo() {
		
		return contactFormCrud.findAll();
	}



	@Override
	public void deleteContactService(Integer id) {
		contactFormCrud.deleteById(id);		
	}

}
