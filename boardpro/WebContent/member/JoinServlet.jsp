<%@page import="kr.or.ddit.member.service.IMemberService"%>
<%@page import="kr.or.ddit.member.service.MemberServiceImpl"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.io.BufferedReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
 //controller servlet이다
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
	
	//service 객체 얻어오기
	IMemberService service = MemberServiceImpl.getService();
	
	//service 메소드 호출 - 결과값 받기
	int res = service.insertMember(vo);
	
	//결과값을 request에 저장
	request.setAttribute("MVO", res);
	
	//view 페이지로 이동
	request.getRequestDispatcher("/member/joinView.jsp").forward(request, response); 
%>
