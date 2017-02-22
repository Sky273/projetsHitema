<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Authentification</title>
<script src="resources/js/bootstrap.min.js"></script>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
 
<f:view>
<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
      
 <img src="logo_salespro_transp.png"  class="pull-right"  width="200" height="50" style="background-color: #e3f2fd;">
 
 <ul class="nav nav-tabs">
 	<li class="active"><a>Administration</a>/a></li>
	<li><a href="./index.xhtml" >Deconnexion</a></li>
</nav>

<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-6">
							<h:form id="forme" styleClass="form-horizontal" rendered="true">
								<fieldset>
		
									<!-- Form Name -->
									<legend>Ajouter Session</legend>
	
									<!-- Text input-->
									<div class="form-group">
										<label class="col-md-4 control-label" for="idUser">Id User</label>
										<div class="col-md-4">
											<h:inputText styleClass="form-control input-md" value="#{authentification.idUser}"></h:inputText>
										</div>
									</div>

									<!-- Text input-->
									<div class="form-group">
										<label class="col-md-4 control-label" for="nom">Nom</label>
										<div class="col-md-4">
											<h:inputText styleClass="form-control input-md" value="#{authentification.nom}">
												<f:convertDateTime pattern="yyyy-MM-dd"/>
											</h:inputText>
										</div>
									</div>
	
									<!-- Text input-->
									<div class="form-group">
										<label class="col-md-4 control-label" for="email">Email</label>
										<div class="col-md-4">
											<h:inputText styleClass="form-control input-md" value="#{authentification.email}"></h:inputText>
										</div>
									</div>

									<!-- Text input-->
									<div class="form-group">
										<label class="col-md-4 control-label" for="login">Login</label>
										<div class="col-md-4">
											<h:inputText styleClass="form-control input-md" value="#{authentification.login}"></h:inputText>
										</div>
									</div>

									<!-- Text input-->
									<div class="form-group">
										<label class="col-md-4 control-label" for="motdepasse">Mot De Passe</label>
										<div class="col-md-4">
											<h:inputText styleClass="form-control input-md" value="#{authentification.motDePasse}"></h:inputText>
										</div>
									</div>
									
									<!-- Text input-->
									<div class="form-group">
										<label class="col-md-4 control-label" for="role">Role</label>
										<div class="col-md-4">
											<h:inputText styleClass="form-control input-md" value="#{authentification.role}"></h:inputText>
										</div>
									</div>
									
										
									<!-- Button -->
									<div class="form-group">
										<label class="col-md-4 control-label" for="add"></label>
										<div class="col-md-4">
											<h:commandButton value="valider" action="#{authentification.saveAuthentification}" />
										</div>
									</div>
								</fieldset>
							</h:form>
						</div>
						<div class="col-md-6"></div>
					</div>
					<div class="row">
						<div class="col-md-12">
						<legend>Liste des Sessions</legend>
							<div class="table-responsive">
								<table id="example" class="table table-striped table-bordered">							
								<thead>
									<tr>
										<th>Id User</th>
										<th>Login</th>
										<th>Email</th>
										<th>Nom</th>
										<th>Mot De Passe</th>
										<th>Role</th>
										
										<th></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
 									<c:forEach var="auth" items="${authentification.getAllAuthentifications()}">
 										<tr>
 		    								<td><c:out value="${auth.idUser}"/></td>
 		    								<td><c:out value="${auth.login}"/></td>
 		    								<td><c:out value="${auth.email}"/></td>
 		    								<td><c:out value="${auth.motDePasse}"/></td>
 		    								<td><c:out value="${auth.nom}"/></td>
 		    								<td><c:out value="${auth.role}"/></td>
- 		    								<td><a href="../EditAuthentification?idUser=${auth.idUser}" type="button">Edit</a></td>
											<td><a href="../deleteAuthentification?idUser=${auth.idUser}"
												class="btn btn-danger" type="button">Delete</a></td>
 	    								</tr>
 									</c:forEach>
								</tbody>
							</table>
							</div>
						</div>
						<div class="col-md-6"></div>
					</div>
				</div>
			</div>
		</div>



</f:view>
</body>
</html>