package ie.cit.DAO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ie.cit.domain.ChObject;
import ie.cit.domain.Image;


@Repository
@Qualifier(value="ChObjectRepository")
public interface ObjectRepository
//extends CrudRepository<Object, Long>
{

	
	Object save(Object ch);
	 Iterable<Object> findAll();
	 void delete(Long id);
	 Object findById(Long id);

}
