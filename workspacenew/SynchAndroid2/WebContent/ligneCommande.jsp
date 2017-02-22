<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<script src="resources/js/bootstrap.min.js"></script>
	<link href="resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<f:view>
		<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
			<img src="logo_salespro_transp.png"  class="pull-right"  width="200" height="50" style="background-color: #e3f2fd;">
			<ul class="nav nav-tabs">
	    		<li><a href="./commandes.jsp">Accueil</a></li>
	    		<li class="active"><a>${loginBean.roleLib}</a></li>
	    		<li><a href="./index.xhtml" >Deconnexion</a></li>
	    	</ul>
		</nav>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-12">
					<div class="row">
						<div class="col-md-6">
							<h:form id="forme" styleClass="form-horizontal" rendered="true">
								<fieldset>
									<!-- Form Name -->
									<legend>
										<c:out value="${loginBean.pageLigneLib}"></c:out>
									</legend>
									
									<!-- Text input-->
									<div class="form-group">
										<label class="col-md-4 control-label" for="idCommande">Id ligne commande</label>
										<div class="col-md-4">
											<h:inputText styleClass="form-control input-md" value="#{lignecommande.idLigneCommande}" disabled="true"></h:inputText>
										</div>
									</div>
									
									<!-- Text input-->
									<div class="form-group">
										<label class="col-md-4 control-label" for="produit">Produit</label>
										<div class="col-md-4">
											<h:inputText styleClass="form-control input-md" value="#{lignecommande.produit}"></h:inputText>
										</div>
									</div>
									
									<!-- Text input-->
									<div class="form-group">
										<label class="col-md-4 control-label" for="prix">Prix</label>
										<div class="col-md-4">
											<h:inputText styleClass="form-control input-md" value="#{lignecommande.prix}"></h:inputText>
										</div>
									</div>
									
									<!-- Text input-->
									<div class="form-group">
										<label class="col-md-4 control-label" for="quantite">Quantite</label>
										<div class="col-md-4">
											<h:inputText styleClass="form-control input-md" value="#{lignecommande.quantite}"></h:inputText>
										</div>
									</div>

									<!-- Button -->
									<div class="form-group">
										<label class="col-md-4 control-label" for="add"></label>
										<div class="col-md-4">
											<h:commandButton rendered="true" value="Valider" action="#{lignecommande.updateLigne}" />
										</div>
									</div>
								</fieldset>
							</h:form>
						</div>
					</div>
				</div>
			</div>
			<a href="./faces/commande.jsp" type="button" class="btn btn-primary">Retour</a>
		</div>
	</f:view>
</body>
</html>