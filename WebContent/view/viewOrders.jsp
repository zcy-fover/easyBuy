<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.group.easyBuy.dto.*"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	@SuppressWarnings("unchecked")
	List<Orders> listOrders = (List<Orders>)request.getAttribute("listOrders");
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
			<td align="center" style="line-height:22px; ">订单号&nbsp;</td>
			<td align="center" style="line-height:22px; ">数量&nbsp;</td>
			<td align="center" style="line-height:22px; ">状态&nbsp;</td>
			<td align="center" style="line-height:22px; ">商品名&nbsp;</td>
			<td align="center" style="line-height:22px; ">用户&nbsp;</td>
			<td align="center" style="line-height:22px; ">总价&nbsp;</td>
		</tr>
		
		
	<%
		if(listOrders != null){
			for(int i = 0; i < listOrders.size(); i++){
				Orders ordersTemp = (Orders)listOrders.get(i);
			
	%>
				<tr style='background:<%= colors[(i+1)%2] %>'>
			 		<td align="center">
						<img src="/easyBuy/assets/images/order.jpg" />
					</td>
					<td><%= ordersTemp.getOrderNo() %></td>
					<td><%= ordersTemp.getCount() %></td>
					<td>
						<%
							if(ordersTemp.getState() == 1){
						%>
								<a href="#">待审核</a>&nbsp;&nbsp;
						<% 
							}else{
						%>		
								审核通过
						<%
							} 
						%>
					</td>
					<td><%= ordersTemp.getGoods().getGname() %></td>
					<td><%= ordersTemp.getUser().getUsername() %></td>
					<td><%= ordersTemp.getTotalPrice() %></td>
					<td>
						<a onclick="return confirm('确定删除该记录？')" href="/easyBuy/OrdersController?gname=<%= ordersTemp.getOrderNo() %>">删除</a>
					</td>
				</tr>
	<%
			}
		}
	%>
	</table>
</body>
</html>