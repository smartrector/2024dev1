<%@ taglib uri="jakarta.tags.core" prefix="c" %> <%@ page language="java"
contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>writer</title>
  </head>
  <body>
    <h2>mybbs writer</h2>
    <form action="write" method="post">
      <table width="400" cellpadding="0" cellspacing="0" border="1">
        <tr>
          <td>작성자</td>
          <td><input type="text" name="writer" /></td>
        </tr>
        <tr>
          <td>제목</td>
          <td><input type="text" name="title" /></td>
        </tr>
        <tr>
          <td>내용</td>
          <td><input type="text" name="content" /></td>
        </tr>
      </table>
      <input type="submit" value="입력" />
    </form>
  </body>
</html>
