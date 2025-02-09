package in.myorg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.myorg.model.ContactForm;
import in.myorg.service.BookingFormService;
import in.myorg.service.ContactFormService;

@Controller
@RequestMapping("/admin")
public class AdminController {

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

	@GetMapping("dashboard")
	public String adminDashboard() {
		return "admin/dashboard";
	}

	@GetMapping("readAllContacts")
	public String readAllContacts(Model model) {
		List<ContactForm> list = contactFormServiceImpl.getAllContactInfo();
		model.addAttribute("allcontacts", list);
		return "admin/readallcontacts";
	}

}
