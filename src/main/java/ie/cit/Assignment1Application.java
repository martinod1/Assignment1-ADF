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
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.databind.ObjectMapper;

import ie.cit.domain.ChObject;
import ie.cit.domain.Image;
import ie.cit.domain.Participant;
import ie.cit.domain.Participation;
import ie.cit.domain.Role;
import ie.cit.service.ObjectService;

import ie.cit.utility.FileFinder;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@EnableJpaRepositories(basePackages="ie.cit.DAO")
@EntityScan(basePackages="ie.cit.domain")
public class Assignment1Application implements CommandLineRunner {

	String url = "D:\\GitHub\\collection\\objects\\682\\506";

	List<Participation> participations;
	
	ClassPathXmlApplicationContext context = 
	    	  new ClassPathXmlApplicationContext("spring-config.xml");
//	
	
	ObjectService obj = context.getBean(ObjectService.class);
	
	
    public static void main(String[] args) {
        SpringApplication.run(Assignment1Application.class, args);
    }
    @Override
    public void run(String ... arg0) throws Exception
    {
    	    	JSONParser(url);
    	
    }

    public void JSONParser(String url) throws Exception
    {
    	
    	List<Path> files = FileFinder.getFileList(url, "*.json");
    	int count=1;
    	int c=0;
    	for(Path f: files) {
    		//if(c>5)//set limit of 5 objects for testing
    		//	break;
    		
    		ChObject chObject = new ObjectMapper().readValue(f.toFile(), ChObject.class);
    		
    		
    		
    		int objid=(int) chObject.getId();
    		chObject.setObject_id(objid);
    		System.out.println(chObject.toString());
    
    		List<Map<String, Image>> list = chObject.getImages();
			//Set<Image> imageSet=new HashSet<Image>();
			c++;
			
    		for(Map m: list)
    		{
    			Set key = m.keySet();
    			
    			for(Object k: key)
    			{
    				Image image = (Image) m.get(k);
    				
    				
    				//imageSet.add(image);
    				image.setId(count);
    				count++;
    				image.setObject(chObject);
    				
        			image.setKeyVal(k.toString());
        			
    				image.setObject_id(objid);

    				obj.save(image);
        	
    				
    			}
    		//	chObject.setImageSet(imageSet);
    			
    			
    			//get list of participations
    			List<Participation> participants = chObject.getParticipants(); 
    			
    			for(Participation p: participants)
    			{
    				//get role and participant for each participation
    				Participant p1 = p.getParticipant();
    				Role r = p.getRole();
    				
    				//then set role_id and participant_id in Role and Participant objects
    				int role_id=p.getRole_id();
    				r.setRole_id(role_id);
    				obj.save(r);
    				p.setParticipant_id(p1.getPerson_id());
    				
    				p.setChobject_id(chObject.getObject_id());
    				p.setRole_id(r.getRole_id());
    				obj.save(p1);
    				obj.save(p);
    			}
    			chObject.setParticipants(participants);
    		
    			//save chobject
    			obj.save(chObject);
    			
    	
    			
    		
    	}
    	
    }
 
    
    } 
}
