package in.myorg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {
	@GetMapping(path= {"welcome","home",""})
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
	public String viewContacts() {
		return "contacts";
	}
	
	
	
}
