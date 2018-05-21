<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Entry Page</title>
<style type="text/css">
.errorsBg{
	background-color:#fdd;
	color:red;	
	border: 1px solid;
}

.errorMessage{
	padding:0px 8px;
}

table{
	border-spacing: 4px;
}
td{
	padding:4px;
}

table,th,td
{
border:1px solid black;
}

</style>
</head>
<body>


<form action="addEnv" method="POST">

<c:if test="${requestScope.errorMessage ne null }">
<c:out value="${requestScope.errorMessage}" escapeXml="true"></c:out>
</c:if>
<br><br>

<table>
<thead>Add Environment</thead>
<tbody>
<tr> <th>ID</th><TH> <Input type="text" Name="id"></TH> </TR>
<tr> <th>OS</th><TH> <Input type="text" Name="os"></TH> </TR>
<tr> <th>Version</th><TH> <Input type="text" Name="version"></TH> </TR>
<tr> <th>Notes</th><TH> <Input type="text" Name="notes"></TH> </TR>
<tr><th colspan="2"> <Input type="Submit" value="Submit" ></th></tr>
</tbody>
</table>





</form>

</body>
</html>