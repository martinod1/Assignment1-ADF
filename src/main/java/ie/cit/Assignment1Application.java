package ie.cit;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.databind.ObjectMapper;

import ie.cit.DAO.ChObjectRepository;
//import ie.cit.DAO.ChObjectRepositoryImpl;
import ie.cit.domain.ChObject;
import ie.cit.domain.Image;
import ie.cit.domain.Participant;
import ie.cit.domain.Participation;
import ie.cit.domain.Role;
import ie.cit.service.ChObjectService;
import ie.cit.test.ChObjectRepostioryTest1;
//import ie.cit.service.ChObjectService;
//import ie.cit.service.ChObjectServiceImpl;
import ie.cit.utility.FileFinder;

//@EnableJpaRepositories(basePackages = "com.shruubi.repositories")
//@EntityScan(basePackages = "com.shruubi.models")

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@EnableJpaRepositories(basePackages="ie.cit.DAO")
@EntityScan(basePackages="ie.cit.domain")
public class Assignment1Application implements CommandLineRunner {

	//String url = "D:\\GitHub\\collection\\objects\\682\\506";
	String url = "D:\\GitHub\\collection\\objects\\682\\509";

	List<Participation> participations;
	
	ClassPathXmlApplicationContext context = 
	    	  new ClassPathXmlApplicationContext("spring-config.xml");
//	
	//ChObjectRepository chObj = context.getBean(ChObjectRepository.class);
	
	ChObjectService chObj = context.getBean(ChObjectService.class);
	
	ChObjectRepostioryTest1 test;
	
    public static void main(String[] args) {
        SpringApplication.run(Assignment1Application.class, args);
    }
    @Override
    public void run(String ... arg0) throws Exception
    {
    	//setChObjectService(ch);
    	JSONParser(url);
    	//findAll();
    	//delete((long) 1);
    }
    
    public void delete(Long id)
    {
    	
    	chObj.delete(id);
    }
    
    public void findAll()
    {
    	
    	System.out.println(chObj.findAll().toString());
    }
    
    public void JSONParser(String url) throws Exception
    {
    	
    	List<Path> files = FileFinder.getFileList(url, "*.json");
    	int count=1;
    	int c=0;
    	for(Path f: files) {
    		//if(c>30)//set limit of 5 objects for testing
    		//	break;
    		
    		ChObject chObject = new ObjectMapper().readValue(f.toFile(), ChObject.class);
    		
    		
    		
    		int objid=(int) chObject.getId();
    		chObject.setObject_id(objid);
    		System.out.println(chObject.toString());
    	//	chObject.setObject_Id(1);
			//System.out.println("===");

    		
    		List<Map<String, Image>> list = chObject.getImages();
			//System.out.println("+++");
			Set<Image> imageSet=new HashSet<Image>();
			//chObject.setImageSet(list);
			c++;
			
    		for(Map m: list)
    		{
    			//System.out.println("---");
    			Set key = m.keySet();
    			
    			for(Object k: key)
    			{
    				Image image = (Image) m.get(k);
        			//System.out.println("---99-");
    				
    				
    				imageSet.add(image);
    				image.setId(count);
    				count++;
    				image.setObject(chObject);
    				//System.out.println(image.getObject().toString() + " obj");
        			//System.out.println("------");
        			//System.out.println(k.toString());
        			image.setKeyVal(k.toString());
        			//System.out.println(image.getKeyVal());
    				//System.out.println(chObject.toString());

    				//System.out.println(chObject.getObject_id());
    				//int objid=(int) chObject.getId();
    				
    			//	System.out.println(objid);
    				//System.out.println(chObject.toString());
        		//	System.out.println("---9090--");

    				image.setObject_id(objid);
    				System.out.println(image.toString());

    				//chObj.save(image);
        		//	System.out.println("---9090--");

        			//System.out.println("---------");

    				//String keyVal = k.toString();
    				
    			}
    			chObject.setImageSet(imageSet);
    			//System.out.println("&&&&");
    			//System.out.println(chObject.toString());
    			
    			List<Participation> participants = chObject.getParticipants(); 
    			
    			for(Participation p: participants)
    			{
    				
    				Participant p1 = p.getParticipant();
    				
    			//	chObj.save(p1);
    				
    				Role r = p.getRole();
    				
    				int role_id=p.getRole_id();
    				r.setRole_id(role_id);
    				//chObj.save(r);
    				System.out.println("\n\n\n\n\n"+p1.toString()+"\n"+r.toString()+"\n\n\n");
    				p.setParticipant_id(p1.getPerson_id());
    				
    				p.setChobject_id(chObject.getObject_id());
    				System.out.println(p.getRole().getRole_id());
    				p.setRole_id(r.getRole_id());
    				//p.setRole_id(p.getRole().getRole_id());
    				//chObj.save(p1);
    				//chObj.save(p);
    			}
    			
    			//System.out.println(chObject.getParticipants().get(0).getRole_id());
    			//chObject.setDescription("sample");
    			//chObject.setGallery_text("this is sample gallery text");
    			chObj.save(chObject);
    		//	System.out.println("^^^^");
    			//System.out.println(m.values());
    			
    			//chObject.save(m.values());
    			//m.values();
    		//}
    	
    			//code for participants here
    			
    		
    	}
    	
    }
 
    
    } 
}
