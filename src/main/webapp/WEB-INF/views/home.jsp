<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Spittr</title>
	</head>

	<body>
		<h1>Welcome to Spittr</h1>
		
		<a href='<c:url value="/spittles" />'>Spittles</a> |
		<a href="<c:url value="/spittles/register" />">Register</a>
	</body>
</html>