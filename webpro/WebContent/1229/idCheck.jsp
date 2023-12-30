<%@ page import="java.sql.*" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.PreparedStatement" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#sp1{
	color : red;
}
#sp2{
	color : blue;
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
	String sql = "SELECT * FROM MEMBER WHERE MEM_ID = ?";
	
	//실행 객체
	ps = conn.prepareStatement(sql);
	
	//실행문에 값 셋팅
	ps.setString(1, userId);
	
	//실행
	rs = ps.executeQuery();
	
	//실행결과 비교하기 - 사용가능 불가능 상태를 출력
	if (rs.next()){//true or false
		%>
	<p><span id="sp2"><%=userId %></span>는 <span id="sp1">불가능</span> 아이디 입니다.
<% 	}else{ %>
	<p><span id="sp2"><%=userId %></span>는 <span id="sp1">가능</span> 아이디 입니다.
<%	}
%>

  
</body>
</html>