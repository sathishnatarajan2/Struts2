<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
</style>
</head>
<body>

Add Environment
<s:form action="addEnv">
	<s:textfield label="OS" key="os"></s:textfield> 
	<s:textfield label="OS Version" key="version"></s:textfield>
	<s:textarea label="Notes" key="notes"></s:textarea>
	<s:submit />
</s:form>

</body>
</html>