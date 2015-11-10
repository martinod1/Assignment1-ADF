package ie.cit.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ie.cit.DAO.ObjectRepository;
import ie.cit.domain.ChObject;

@Service
@Qualifier("ChObjectService")
public class ObjectServiceImpl implements ObjectService {

	private ObjectRepository chObjectRepo;
	
	private SessionFactory sessionFactory;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public void save(Object ch) {
		 Session session = this.sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	       
	        session.saveOrUpdate(ch);
	        tx.commit();
	        session.close();		
	}

	@Override
	public List<Object> findAll() {
		Session session = this.sessionFactory.openSession();
		List<Object> objects = session.createCriteria(Object.class).list();;
	
	return objects;
	}

	@Override
	public void delete(Long id) {
		ChObject myObject;
		Session session = this.sessionFactory.openSession();
		myObject = (ChObject) session.load(ChObject.class,  id);
		session.delete(myObject);
		
		session.flush();
		
	}

	@Override
	public ChObject findById(Long id) {
		Session session  = this.sessionFactory.openSession();
		ChObject ch = null;
		try{
			ch = (ChObject) session.get(ChObject.class, id);

		}
		catch(Exception e){}
		return ch;
	}

	
	


}
