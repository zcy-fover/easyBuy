<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.group.easyBuy.service.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	String message = (String)request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>

<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="assets/css/login.css" />
<script type="text/javascript" src="assets/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="assets/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="assets/js/jquery-ui.min.js"></script>

<script type="text/javascript">
	function formSubmit(){
			$('#addUserForm').validate({
	         /*    errorElement: 'div',
	            errorClass: 'help-block',
	            focusInvalid: false, */
	            rules: {
	                username: {
	                    required: true,
	                    minlength:2,
	                    maxlength:10
	                },
	                password: {
	                    required: true,
	                    minlength:5,
	                    maxlength:15
	                },
	            },
	            messages:{
	                username: {
	                    required: "请输入用户名",
	                    minlength:jQuery.validator.format("用户名最少为{0}个字"),
	                    maxlength:jQuery.validator.format("用户名最多为{0}个字")
	                },
	                password: {
	                    required: "请输入密码",
	                    minlength:jQuery.validator.format("密码最少为{0}个字"),
	                    maxlength:jQuery.validator.format("密码最多为{0}个字")
	                },
	            }
	    });

	}
</script>
</head>
<body>

	<%-- <%
		if(model.getCode() == 0){
	%>
			tbuser = zhang;
			  --%>

	<div id="wrapper">
		<div id="header">
			<div id="logo"></div>
			<div id="heading">
				<div id="title">易购商城后台管理系统</div>
				<!-- <div id="subTitle">Ver 1.0</div> -->
			</div>
		</div>
		<div id="main">
			<div id="mainBg">
				<div id="mainPanel">
					<div id="left">
						<div id="image"></div>
					</div>
					<div id="right">
						<div id="welcome">
							<span id="welcome-text">管&nbsp;理&nbsp;员&nbsp;登&nbsp;录</span>
						</div>
						<form action="AdminController" method="post" id="addUserForm">
							<div id="user-name">
								<span class="item">用户名:</span>
								<span class="input">
									<input type="text" name="username" class="form-input form-control" placeholder="请输入用户名">
								</span>
							</div>
							
							<!-- 验证错误提示信息 -->
							<c:if test="${ requestScope.message != null }">
								<div style="color: red; margin-left: 100px;" >
									<font color="red">${ requestScope.message }</font>
								</div>
							</c:if>
							
							<div id="user-password">
								<span class="item">密&nbsp;&nbsp;&nbsp;码:</span>
								<span class="input">
									<input type="password" name="password" class="form-input form-control" placeholder="请输入密码">
								</span>
							</div>
							<!-- <div id="user-checkcode">
								<span class="item">验证码:</span> <span class="input"><input
									type="text" name="checkCode" class="form-input"></span> <span
									class="checkcode-span"></span>
							</div> -->
							<div id="error-tip">
								<span id="tip-text"></span>
							</div>
							<div id="button-group">
								<input type="submit" class="btn" value="提交" onclick="javascript:formSubmit();"/> 
								<input type="reset" class="btn" value="重置" />
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div id="footer">
			<div id="text">Copyright © 2016 By Zhang Yuan Xie Liu Liu</div>
		</div>
	</div>
</body>
</html>