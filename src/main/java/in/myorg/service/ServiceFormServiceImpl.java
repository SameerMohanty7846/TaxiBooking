package in.myorg.service;

import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.myorg.dao.ServiceFormCrud;
import in.myorg.model.ServiceForm;
import jakarta.transaction.Transactional;

@Service
public class ServiceFormServiceImpl implements ServiceFormService {
	private ServiceFormCrud repo;

	@Autowired
	public void setRepo(ServiceFormCrud repo) {
		this.repo = repo;
	}

	@Transactional(rollbackOn = Exception.class)
	@Override
	public ServiceForm addService(ServiceForm serviceForm, MultipartFile multipartFile) throws Exception {
		ServiceForm save = null;
		try {
			save = repo.save(serviceForm);
			if(save!=null) {
				String path = "C:\\springboot workspace\\workspace3\\TaxiBooking\\src\\main\\resources\\static\\myserviceimg\\"
						+ multipartFile.getOriginalFilename();

				byte bytes[] = multipartFile.getBytes();
				FileOutputStream fous = new FileOutputStream(path);
				fous.write(bytes);
			}else {
				
			}
			

		} catch (Exception e) {
			throw e;
		}
		return save;
	}

}
