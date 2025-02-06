package in.myorg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.myorg.model.ContactForm;
import in.myorg.service.ContactFormService;
import jakarta.validation.Valid;

@Controller
public class MyController {
	private ContactFormService contactFormServiceImpl;

	@Autowired
	public void setContactFormServiceImpl(ContactFormService contactFormServiceImpl) {
		this.contactFormServiceImpl = contactFormServiceImpl;
	}

	public ContactFormService getContactFormServiceImpl() {
		return contactFormServiceImpl;
	}

	@GetMapping(path = { "welcome", "home", "" })
	public String viewWelcome() {
		return "index";
	}

	@GetMapping("about")
	public String viewAbout() {
		return "about";
	}

	@GetMapping("cars")
	public String viewCars() {
		return "cars";
	}

	@GetMapping("services")
	public String viewServices() {
		return "services";
	}

	@GetMapping("contacts")
	public String viewContacts(Model m) {
		ContactForm cf = new ContactForm();

		m.addAttribute("contactForm", cf);
		return "contacts";
	}

	@PostMapping("contactform")
	public String contactform(@Valid @ModelAttribute ContactForm contactForm, BindingResult br,
			RedirectAttributes redirectAttributes, Model m

	) {

		if (br.hasErrors()) {
			m.addAttribute("bindingresult", br);
			return "contacts";
		}
		ContactForm cf = contactFormServiceImpl.saveContactForm(contactForm);
		if (cf != null) {
			redirectAttributes.addFlashAttribute("message", "message sent successfully");
		} else {
			redirectAttributes.addFlashAttribute("message", "message not sent ");

		}

		return "redirect:/contacts";// new request and new get request

	}

}
