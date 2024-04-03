<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
  <div class="card-header text-center fw-bolder text-primary">
    Modification l'examen
  </div>
  <div class="card-body">
      <form action="update.do" method="post" >
       <div class="form-group">
       <label class="control-label">ID :</label>
       <input type="text" name="id" readonly class="form-control" value="${examen.id }"/>
        </div>
        
      <div class="form-group">
		<select name="matiere" class="form-control">
		<option value="${examen.getMatieres().getId()}"
		selected>${examen.getMatieres().getLabelle()}</option>
		<c:forEach items="${matModel.getMat()}" var="m">
		<c:if test="${m.id != examen.getMatieres().getId()}">
		<option value="${m.id}">${m.labelle}</option>
		</c:if>
		</c:forEach>
		</select>
		</div>
      
      <div class="control-label">
       <label class="control-label">Etudient :</label>
       <input type="text" name="etudiant" class="form-control" value="${examen.etudiant }"/>
      </div>
      
      <div class="control-label">
       <label class="control-label">Note :</label>
       <input type="text" name="note" class="form-control" value="${examen.note }"/>
      </div>
      
      <div class="control-label">
       <label class="control-label">Dure :</label>
       <input type="text" name="dure" class="form-control" value="${examen.dure }"/>
      </div>
      
	      <div>
	        <button type="submit" class="btn btn-primary mt-5 w-100">Modifier</button>
	      </div>
      </form>     
  </div>
</div>
</div>
</body>
</html>