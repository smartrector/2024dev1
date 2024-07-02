<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    out.println("Spring JPA #01 - Select All");
%>
<br>

<c:forEach items="${members}" var="member">
아이디 : ${member.id}<br>
이름 : ${member.username}<br>
날짜 : ${member.createDate}
<hr>	
</c:forEach>

</body>
</html>