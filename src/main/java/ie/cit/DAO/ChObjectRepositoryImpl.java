/*package ie.cit.DAO;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ie.cit.domain.ChObject;
import ie.cit.domain.Image;


public class ChObjectRepositoryImpl implements ChObjectRepository
{
	private SessionFactory sessionFactory;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
     
    public void save(Object ch) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        //session.persist(ch);
        session.saveOrUpdate(ch);
        tx.commit();
        session.close();
    }



	
	//add session variable
	@Override
	public List<Object> findAll() {
		Session session = this.sessionFactory.openSession();
		
			List<Object> objects = session.createCriteria(ChObject.class).list();;
		
		
		return objects;
		
	}

	public void delete(Long id) {
		ChObject myObject;
		Session session = this.sessionFactory.openSession();
		myObject = (ChObject) session.load(ChObject.class,  id);
		session.delete(myObject);
		
		session.flush();
		
		
	}

	public ChObject findById(Long id) {
		Session session  = this.sessionFactory.openSession();
		ChObject ch = null;
		try{
			ch = (ChObject) session.get(ChObject.class, id);

		}
		catch(Exception e){}
		return ch;
	}
	
	
}*/