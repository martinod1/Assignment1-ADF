package ie.cit;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import ie.cit.DAO.ObjectRepository;
import ie.cit.domain.ChObject;
import ie.cit.service.ObjectService;
import ie.cit.service.ObjectServiceImpl;
import junit.framework.Assert;
@RunWith(MockitoJUnitRunner.class)
//@Transactional
@ContextConfiguration(locations={"spring-config.xml"})
public class ObjectServiceTest {
	
	@Mock
	private ObjectRepository objRepo;
	@InjectMocks
	@Autowired
	private ObjectServiceImpl objService;
	//= new ObjectServiceImpl();
	
	/*@Mock
	private SessionFactory sessionFactory;*/
	@Mock
	ChObject c;
	
	
	@Before
	public void doSetup() {
		MockitoAnnotations.initMocks(this);
	/*	@Mock
		ClassPathXmlApplicationContext context = 
		    	  new ClassPathXmlApplicationContext("spring-config.xml");
		objService  = context.getBean(ObjectServiceImpl.class);*/
	//	objService.setSessionFactory(sessionFactory);
	//	objRepo = mock(ObjectRepository.class);
		//objService = new ObjectService
		c = new ChObject();
		c.setCreditline("Credit Line");
		c.setTitle("Title");
		c.setDate("Early 2000");
		c.setDescription("Sample desc");
		c.setGallery_text("Gallery Text");
		c.setId(1);
		c.setMedium("Medium");
		c.setObject_id(12345);
		
	}
	@Test
	public void save()
	{
		// specify mock behave when method called
      //  when(objService.save(any(ChObject.class))).thenReturn(Long.valueOf(1));
        
        objService.save(c);
       // assertNotNull();
         
	
		
	}
	

}
