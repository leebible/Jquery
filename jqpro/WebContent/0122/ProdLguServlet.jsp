<%@page import="com.google.gson.Gson"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.prod.service.ProdServiceImpl"%>
<%@page import="kr.or.ddit.prod.service.IProdService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//요청시 전송데이터 받기 "gu=P101"일때 가능
	//String lgu = request.getParameter("gu");
	
	//JSON.stringify({"prod_lgu" : guvalue}) 형식의 직렬화 데이터
	StringBuffer buf = new StringBuffer();
	String line = null;
	
	BufferedReader reader = request.getReader();

	while((line = reader.readLine()) !=null){
		buf.append(line);
	};
	
	//한줄이면 line = reader.readLine()<-얘만 있어도 됨.
	
	
	String reqdata = buf.toString(); //{"prod_lgu : "P101"};
	//역직렬화 - 객체 형태로 변환
	Gson gson = new Gson();
	ProdVO vo = gson.fromJson(reqdata, ProdVO.class);
	//vo.setprod_lgu("P101");
	
	String lgu = vo.getProd_lgu(); 
	

	//service객체 얻기
	IProdService service = ProdServiceImpl.getService();

	//service메소드 호출 - 결과값 받기 - List<LprodVO>
	List<ProdVO> list = service.selectByLgu(lgu);

	//결과값을 request에 저장
	//setAttribute("name", value);
	request.setAttribute("listval", list);
	
	//view페이지로 이동 - forward - lprodView.jsp
	request.getRequestDispatcher("/0122/ProdView.jsp").forward(request, response);
	//
%>
