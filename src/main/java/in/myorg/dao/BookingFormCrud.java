package in.myorg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.myorg.model.BookingForm;
@Repository
public interface BookingFormCrud extends JpaRepository<BookingForm, Integer> {

}
