<%@page import="kr.or.ddit.buyer.service.IBuyerService"%>
<%@page import="kr.or.ddit.buyer.service.BuyerServiceImpl"%>
<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.prod.service.ProdServiceImpl"%>
<%@page import="kr.or.ddit.prod.service.IProdService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	

	//service객체 얻기
	IBuyerService service = BuyerServiceImpl.getService();

	//service메소드 호출 - 결과값 받기 - List<LprodVO>
	List<BuyerVO> list = service.selectByName();
	//결과값을 request에 저장
	//setAttribute("name", value);
	request.setAttribute("listval", list);
	
	//view페이지로 이동 - forward - lprodView.jsp
	request.getRequestDispatcher("/buyer/BuyerView.jsp").forward(request, response);
	//
%>
