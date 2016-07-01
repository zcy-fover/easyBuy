<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.group.easyBuy.dto.*" %>
<%
	String admin = (String)request.getAttribute("admin");
%>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台模板管理系统</title>
<link type="text/css" rel="stylesheet" href="assets/css/style2.css" />
<script type="text/javascript" src="assets/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="assets/js/menu.js"></script>
</head>

<body>
	<div class="top"></div>
	<div id="header">
		<div class="logo">易购商城后台管理系统</div>
		<div class="navigation">
			<ul>
				<li>欢迎您！</li>
				<li><a href="#" id="admin"><%= admin %></a></li>
				<li><a href="#" id="editPass">修改密码</a></li>
				<!-- <li><a href="">设置</a></li> -->
				<li><a href="/easyBuy/LoginoutController">退出</a></li>
			</ul>
		</div>
	</div>
	<div id="content">
		<div class="left_menu">
			<ul id="nav_dot">
				<li>
					<h4 class="M1">
						<span></span>系统公告
					</h4>
					<!-- <div class="list-item none">
					</div> -->
				</li>
				<li>
					<h4 class="M2">
						<span></span>系统管理
					</h4>
					<div class="list-item none">
						<a href=''>查看管理员</a> 
					</div>
				</li>
				<li>
					<h4 class="M3">
						<span></span>商品管理
					</h4>
					<div class="list-item none">
						<a href="#" id="addGoods">添加商品</a> 
						<a href="#" id="viewGoods">查看商品</a> 
					</div>
				</li>
				<li>
					<h4 class="M4">
						<span></span>订单管理
					</h4>
					<div class="list-item none">
						<a href="#" id="viewOrders">查看订单</a>
						<a href="#" id="checkOrders">订单审核</a> 
						<a href="#" id="deleteOrders">订单删除</a> 
					</div>
				</li>
				<li>
					<h4 class="M5">
						<span></span>评论管理
					</h4>
					<div class="list-item none">
						<a href="#" id="viewCommon">查看评论</a> 
						<a href="#" id="deleteCommon">删除评论</a> 
					</div>
				</li>
				<li>
					<h4 class="M6">
						<span></span>商品分类
					</h4>
					<div class="list-item none">
						<a href="#" id="viewCategory">所有分类</a> 
						<a href="#" id="addCategory">添加分类</a> 
					</div>
				</li>
				<li>
					<h4 class="M10">
						<span></span>用户管理
					</h4>
					<div class="list-item none">
						<a href="#" id="addUser">添加用户</a> 
						<a href="#" id="viewUser">所有用户</a> 
					</div>
				</li>
			</ul>
		</div>
		<div class="m-right">
			<div class="right-nav">
				<ul>
					<li><img src="assets/images/home.png"></li>
				</ul>
			</div>
			<div class="main" id="main" align="center">
				
			</div>
		</div>
	</div>
	<div class="bottom"></div>
	<div id="footer">
		<p>Copyright © 2016 By Zhang Yuan Xie Liu Liu</p>
	</div>
	<script>
		navList(12);
	</script>
	
	<script>
		$(function(){
					
			$("#addUser").click(function(){
				$("#main").addClass("hidden");
				$("#main").addClass("hover").html("<iframe src='view/addUser.jsp' width='890px' height='500px' scrolling='no' frameborder='0' ></iframe>");
			});
			
			$("#viewUser").click(function(){
				$("#main").addClass("hidden");
				$("#main").addClass("hover").html("<iframe src='/easyBuy/ViewUserController' width='890px' height='500px' scrolling='no' frameborder='0' ></iframe>");
			});
			
			$("#addGoods").click(function(){
				$("#main").addClass("hidden");
				$("#main").addClass("hover").html("<iframe src='view/addGoods.jsp' width='890px' height='500px' scrolling='no' frameborder='0' ></iframe>");
			});
			
			$("#viewGoods").click(function(){
				$("#main").addClass("hidden");
				$("#main").addClass("hover").html("<iframe src='/easyBuy/ViewGoodsController' width='890px' height='500px' scrolling='no' frameborder='0' ></iframe>");
			});
			
			$("#admin").click(function(){
				$("#main").addClass("hidden");
				$("#main").addClass("hover").html("<iframe src='view/admin.jsp' width='890px' height='500px' scrolling='no' frameborder='0' ></iframe>");
			});
			
			$("#editPass").click(function(){
				$("#main").addClass("hidden");
				$("#main").addClass("hover").html("<iframe src='view/editPass.jsp' width='890px' height='500px' scrolling='no' frameborder='0' ></iframe>");
			});
		})
	</script>
	
</body>
</html>
