import java.time.LocalDate;

import org.hibernate.Session;

import DaoImpl.*;
import HibernatUtil.HibernateUtil;
import models.*;

public class Main {

	public static void main(String[] args) {
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    

//	    
//	    Admin admin = new Admin(1,"Admin@admin.com","Admin"); 
//	    Professeurs prof = new Professeurs(1,"Ben","Hanae");
//	    Etudiant etudiant = new Etudiant(1,"Zia","Mery");
//	    Cours cours = new Cours(1,"2022-08-10","Java");
//	    
//	    
//	    ImplAdmin IA = new ImplAdmin();
//	    ImplProfesseurs IP = new ImplProfesseurs();
//	    ImplEtudiant IE = new ImplEtudiant();
//	    ImplCours IC = new ImplCours();
//	    
//	    
//	    IA.save(admin);
//	    IP.save(prof);
//	    IE.save(etudiant);
//	    IC.save(cours);

		
	}

}
