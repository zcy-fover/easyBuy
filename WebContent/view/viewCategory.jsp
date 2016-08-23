<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.group.easyBuy.dto.*"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	@SuppressWarnings("unchecked")
	List<Category> listCategory = (List<Category>)request.getAttribute("listCategory");
	String[] colors = {"#DDDDDD", "#AAAAAA"};
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table style="border:1; cellspacing=1; cellpadding=2; width=700; align=center">
    	<tr>
    		<td align="center" style="line-height:22px; ">&nbsp;</td>
			<td align="center" style="line-height:22px; ">种类名称&nbsp;</td>
			<td align="center" style="line-height:22px; ">简介&nbsp;</td>
		</tr>
		
		
	<%
		if(listCategory != null){
			for(int i = 0; i < listCategory.size(); i++){
				Category categoryTemp = (Category)listCategory.get(i);
			
	%>
				<tr style='background:<%= colors[(i+1)%2] %>'>
			 		<td align="center">
						<img src="/easyBuy/assets/images/34.png" />
					</td>
					<td><%= categoryTemp.getCname() %></td>
					<td><%= categoryTemp.getSummary() %></td>
					<td>
						<a href="#">审核</a>&nbsp;&nbsp;
						<a onclick="return confirm('确定删除该记录？')" href="/easyBuy/CategoryController?method=deleteCategory&cname=<%= categoryTemp.getCname() %>">删除</a>
					</td>
				</tr>
	<%
			}
		}
	%>
	</table>

</body>
</html>