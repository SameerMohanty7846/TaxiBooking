package in.myorg.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.myorg.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	public Optional<Admin>findByUsername(String username);
}
