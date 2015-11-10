package ie.cit;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ie.cit.Assignment1Application;
import ie.cit.domain.ChObject;
import ie.cit.service.ObjectServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Assignment1Application.class)
public class Assignment1ApplicationTests {

	
	@Resource
	ObjectServiceImpl obj;
	
	
	ChObject ch = new ChObject();
	
	//this code is completed before the other tests are run
	@Before
	public void setUp() {
		
		ClassPathXmlApplicationContext context = 
		    	  new ClassPathXmlApplicationContext("spring-config.xml");
		obj  = context.getBean(ObjectServiceImpl.class);
		ch.setCreditline("Sample CreditLine");
		ch.setDate("Early 2000");
		ch.setDescription("Description");
		ch.setGallery_text("Gallery Text");
		ch.setId(1);
		ch.setMedium("Medium");
		ch.setObject_id(12345);
		ch.setTitle("Title");
		
	}
	
	//public void save Participation();


	@Test
	public void testAdd()
	{
		
		obj.save(ch);
		
		Assert.assertNotNull(obj.findById(ch.getId()));
	}
	@Test
	public void testFindAll()
	{
		List<Object> c = obj.findAll();
		Assert.assertNotNull(c);
	}
	@Test
	public void testFindById()
	{
		testAdd();
		long id= 1;
		ChObject ch = obj.findById(id);
		Assert.assertNotNull(ch);
		
	}
	@Test
	public void testDelete()
	{
		testAdd();
		long id=1;
		obj.delete(id);
		Assert.assertNull(obj.findById(id));
	}
	@Test(expected = Exception.class)
	public void testDeleteFail()
	{
		long id=999;
		obj.delete(id);
		Assert.assertNull(obj.findById(id));
	}
	

}
