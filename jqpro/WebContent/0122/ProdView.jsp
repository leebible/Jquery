
<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//controller에서 저장한 데이터 꺼내기
//결과값의 타입 변수명 = request.getAttribute("name")
List<ProdVO> list = (List<ProdVO>)request.getAttribute("listval");
//변수명을 이용하여 json형식의 배열 데이터를 생성

if(list!=null && list.size()>0){
	
%>
{
	"flag"  : "ok",
	"datas" : 
[ 

	<%
	for(int i=0;i<list.size(); i++){
		ProdVO vo = list.get(i);
		if(i > 0){
			out.print(",");
		}
	%>
		{
			"prod_id" : "<%= vo.getProd_id() %>",	
			"prod_nm" : "<%= vo.getProd_name() %>"	
		}

	<% 	
	}
	%>
]
} 
<% }else{ %>

	{
		"flag" : "no"
	}

<%
}
%>
