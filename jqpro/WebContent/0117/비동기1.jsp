<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSP : Java Server Page</h1>
<%
	request.setCharacterEncoding("UTF-8");

String userName = request.getParameter("name");
String userId = request.getParameter("id");


/* 
여기서 테이블을 만들수도 있음!
out.print("<table border='1'>");
out.print("<tr>");
out.print("<td>아이디</td>");
out.print("<td>"+userId+"</td></tr></table>");
 */

%>

<table border="1">
	<tr>
		<td>아이디</td>
		<td><%= userId %></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><%= userName %></td>
	</tr>
</table> 

</body>
</html>