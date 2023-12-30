<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

table{
	border : 7px solid skyblue;
	padding : 10px;
	border-spacing : 20px;
	}
td{
	width : 65px;
	height : 50px;
	text-align : center;
	border-bottom : 1px solid skyblue;
	margin : 50px;
}
	</style>
</head>
<body>

<%
request.setCharacterEncoding("UTF-8");

String r = request.getParameter("dan");
int dan = Integer.parseInt(r);

String str = "<table>";
for(int i=1; i<10; i++){
     str += "<tr>" +"<td>"+ dan +"</td>" +
 		 "<td>" + "*" + "</td>"+
 		 "<td>" + i + "</td>" +
 		 "<td>" + "=" + "</td>" +
 		 "<td>" + (dan*i) + "</td>" + "</tr>";
 }
str += "</table>";
%>

<br>
<%= str %>


</body>
</html>