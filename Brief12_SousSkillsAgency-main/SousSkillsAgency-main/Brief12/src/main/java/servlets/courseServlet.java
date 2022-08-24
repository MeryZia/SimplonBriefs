package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Cours;
import models.Etudiant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;

import DaoImpl.ImplCours;
import DaoImpl.ImplEtudiant;

@WebServlet("/")
public class courseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		    private ImplCours imc=new ImplCours();

		    public void init() {
		    	imc = new ImplCours();
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
		    	
		        List < Cours > listCours = imc.listAll();
		        System.out.println(listCours);
		        request.setAttribute("listCours", listCours);
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
		        Cours existingCours = imc.listOne(id);
		        RequestDispatcher dispatcher = request.getRequestDispatcher("AddNewStudent.jsp");
		        request.setAttribute("cours", existingCours);
		        dispatcher.forward(request, response);

		    }

		    private void insert(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		    	String dateCours = request.getParameter("dateCours");
		        String descripton = request.getParameter("descripton");
		       
		        Cours newCours = new Cours(dateCours,descripton);
		        imc.save(newCours);
		        response.sendRedirect("list");
		    }

		    private void update(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        Long id = Long.parseLong(request.getParameter("id"));
		        String dateCours = request.getParameter("dateCours");
		        String descripton = request.getParameter("descripton");
		      

		        Cours cours = new Cours(id,dateCours,descripton);
		        imc.update(cours);
		        response.sendRedirect("list");
		    }

		    private void delete(HttpServletRequest request, HttpServletResponse response)
		    throws SQLException, IOException {
		        Long id = Long.parseLong(request.getParameter("id"));
		        imc.delete(id);
		        response.sendRedirect("list");
		    }

}
