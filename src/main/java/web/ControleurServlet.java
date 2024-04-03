package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.Iexamen;
import dao.Imatieres;
import dao.Examen_Impl;
import dao.Matieres_Impl;
import model.Examen;
import model.Matieres;

@SuppressWarnings("serial")
@WebServlet (name="cs",urlPatterns= {"/controleur","*.do"})
public class ControleurServlet extends HttpServlet {
	
	 Iexamen exam;
	 Imatieres mati;
	 @Override
	public void init() throws ServletException {
		exam = new Examen_Impl();
		mati = new Matieres_Impl();
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			             HttpServletResponse response) 
			            throws ServletException, IOException {
		String path=request.getServletPath();
		if (path.equals("/index.do"))
		{
			ExamenModele model= new ExamenModele(); 
			model.setMotCle("");
			List<Examen> exams = exam.ExamensParMC("");
			model.setExamens(exams);
			request.setAttribute("model", model);
			request.getRequestDispatcher("examens.jsp").forward(request,response);
		}
		else if (path.equals("/chercher.do"))
		{
			String motCle=request.getParameter("motCle");
			ExamenModele model= new ExamenModele(); 
			model.setMotCle(motCle);
			List<Examen> exams = exam.ExamensParMC(motCle);
			model.setExamens(exams);
			request.setAttribute("model", model);
			request.getRequestDispatcher("examens.jsp").forward(request,response);
		}
		else if (path.equals("/saisie.do")  )
		{
			List<Matieres> matis = mati.getAll();
			Matieremodel model= new Matieremodel();
			model.setMatieres(matis);
			request.setAttribute("MatModel", model);
			request.getRequestDispatcher("saisieExamen.jsp").forward(request,response);
		}
		else if (path.equals("/save.do")  && request.getMethod().equals("POST"))
		{
			String etudiant=request.getParameter("etudiant");
			Long matiId=Long.parseLong(request.getParameter("matiere"));
			double dure = Double.parseDouble(request.getParameter("dure"));
			double note = Double.parseDouble(request.getParameter("note"));
			Matieres mat =mati.getmatiere(matiId);
			exam.save(new Examen( mat, note, etudiant, dure));
			response.sendRedirect("index.do");
			
		}
		else if (path.equals("/supprimer.do"))
		{
		    Long id= Long.parseLong(request.getParameter("id"));
		    exam.deleteExamen(id);
		    response.sendRedirect("chercher.do?motCle=");
					
			//request.getRequestDispatcher("confirmation.jsp").forward(request,response);
		}
		else if (path.equals("/editer.do")  )
		{
			List<Matieres> mats =mati.getAll();
			Matieremodel model= new Matieremodel();
			model.setMatieres(mats);
			request.setAttribute("matModel", model);
			
			Long id= Long.parseLong(request.getParameter("id"));
		    Examen e = exam.getExamen(id);
		    request.setAttribute("examen", e);
			request.getRequestDispatcher("editerExamen.jsp").forward(request,response);
		}
		else if (path.equals("/update.do")  )
		{
			 Long id = Long.parseLong(request.getParameter("id"));
			 Long matid= Long.parseLong(request.getParameter("matiere"));
			double note = Double.parseDouble(request.getParameter("note"));
			String etudiant=request.getParameter("etudiant");
			double dure = Double.parseDouble(request.getParameter("dure"));
			 Examen e = new Examen();
			 e.setId(id);
			e.setDure(dure);
			e.setEtudiant(etudiant);
			e.setNote(note);
			Matieres mat = mati.getmatiere(matid);
			e.setMatieres(mat);
			 exam.updateExamen(e);
			 response.sendRedirect("chercher.do?motCle=");
		}
		else
		{
			response.sendError(Response.SC_NOT_FOUND);		
		}	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}