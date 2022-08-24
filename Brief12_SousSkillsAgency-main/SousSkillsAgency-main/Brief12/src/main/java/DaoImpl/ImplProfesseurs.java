package DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import HibernatUtil.HibernateUtil;
import dao.Dao;
import models.Admin;
import models.Cours;
import models.Etudiant;
import models.Professeurs;

public class ImplProfesseurs implements Dao<Professeurs> {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	@Override
	public void save(Professeurs prof) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();		
		session.beginTransaction();
		session.save(prof);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        Object e =session.get(Professeurs.class, id);
        if(e==null) throw new RuntimeException("Professeur is not delete");
        session.delete(e);
        session.getTransaction().commit();
		 session.close();
	}

	@Override
	public void update(Professeurs prof) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        session.update(prof);
        session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Professeurs> listAll() {

	    Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    @SuppressWarnings("unchecked")
		List<Professeurs> result = (List<Professeurs>) session.createQuery("from Etudiant").list();
	    session.getTransaction().commit();
	    return result;
	}

	@Override
	public Professeurs listOne(Long id) {
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        Object e =session.get(Professeurs.class, id);
        if(e==null) throw new RuntimeException("Professeurs introuvable");
        session.getTransaction().commit();
	     session.close();
	     return (Professeurs)e;
	}

}
