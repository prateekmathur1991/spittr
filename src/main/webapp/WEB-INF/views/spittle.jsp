<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Spittr</title>
	</head>

	<body>
		<h1>Spittle</h1>
		
		<div class="spittleView">
			<div class="spittleMessage"><c:out value="${spittle.message}" /></div>
			<div>
				<span class="spittleTime"><c:out value="${spittle.time}" /></span>
			</div>
		</div>
	</body>
</html>