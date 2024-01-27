<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//controller에서 저장한 데이터 꺼내기
//결과값의 타입 변수명 = request.getAttribute("name")
ProdVO vo = (ProdVO)request.getAttribute("listval");
//변수명을 이용하여 json형식의 배열 데이터를 생성
%>


		{
			"prod_id" : "<%= vo.getProd_id() %>",	
			"prod_nm" : "<%= vo.getProd_name() %>"	,
			"prod_lgu" : "<%= vo.getProd_lgu() %>"	,
			"prod_buyer" : "<%= vo.getProd_buyer() %>"	,
			"prod_cost" : "<%= vo.getProd_cost() %>"	,
			"prod_price" : "<%= vo.getProd_price() %>"	,
			"prod_sale" : "<%= vo.getProd_sale() %>"	
		}



