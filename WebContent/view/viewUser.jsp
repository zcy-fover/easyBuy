<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.group.easyBuy.dto.*"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) request.getAttribute("listUser");
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
			<td align="center" style="line-height:22px; ">用户姓名&nbsp;</td>
			<td align="center" style="line-height:22px; ">手机号&nbsp;</td>
			<td align="center" style="line-height:22px; ">地址&nbsp;</td>
			<td align="center" style="line-height:22px; ">操作&nbsp;</td>
		</tr>
		
		<%-- <c:forEach var="user" items="${ listUser }">
			<tr>${ user.username }</tr>
			<tr>${ user.phone }</tr>
			<tr>${ user.address }</tr>
			<tr>操作</tr>
		</c:forEach> --%>
		
	<%
		if(listUser != null){
			for(User userTemp: listUser){
				/* User userTemp = (User)listUser.get(i); */
			
	%>
				<tr style='background:<%= colors[0] %>'>
			 		<td align="center">
						<img src="/easyBuy/assets/images/user.png" />
					</td>
					<td><%= userTemp.getUsername() %></td>
					<td><%= userTemp.getPhone() %></td>
					<td><%= userTemp.getAddress() %></td>
					<td>
						<a href="#">审核</a>&nbsp;&nbsp;
						<a onclick="return confirm('确定删除该记录？')" href="/easyBuy/DeleteUserController?username=<%= userTemp.getUsername() %>">删除</a>
					</td>
				</tr>
	<%
			}
		}
	%>
	</table>
</body>
</html>