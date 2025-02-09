package in.myorg.service;

import java.util.List;

import in.myorg.model.ContactForm;

public interface ContactFormService {
	public ContactForm saveContactForm(ContactForm cf);
	public List<ContactForm> getAllContactInfo();
}
