<%@ taglib uri="jakarta.tags.core" prefix="c" %> <%@ page language="java"
contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <h2>mybbs</h2>
    <c:forEach var="dto" items="${lists}">
      <div>
        ${dto.id} /${dto.writer} /
        <a href="/view?id=${dto.id}">${dto.title}</a> / ${dto.content}
      </div>
    </c:forEach>
  </body>
</html>
