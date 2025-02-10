package in.myorg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.myorg.dao.BookingFormCrud;
import in.myorg.model.BookingForm;
@Service
public class BookingFormServiceImpl implements BookingFormService {

	private BookingFormCrud repo;

	@Autowired
	public void setRepo(BookingFormCrud repo) {
		this.repo = repo;
	}

	public BookingFormCrud getRepo() {
		return repo;
	}

	@Override
	public BookingForm saveBookingFormService(BookingForm bookingForm) {
		BookingForm bf = repo.save(bookingForm);
		return bf;
	}

	public BookingFormServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BookingForm> getAllBookingInfo() {
		return repo.findAll();
	}

	@Override
	public void deleteBookingService(Integer id) {
		repo.deleteById(id);		
	}

}
