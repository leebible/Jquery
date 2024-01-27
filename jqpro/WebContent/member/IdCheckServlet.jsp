<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
//여기는 서블릿 controller이다 - 

//요청시 전송 데이터 받기 (직렬화 X인상태)
//String memId = request.getParameter("id");

//요청시 전송데이터 받기 (직렬화 O인상태)
	StringBuffer buf = new StringBuffer();
	String line = null;
	
	BufferedReader reader = request.getReader();
	while((line = reader.readLine()) !=null){
		buf.append(line);
	};
	//한줄이면 line = reader.readLine()<-얘만 있어도 됨.
			
	String reqdata = buf.toString(); //{"mem_id : "korea"};
	//역직렬화 - 객체 형태로 변환
	Gson gson = new Gson();
	MemberVO vo = gson.fromJson(reqdata, MemberVO.class);
	//vo.setMem_id("korea")
	
	String memId = vo.getMem_id();
	
	//service객체 얻기
	IMemberService service = MemberServiceImpl.getService();
	
	//service메소드 호출 - 결과값 받기
	String res = service.selectById(memId);
	
	//결과값을 request에 저장
	request.setAttribute("res", res);
	
	//view페이지로 이동
	request.getRequestDispatcher("/member/idView.jsp").forward(request, response); //변수이름 바꾸면 안됨



%>
