<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>

<link type="text/css" rel="stylesheet" href="../assets/css/bootstrap.css" />
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
	                	cellphone:true
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
	                	cellphone: "请输入正确的联系电话",
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
	<br><br>
	<form action="/easyBuy/AddUserController" method="get" 
		  enctype="multipart/form-data" id="addUserForm"
		  class="bs-example bs-example-form" role="form">
		
			<div  class="input-group">
				<span class="input-group-addon">用&nbsp;&nbsp;户&nbsp;名：</span>
				<input style=" width: 50%" type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
			</div>
			<br>	
			<div  class="input-group">
				<span class="input-group-addon">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
				<input style=" width: 50%" type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
			</div>
			<br>
			<div  class="input-group">
				<span class="input-group-addon">手机号码：</span>
				<input style=" width: 50%" type="text" class="form-control" id="phonenumber" name="phonenumber" placeholder="请输入手机号">
			</div>
			<br>
			<div  class="input-group">
				<span class="input-group-addon">地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址：</span>
				<input style=" width: 50%" type="text" class="form-control" id="address" name="address" placeholder="请输入收货地址">
			</div>
			<br>
			<div  class="input-group" align="center">
				<input type="submit" class="btn btn-primary"  id="submit" name="submit" onclick="javascript:formSubmit();" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" class="btn btn-primary"  id="reset" name="reset" value="重置">
			</div>
				
	</form>
</body>
</html>


