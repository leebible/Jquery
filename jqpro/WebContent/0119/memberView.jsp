<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//controller에서 저장한 데이터 꺼내기
List<MemberVO> list = (List<MemberVO>)request.getAttribute("listval");

//출력 - json


%>
[ 

	<%
	for(int i=0;i<list.size(); i++){
		MemberVO vo = list.get(i);
		if(i > 0){
			out.print(",");
		}
	%>
		{
			"mem_id" : "<%= vo.getMEM_ID()%>",	
			"mem_name" :"<%= vo.getMEM_NAME()%>",	
			"mem_hp" :"<%= vo.getMEM_HP()%>"	
		}

	<% 	
	}
	%>
]