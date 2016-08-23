<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.group.easyBuy.dto.*"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	@SuppressWarnings("unchecked")
	List<Goods> listGoods = (List<Goods>)request.getAttribute("listGoods");
	String[] colors = {"#DDDDDD", "#AAAAAA"};
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品种类</title>
</head>
<body>
	
	<table style="border:1; cellspacing=1; cellpadding=2; width=700; align=center">
    	<tr>
    		<td align="center" style="line-height:22px; ">&nbsp;</td>
			<td align="center" style="line-height:22px; ">商品种类&nbsp;</td>
			<td align="center" style="line-height:22px; ">单价&nbsp;</td>
			<td align="center" style="line-height:22px; ">折扣&nbsp;</td>
			<td align="center" style="line-height:22px; ">库存&nbsp;</td>
			<td align="center" style="line-height:22px; ">种类&nbsp;</td>
		</tr>
		
		
	<%
		if(listGoods != null){
			for(int i = 0; i < listGoods.size(); i++){
				Goods goodsTemp = (Goods)listGoods.get(i);
			
	%>
				<tr style='background:<%= colors[(i+1)%2] %>'>
			 		<td align="center">
						<img src="/easyBuy/assets/images/gift32.png" />
					</td>
					<td><%= goodsTemp.getGname() %></td>
					<td><%= goodsTemp.getPrice() %></td>
					<td><%= goodsTemp.getOffset() %></td>
					<td><%= goodsTemp.getStorage() %></td>
					<td><%= goodsTemp.getCategory().getCname() %></td>
					<td>
						<a href="#">审核</a>&nbsp;&nbsp;
						<a onclick="return confirm('确定删除该记录？')" href="/easyBuy/DeleteGoodsController?gname=<%= goodsTemp.getGname() %>">删除</a>
					</td>
				</tr>
	<%
			}
		}
	%>
	</table>
	
</body>
</html>