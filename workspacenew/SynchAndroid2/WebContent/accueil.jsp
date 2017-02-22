<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:view>

	<h:outputText> <div class="row">
					<div class="col-md-6">
					<legend>Authentification List</legend>
						<div class="table-responsive">
							<table id="example" class="table table-striped table-bordered">							
							<thead>
								<tr>
									<th>idUser</th>
									<th>email</th>
									<th>login</th>
									<th>motDePasse</th>
								</tr>
							</thead>
							<tbody>


								<c:forEach items="${allAuthentification}" var="idUser">
									<tr>
										<td><c:out value="${Authentification.email}" /></td>
										<td><c:out value="${Authentification.login}" /></td>
										<td><c:out value="${Authentification.motDePasse}" /></td>
										<td><a href="employeeController?employeeId=${Authentification.idUser}"
											class="btn btn-danger" type="button">Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						</div>
					</div>
					<div class="col-md-6"></div>
				</div> </h:outputText>


</f:view>
</body>
</html>