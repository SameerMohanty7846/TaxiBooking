package in.myorg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.myorg.model.BookingForm;
import in.myorg.model.ContactForm;
import in.myorg.model.ServiceForm;
import in.myorg.service.BookingFormService;
import in.myorg.service.ContactFormService;
import in.myorg.service.ServiceFormService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private ContactFormService contactFormServiceImpl;
	private BookingFormService bookingFormServiceImpl;
	private ServiceFormService serviceFormServiceImpl;

	@Autowired
	public void setServiceFormService(ServiceFormService serviceFormService) {
		this.serviceFormServiceImpl = serviceFormService;
	}

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

	@GetMapping("deleteContact/{id}")
	public String deleteContact(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		contactFormServiceImpl.deleteContactService(id);

		redirectAttributes.addFlashAttribute("message", "CONTACT DELETED SUCCESSFULLY");
		return "redirect:/admin/readAllContacts";
	}

	@GetMapping("readAllBookings")
	public String readAllBookings(Model model) {
		System.out.println("ADMIN PANEL UPDATED");
		List<BookingForm> list = bookingFormServiceImpl.getAllBookingInfo();
		model.addAttribute("allbookings", list);
		return "admin/readallbookings";
	}

	@GetMapping("deleteBooking/{id}")
	public String deleteBooking(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		bookingFormServiceImpl.deleteBookingService(id);
		redirectAttributes.addFlashAttribute("message", "BOKING DELETED SUCCESSFULLY");
		return "redirect:/admin/readAllBookings";
	}

	@GetMapping("addService")
	public String addServiceView() {

		return "admin/addservice";
	}

	@InitBinder
	public void stopBinding(WebDataBinder webDataBinder) {
		webDataBinder.setDisallowedFields("image");
	}

	@PostMapping("addService")
	public String addService(@ModelAttribute ServiceForm serviceForm,
			@RequestParam("image") MultipartFile multipartFile,RedirectAttributes redirectAttributes) {
		String original = multipartFile.getOriginalFilename();
		serviceForm.setImage(original);
		try {
			ServiceForm sf=	serviceFormServiceImpl.addService(serviceForm, multipartFile);
			if(sf!=null) {
				
			}else {
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/addservice";
	}

}
