package ie.cit.test;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ie.cit.DAO.ChObjectRepository;
import ie.cit.DAO.ChObjectRepositoryImpl;
import ie.cit.domain.ChObject;
import ie.cit.domain.Role;

@Transactional
public class ChObjectRepostioryTest1 {
	@Resource
	ChObjectRepositoryImpl chObj;
	
	//this code is completed before the other tests are run
	@Before
	public void setUp() {
		
		ClassPathXmlApplicationContext context = 
		    	  new ClassPathXmlApplicationContext("spring-config.xml");
		ChObjectRepositoryImpl chObj  = context.getBean(ChObjectRepositoryImpl.class);
		
	}
	

	@Test
	public void testFindAll() {
		
		Assert.assertFalse(chObj.findAll().isEmpty());
	}
	
	public void testAdd()
	{
		ChObject ch = new ChObject();
		ch.setCreditline("Sample CreditLine");
		ch.setDate("Early 2000");
		ch.setDescription("Description");
		ch.setGallery_text("Gallery Text");
		ch.setId(1);
		ch.setMedium("Medium");
		ch.setObject_id(12345);
		ch.setTitle("Title");
		ch.setImages(null);
		ch.setImageSet(null);
		ch.setParticipants(null);
		chObj.save(ch);
		
		Assert.assertNotNull(chObj.findById((long) 1));
	}
	
	

}
