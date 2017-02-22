<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Commandes</title>
<script src="resources/js/bootstrap.min.js"></script>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<f:view>
		<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
			<img src="logo_salespro_transp.png"  class="pull-right"  width="200" height="50" style="background-color: #e3f2fd;">
			<ul class="nav nav-tabs">
	    		<li><a href="./commandes.jsp">Accueil</a></li>
	    		<li class="active"><a ><c:out value="${loginBean.roleLib}" /></a></li>
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
									<legend><c:out value="${loginBean.pageLib}"></c:out></legend>
	
									<!-- Text input-->
									<div class="form-group">
										<label class="col-md-4 control-label" for="idCommande">Id commande</label>
										<div class="col-md-4">
											<h:inputText styleClass="form-control input-md" value="#{commande.idCommande}" disabled="true"></h:inputText>
										</div>
									</div>

									<!-- Text input-->
									<div class="form-group">
										<label class="col-md-4 control-label" for="dateCommande">Date commande</label>
										<div class="col-md-4">
											<h:inputText styleClass="form-control input-md" value="#{commande.dateCommande}">
												<f:convertDateTime pattern="yyyy-MM-dd"/>
											</h:inputText>
										</div>
									</div>
	
									<!-- Text input-->
									<div class="form-group">
										<label class="col-md-4 control-label" for="adrLivraison">Client</label>
										<div class="col-md-4">
											<h:inputText styleClass="form-control input-md" value="#{commande.client}"></h:inputText>
										</div>
									</div>

									<!-- Text input-->
									<div class="form-group">
										<label class="col-md-4 control-label" for="adrLivraison">Adresse livraison</label>
										<div class="col-md-4">
											<h:inputText styleClass="form-control input-md" value="#{commande.adrLivraison}"></h:inputText>
										</div>
									</div>

									<!-- Text input-->
									<div class="form-group">
										<label class="col-md-4 control-label" for="adrLivraison">Statut commande</label>
										<div class="col-md-4">
											<h:selectOneMenu id="statutCommande" value="#{commande.statutCommande}" rendered="true" disabled="#{loginBean.role != 0?'true':'false'}" style="width:185px">
           										<f:selectItem itemLabel="Nouvelle"  itemValue="Nouvelle" />
            									<f:selectItem itemLabel="Passee"   itemValue="Passee" />
        									</h:selectOneMenu>
										</div>
									</div>
									
									<!-- Text input-->
									<div class="form-group">
										<label class="col-md-4 control-label" for="adrLivraison">Statut paiement</label>
										<div class="col-md-4">
											<h:selectOneMenu id="statutPaiement" value="#{commande.statutPaiement}" rendered="true" disabled="#{loginBean.role != 1?'true':'false'}" style="width:185px">
           										<f:selectItem itemLabel="Non Payee"  itemValue="Nouvelle" />
            									<f:selectItem itemLabel="Payee"   itemValue="Passee" />
        									</h:selectOneMenu>
										</div>
									</div>
									
									<!-- Text input-->
									<div class="form-group">
										<label class="col-md-4 control-label" for="adrLivraison">Statut livraison</label>
										<div class="col-md-4">
											<h:selectOneMenu id="statutLivraison" value="#{commande.statutLivraison}" rendered="true" disabled="#{loginBean.role != 2?'true':'false'}" style="width:185px">
           										<f:selectItem itemLabel="Non Livree"  itemValue="Nouvelle" />
            									<f:selectItem itemLabel="Livree"   itemValue="Passee" />
        									</h:selectOneMenu>
										</div>
									</div>
	
									<!-- Button -->
									<div class="form-group">
										<label class="col-md-4 control-label" for="add"></label>
										<div class="col-md-4">
											<h:commandButton value="valider" action="#{commande.updateCommande}" />
										</div>
									</div>
								</fieldset>
							</h:form>
						</div>
						<div class="col-md-6"></div>
					</div>
					<div class="row">
						<div class="col-md-12">
						<legend><c:out value="${loginBean.pageLigneLibs}"></c:out></legend>
							<div class="table-responsive">
								<table id="example" class="table table-striped table-bordered">							
								<thead>
									<tr>
										<th>Id ligne commande</th>
										<th>Produit</th>
										<th>Quantité</th>
										<th>Prix</th>
										<th></th>
										<th></th>
										<th></th>
									</tr>
								</thead>
								<tbody>
 									<c:forEach var="ligne" items="${commande.getLignecommandes()}">
 										<tr>
 		    								<td><c:out value="${ligne.idLigneCommande}"/></td>
 		    								<td><c:out value="${ligne.produit}"/></td>
 		    								<td><c:out value="${ligne.quantite}"/></td>
 		    								<td><c:out value="${ligne.prix}"/></td>
											<td><a href="../EditLigneCommande?idLigneCommande=${ligne.idLigneCommande}" type="button"  class="btn btn-primary">Edit</a></td>
											<td><a href="../deleteLigneCommande?idLigneCommande=${ligne.idLigneCommande}" class="btn btn-danger" type="button">Delete</a></td>
											<td><a onclick="alert('fonctionnalite non encore implémentée !');" class="btn btn-primary">Imprimer</a> </td>
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
			<a href="../CreateLigneCommande" type="button"  class="btn btn-primary">Ajouter <c:out value="${loginBean.pageLigneLib}" /></a>
			<a href="../ViewCommandes" type="button" class="btn btn-primary">Retour</a>
		</div>
	</f:view>
</body>
</html>