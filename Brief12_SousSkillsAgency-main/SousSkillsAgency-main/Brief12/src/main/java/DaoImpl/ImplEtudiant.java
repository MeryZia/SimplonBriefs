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

public class ImplEtudiant implements Dao<Etudiant> {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	@Override
	public void save(Etudiant etudiant) {
		Session session = sessionFactory.openSession();		
		session.beginTransaction();
		session.save(etudiant);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void delete(Long id) {
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        Object e =session.get(Etudiant.class, id);
        if(e==null) throw new RuntimeException("Etudiant is not delete");
        session.delete(e);
        session.getTransaction().commit();
		 session.close();
	}

	@Override
	public void update(Etudiant etudiant) {
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        session.update(etudiant);
        session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<Etudiant> listAll() {

	    Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    @SuppressWarnings("unchecked")
		List<Etudiant> result = (List<Etudiant>) session.createQuery("from Etudiant").list();
	    session.getTransaction().commit();
	    return result;
	}

	@Override
	public Etudiant listOne(Long id) {
		Session session = sessionFactory.openSession();	
        session.beginTransaction();
        Object e =session.get(Etudiant.class, id);
        if(e==null) throw new RuntimeException("Etudiant introuvable");
        session.getTransaction().commit();
	     session.close();
	     return (Etudiant)e;
	}

}
