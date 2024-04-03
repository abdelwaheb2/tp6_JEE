<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title> Modification des matieres</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
<div class="card-header">
Modification Matieres <span class="fw-bolder">${matiere.labelle}</span>
</div>
<div class="card-body">
<form action="updateMat" method="post" >
<div class="form-group" >
<label  class="control-label">ID Matiere :</label>
<input readonly type="text" name="id"  class="form-control"
value="${matiere.id}"/>
</div>
<div class="form-group">
<label class="control-label">Labelle Matiere :</label>
<input type="text" name="labelle" class="form-control"
value="${matiere.labelle}"/>
</div>
<div class="form-group">
<label class="control-label">Coffetion Matiere : </label>
<input type="text" name="coffetion" class="form-control" value="${matiere.coffetion}"></input>
</div>
<div>
<button type="submit" class="btn btn-primary">Modifier</button>
</div>
</form>
</div>
</div>
</div>
</body>
</html>