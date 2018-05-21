<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="environment" type="java.util.List<com.sathish.charlotte.Environment>" scope="request"/>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results Page</title>

<style>
table,th,td
{
border:1px solid black;
}
</style>

</head>
<body>

<c:if test="${requestScope.errorMessage ne null }">
<c:out value="${requestScope.errorMessage}" escapeXml="true"></c:out>
</c:if>
<br><br>



<table > <tHead> Results Page</thead>
<tbody>
<tr> <td>Id</td> <td>OS</td> <td>Version</td> <td>Notes</td> </tr>



	<c:forEach items="${environment}" var="env">
	<tr>

		<td>${env.id}</td>
		<td>${env.os}</td>
		<td>${env.version}</td>
		<td>${env.notes}</td>

	</tr>
	</c:forEach>

</tbody>		
</table>
</body>
</html>