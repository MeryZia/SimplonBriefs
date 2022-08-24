package DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernatUtil.HibernateUtil;
import dao.Dao;
import models.*;

public class ImplCours implements Dao <Cours>{

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	@Override
	public void save(Cours cours) {
		
		Session session = sessionFactory.openSession();		
		session.beginTransaction();
		session.save(cours);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(Long id) {
		
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        Object e =session.get(Cours.class, id);
        if(e==null) throw new RuntimeException("Cours is not delete");
        session.delete(e);
        session.getTransaction().commit();
		 session.close();
	}

	@Override
	public void update(Cours cours) {
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        session.update(cours);
        session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Cours>listAll() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    @SuppressWarnings("unchecked")
		List<Cours> result = (List<Cours>) session.createQuery("from Etudiant").list();
	    session.getTransaction().commit();
	    return result;
	}

	@Override
	public Cours listOne(Long id) {
		
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        Object e =session.get(Admin.class, id);
        if(e==null) throw new RuntimeException("Cours introuvable");
        session.getTransaction().commit();
	     session.close();
	     return (Cours)e;
	}

}
