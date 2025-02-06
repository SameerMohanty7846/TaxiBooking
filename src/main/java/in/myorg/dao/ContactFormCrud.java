package in.myorg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.myorg.model.ContactForm;
@Repository
public interface ContactFormCrud extends JpaRepository<ContactForm, Integer> {

}
