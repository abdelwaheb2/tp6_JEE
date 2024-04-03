package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import dao.Matieres_Impl;
import dao.Imatieres;
import model.Matieres;

@SuppressWarnings("serial")
@WebServlet (name="matis",urlPatterns= {"/Matieres","/saisieMat","/saveMat","/supprimerMat","/editerMat","/updateMat"})
public class MatiereServlete extends HttpServlet {
	Imatieres metier;
@Override
public void init() throws ServletException {
metier = new Matieres_Impl();
}
@Override
protected void doGet(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
String path=request.getServletPath();
if (path.equals("/Matieres"))
{
Matieremodel model= new Matieremodel();
List<Matieres> Mats = metier.getAll();
model.setMatieres(Mats);
request.setAttribute("model", model);
request.getRequestDispatcher("Matieres.jsp").forward(request,response);
}
else if (path.equals("/saisieMat") )
{
request.getRequestDispatcher("saisieMatieres.jsp").forward(request,response);
}
else if (path.equals("/saveMat") && request.getMethod().equals("POST"))
{
String labelle=request.getParameter("labelle");
Double coffetion =Double.parseDouble( request.getParameter("coffetion"));
System.out.println(coffetion);
metier.save(new Matieres(coffetion,labelle));
response.sendRedirect("Matieres");
}
else if (path.equals("/supprimerMat"))
{
Long id= Long.parseLong(request.getParameter("id"));
metier.deletematiere(id);
response.sendRedirect("Matieres");
}
else if (path.equals("/editerMat") )
{
Long id= Long.parseLong(request.getParameter("id"));
Matieres mat = metier.getmatiere(id);
request.setAttribute("matiere", mat);
request.getRequestDispatcher("editerMatiere.jsp").forward(request,response);
}
else if (path.equals("/updateMat") )
{
Long id = Long.parseLong(request.getParameter("id"));
String nom=request.getParameter("labelle");
Double cof =Double.parseDouble( request.getParameter("coffetion"));
Matieres mat = new Matieres();
mat.setId(id);
mat.setLabelle(nom);
mat.setCoffetion(cof);
metier.updatematiere(mat);
response.sendRedirect("Matieres");
}
else
{
response.sendError(Response.SC_NOT_FOUND);
}
}
@Override
protected void doPost(HttpServletRequest request,

HttpServletResponse response) throws

ServletException, IOException {
doGet(request,response);
}
}