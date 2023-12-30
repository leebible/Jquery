<%@ page import="java.sql.*" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	width : 100%;
}
td{
	border-color : skyblue;
	text-align : center;
}
</style>
</head>
<body>
<%!
private Connection conn = null;
private ResultSet rs = null;
private PreparedStatement ps = null;
private String driver = "oracle.jdbc.driver.OracleDriver";
private String url = "jdbc:oracle:thin:@localhost:1521:xe";
private String user = "LSK95";
private String password = "java";

%>


<%
	request.setCharacterEncoding("UTF-8");
	//입력한 id값을 가져온다.
	String userId = request.getParameter("id");

	//OracleDriver클래스를 로드시킨다.
	 Class.forName(driver);
	//db연결객체
	 conn = DriverManager.getConnection(url, user, password);
	
	//sql쿼리문 작성
	String sql = "select MEM_ID, MEM_NAME, MEM_HP from member";
	
	//실행 객체
	ps = conn.prepareStatement(sql);
	
	//실행
	rs = ps.executeQuery();
	
	%>
	<table border="1">
<tr>
    <th>아이디</th>
    <th>이름</th>
    <th>전화번호</th>
    </tr>
<% 
	while (rs.next()){
		String memId = rs.getString("MEM_ID");
		String memName = rs.getString("MEM_NAME");
		String memHp = rs.getString("MEM_HP");
	%>

<tr>
    <td><%= memId %></td>
    <td><%= memName %></td>
    <td><%= memHp %></td>
</tr>
<% } %>
</table>

</body>
</html>