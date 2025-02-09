package in.myorg.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.myorg.dao.AdminRepository;
import in.myorg.model.Admin;
import jakarta.annotation.PostConstruct;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	private AdminRepository repo;
	private PasswordEncoder passwordEncoder;
	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	@Autowired
	public void setRepo(AdminRepository repo) {
		this.repo = repo;
	}
	@PostConstruct
	public void init() {
		long count=repo.count();
		if(count==0) {
			Admin admin=new Admin();
			admin.setUsername("admin");
			admin.setPassword(passwordEncoder.encode("admin123"));
			repo.save(admin);
		}
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Admin> byUsername = repo.findByUsername(username);
		Admin admin = byUsername.orElseThrow(() -> new UsernameNotFoundException("Admin Does Not Exist"));

		return User.withUsername(admin.getUsername()).password(admin.getPassword()).build();

	}

}
