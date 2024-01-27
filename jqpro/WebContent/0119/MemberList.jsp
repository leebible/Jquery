<!-- Controller (원래는 servlet으로 해야하지만, 아직 안배워서 JSP파일로.) -->

<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//Controller역할 - Servlet, Spring, JSP 
	
	//클라이언트 전송시  데이터 받기
	
	//service객체 얻기
	IMemberService service = MemberServiceImpl.getService();
	
	//service메소드 호출 - 결과값 받기
	List<MemberVO> list = service.getAllMember();
	
	
	//결과값을 request에 저장
	request.setAttribute("listval", list);
	
	//결과값을 출력 - VIEW 페이지로 이동
	//결과값을 공유 - 
	request.getRequestDispatcher("/0119/memberView.jsp").forward(request, response); //하나의 request와 response를..
	
	
//리다이렉트포워드..개념 정리과제?

%>
</body>
</html>