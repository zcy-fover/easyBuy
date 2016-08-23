<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加种类</title>

<link type="text/css" rel="stylesheet" href="../assets/css/bootstrap.css" />
<script type="text/javascript" src="../assets/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="../assets/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="../assets/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="../assets/js/jquery-ui.min.js"></script>

<script type="text/javascript">
	function formSubmit(){
			$('#addCategoryForm').validate({
	            rules: {
	                cname: {
	                    required: true,
	                    minlength:2,
	                    maxlength:20
	                },
	                summary: {
	                    required: true,
	                    minlength:5
	                },
	            },
	            messages:{
	                cname: {
	                    required: "请输入商品种类名",
	                    minlength:jQuery.validator.format("商品种类名最少为{0}个字"),
	                    maxlength:jQuery.validator.format("商品种类名最多为{0}个字")
	                },
	                summary: {
	                    required: "请输入种类简介",
	                    minlength:jQuery.validator.format("种类简介最少为{0}个字"),
	                },
	            }
	    });

	}
</script>

</head>
<body>

<br><br>
	<form action="/easyBuy/CategoryController" method="get" 
		  enctype="multipart/form-data" id="addCategoryForm"
		  class="bs-example bs-example-form" role="form">
		
			<div  class="input-group">
				<span class="input-group-addon">商品种类：</span>
				<input style=" width: 50%" type="text" class="form-control" id="cname" name="cname" placeholder="请输入商品种类名">
			</div>
			<br>	
			<div  class="input-group">
				<span class="input-group-addon">简&nbsp;&nbsp;&nbsp;&nbsp;介：</span>
				<input style=" width: 50%" type="text" class="form-control" id="summary" name="summary" placeholder="请输入商品简介">
			</div>
			<br>
			<div  class="input-group" align="center">
				<input type="submit" class="btn btn-primary"  id="submit" name="submit" onclick="javascript:formSubmit();" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" class="btn btn-primary"  id="reset" name="reset" value="重置">
			</div>
				
	</form>

</body>
</html>