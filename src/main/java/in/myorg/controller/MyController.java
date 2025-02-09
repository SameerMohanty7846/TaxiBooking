package in.myorg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.myorg.model.BookingForm;
import in.myorg.model.ContactForm;
import in.myorg.service.BookingFormService;
import in.myorg.service.ContactFormService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class MyController {
	private ContactFormService contactFormServiceImpl;
	private BookingFormService bookingFormServiceImpl;

	@Autowired
	public void setBookingFormServiceImpl(BookingFormService bookingFormServiceImpl) {
		this.bookingFormServiceImpl = bookingFormServiceImpl;
	}

	@Autowired
	public void setContactFormServiceImpl(ContactFormService contactFormServiceImpl) {
		this.contactFormServiceImpl = contactFormServiceImpl;
	}

	public ContactFormService getContactFormServiceImpl() {
		return contactFormServiceImpl;
	}

	public BookingFormService getBookingFormServiceImpl() {
		return bookingFormServiceImpl;
	}

	@GetMapping(path = { "welcome", "home", "/", "index" })
	public String viewWelcome(Model m) {
		m.addAttribute("bookingForm", new BookingForm());
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

	@PostMapping("bookingform")
	public String bookingform(@Valid @ModelAttribute BookingForm bookingForm, BindingResult br,
			RedirectAttributes redirectAttributes, Model m

	) {

		if (br.hasErrors()) {
			m.addAttribute("bindingresult", br);
			return "index";
		} else if (bookingForm.getAdult() + bookingForm.getChildren() > 4) {
			m.addAttribute("message", "The total number of adult and children can not exceed 4");
			return "index";
		}
		BookingForm bf = bookingFormServiceImpl.saveBookingFormService(bookingForm);
		if (bf != null) {
			redirectAttributes.addFlashAttribute("message", "Booking done successfully");
		} else {
			redirectAttributes.addFlashAttribute("message", "message not sent ");

		}

		return "redirect:/welcome";// new request and new get request

	}

	@GetMapping("Login")
	public String adminLoginView(HttpServletRequest request, Model model) {
		ServletContext context = request.getServletContext();
		Object attribute = context.getAttribute("logout");
		if(attribute instanceof Boolean) {
			model.addAttribute("logout", attribute);
			
		}
		return "adminlogin";
	}
	
}
