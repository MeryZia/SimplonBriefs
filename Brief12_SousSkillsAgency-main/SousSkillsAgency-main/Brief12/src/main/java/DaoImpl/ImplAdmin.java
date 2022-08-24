package DaoImpl;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import HibernatUtil.HibernateUtil;
import dao.Dao;
import models.*;

public class ImplAdmin implements Dao <Admin> {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	@Override
	public void save(Admin admin) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();		
		session.beginTransaction();
		session.save(admin);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        Object e =session.get(Admin.class, id);
        if(e==null) throw new RuntimeException("Admin is not delete");
        session.delete(e);
        session.getTransaction().commit();
		 session.close();
		
	}

	@Override
	public void update(Admin admin) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        session.update(admin);
        session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Admin>listAll() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    @SuppressWarnings("unchecked")
		List<Admin> result = (List<Admin>) session.createQuery("from Etudiant").list();
	    session.getTransaction().commit();
	    return result;
	
	}

	@Override
	public Admin listOne(Long id) {
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        Object e =session.get(Admin.class, id);
        if(e==null) throw new RuntimeException("Admin introuvable");
        session.getTransaction().commit();
	     session.close();
	     return (Admin)e;
	}

}
