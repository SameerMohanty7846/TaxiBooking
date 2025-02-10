package in.myorg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.myorg.model.ServiceForm;

public interface ServiceFormCrud extends JpaRepository<ServiceForm, Integer> {

}
