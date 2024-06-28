<%@ taglib uri="jakarta.tags.core" prefix="c" %> <%@ page language="java"
contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <h2>join</h2>
    <c:forEach var="dto" items="${order1}">
      <div>
        ${dto.ono1} /${dto.cname1} /${dto.cjob1}
       
      </div>
    </c:forEach>

  </body>
</html>
