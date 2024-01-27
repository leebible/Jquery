<%@page import="kr.or.ddit.buyer.service.BuyerServiceImpl"%>
<%@page import="kr.or.ddit.buyer.service.IBuyerService"%>
<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	
	String id = request.getParameter("id");
	
	//service 객체 얻기
	IBuyerService service = BuyerServiceImpl.getService();
	
	//service메소드 호출 - 결과값 - ProdVO
	BuyerVO bvo = service.selectById(id);
	
	//결과값을 request에 저장
	request.setAttribute("listt", bvo);
	
	//view페이지로 이동 - /0122/prodIdView.jsp
	request.getRequestDispatcher("/buyer/BuyerView2.jsp").forward(request, response);
%>

