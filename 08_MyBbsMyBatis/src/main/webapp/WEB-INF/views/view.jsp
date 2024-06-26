<%@ taglib uri="jakarta.tags.core" prefix="c" %> <%@ page language="java"
contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Insert title here</title>
  </head>
  <body>
    <h2> mybbs 내용보기</h2>
    작성자 : ${dto.writer}<br>
    제목 : ${dto.title}<br>
    내용 : ${dto.content}<br>
    
    <a href="/list">목록</a>
    
  </body>
</html>