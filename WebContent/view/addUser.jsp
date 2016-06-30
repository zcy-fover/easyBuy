<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>

<script type="text/javascript" src="../assets/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="../assets/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="../assets/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="../assets/js/jquery-ui.min.js"></script>

<script type="text/javascript">
	function formSubmit(){
			$('#addUserForm').validate({
	            rules: {
	                username: {
	                    required: true,
	                    minlength:2,
	                    maxlength:20
	                },
	                password: {
	                    required: true,
	                    minlength:5
	                },
	                phonenumber:{
	                	required: true,
	                    minlength:2,
	                    maxlength:20
	                },
	                address: {
	                    required: true,
	                },
	            },
	            messages:{
	                username: {
	                    required: "请输入用户名",
	                    minlength:jQuery.validator.format("标题最少为{0}个字"),
	                    maxlength:jQuery.validator.format("标题最多为{0}个字")
	                },
	                password: {
	                    required: "请输入密码",
	                    minlength:jQuery.validator.format("内容最少为{0}个字"),
	                },
	                phonenumber:{
	                	required: "请输入手机号码",
	                    minlength:jQuery.validator.format("内容最少为{0}个字"),
	                },
	                address: {
	                    required: "请输入收货地址",
	                },
	            }
	    });

	}
</script>


</head>
<body>
	<form action="/easyBuy/AddUserController" method="get" enctype="multipart/form-data" id="addUserForm">
		<table>
			<tr>
				<td>用户名：</td>
				<td>
					<input type="text" id="username" name="username" placeholder="请输入用户名">
				</td>
			</tr>
			<tr>
				<td>密码：</td>
				<td>
					<input type="password" id="password" name="password" placeholder="请输入密码">
				</td>
			</tr>
			<tr>
				<td>手机号码：</td>
				<td><input type="text" id="phonenumber" name="phonenumber"
					placeholder="请输入手机号"></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td>
					<input type="text" id="address" name="address" placeholder="请输入收货地址">
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" id="submit" name="submit" onclick="javascript:formSubmit();" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;
				</td>
				<td>
					<input type="reset" id="reset" name="reset" value="重置">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>


