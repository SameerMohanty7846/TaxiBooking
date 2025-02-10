package in.myorg.service;

import org.springframework.web.multipart.MultipartFile;

import in.myorg.model.ServiceForm;

public interface ServiceFormService {
public ServiceForm addService(ServiceForm serviceForm,MultipartFile multipartFile) throws Exception;
}
