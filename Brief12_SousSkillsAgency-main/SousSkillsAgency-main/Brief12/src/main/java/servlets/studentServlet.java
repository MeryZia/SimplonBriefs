package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import DaoImpl.ImplEtudiant;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Etudiant;

@WebServlet("/")
public class studentServlet extends HttpServlet{
		
	    private static final long serialVersionUID = 1L;
	    private ImplEtudiant ime=new ImplEtudiant();

	    public void init() {
	    	ime = new ImplEtudiant();
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        doGet(request, response);
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        String action = request.getServletPath();
	        PrintWriter out = response.getWriter();
	    
	        try {
	            switch (action) {     
	                case "/new":
	    				showNewForm(request, response);
	    				break;
	    			case "/insert":
	    				insert(request, response);
	    				break;
	    			case "/delete":
	    				delete(request, response);
	    				break;
	    			case "/edit":
	    				showEditForm(request, response);
	    				break;
	    			case "/update":
	    				update(request, response);
	    				break;
	    			case "/list":
	    				listAll(request, response);
	    				break;
	    			default:
	    				RequestDispatcher dispatcher = request.getRequestDispatcher("Login/login.jsp");
	    				dispatcher.forward(request, response);
	    				break;
	            }
	        } catch (SQLException ex) {
	            throw new ServletException(ex);
	        }
	        
	    }

	    private void listAll(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException, ServletException {
	    	
	        List < Etudiant > listEtudiant = ime.listAll();
	        System.out.println(listEtudiant);
	        request.setAttribute("listEtudiant", listEtudiant);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("listStudents.jsp");
	        dispatcher.forward(request, response);
	    }

	    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("AddNewStudent.jsp");
	        dispatcher.forward(request, response);
	    }

	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, ServletException, IOException {
	        Long id = Long.parseLong(request.getParameter("id"));
	        Etudiant existingEtudiant = ime.listOne(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("AddNewStudent.jsp");
	        request.setAttribute("etudiant", existingEtudiant);
	        dispatcher.forward(request, response);

	    }

	    private void insert(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException {
	    	String nom = request.getParameter("nom");
	        String prenom = request.getParameter("prenom");
	       
	        Etudiant newEtudiant = new Etudiant(nom,prenom);
	        ime.save(newEtudiant);
	        response.sendRedirect("list");
	    }

	    private void update(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException {
	        Long id = Long.parseLong(request.getParameter("id"));
	    	String nom = request.getParameter("nom");
	        String prenom = request.getParameter("prenom");
	      

	        Etudiant etudiant = new Etudiant(id,nom,prenom);
	        ime.update(etudiant);
	        response.sendRedirect("list");
	    }

	    private void delete(HttpServletRequest request, HttpServletResponse response)
	    throws SQLException, IOException {
	        Long id = Long.parseLong(request.getParameter("id"));
	        ime.delete(id);
	        response.sendRedirect("list");
	    }
}
