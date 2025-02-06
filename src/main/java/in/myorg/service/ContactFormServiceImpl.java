package in.myorg.service;

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

}
