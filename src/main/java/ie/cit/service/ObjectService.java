package ie.cit.service;

import java.util.List;

import ie.cit.domain.ChObject;

public interface ObjectService {
	
	void save(Object ch);
	 List <Object> findAll();
	 void delete(Long id);
	 Object findById(Long id);

}
