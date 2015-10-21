<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form method="POST" action="persist">
    <input type="submit" value="persist" />
  </form>
  <form method="POST" action="queryObject">
    <input type="submit" value="query object" />
  </form>
  <form method="POST" action="queryText">
    <input type="submit" value="query as text" />
  </form>
  id = <%= session.getAttribute("id") %><br>
  obj = <%= session.getAttribute("person") %>
</body>
</html>
