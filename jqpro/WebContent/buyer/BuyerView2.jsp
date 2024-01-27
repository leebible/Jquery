<%@page import="kr.or.ddit.buyer.vo.BuyerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//controller에서 저장한 데이터 꺼내기
//결과값의 타입 변수명 = request.getAttribute("name")
BuyerVO vo = (BuyerVO)request.getAttribute("listt");
//변수명을 이용하여 json형식의 배열 데이터를 생성
%>


		{
			"buyer_id" : "<%= vo.getBuyer_id() %>",
			"buyer_name" : "<%= vo.getBuyer_name() %>"	,
			"buyer_lgu" : "<%= vo.getBuyer_lgu() %>"	,
			"buyer_bank" : "<%= vo.getBuyer_bank() %>"	,
			"buyer_bankno" : "<%= vo.getBuyer_bankno() %>"	,
			"buyer_bankname" : "<%= vo.getBuyer_bankname() %>"	,
			"buyer_zip" : "<%= vo.getBuyer_zip() %>"	,
			"buyer_add1" : "<%= vo.getBuyer_add1() %>"	,
			"buyer_add2" : "<%= vo.getBuyer_add2() %>"	,
			"buyer_comtel" : "<%= vo.getBuyer_comtel() %>"	,
			"buyer_mail" : "<%= vo.getBuyer_mail() %>"	
		}



