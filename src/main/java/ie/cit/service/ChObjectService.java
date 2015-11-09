package ie.cit.service;

import java.util.List;

import ie.cit.domain.ChObject;

public interface ChObjectService {
	
	void save(ChObject ch);
	 List <ChObject> findAll();
	 void delete(Long id);
	 ChObject findById(Long id);

}
