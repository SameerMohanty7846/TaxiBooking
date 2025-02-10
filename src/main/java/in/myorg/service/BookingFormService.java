package in.myorg.service;

import java.util.List;

import in.myorg.model.BookingForm;

public interface BookingFormService {
	public BookingForm saveBookingFormService(BookingForm bookingForm);
	public List<BookingForm> getAllBookingInfo();
	public void deleteBookingService(Integer id);

}
