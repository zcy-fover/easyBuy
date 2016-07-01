<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>

<link type="text/css" rel="stylesheet" href="../assets/css/bootstrap.css" />
<script type="text/javascript" src="../assets/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="../assets/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="../assets/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="../assets/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="../assets/js/laydate.js"></script>

<script type="text/javascript">
	function formSubmit(){
			$('#addUserForm').validate({
	            rules: {
	                gname: {
	                    required: true,
	                    minlength:1,
	                    maxlength:20
	                },
	                price: {
	                    required: true,
	                    min: 0
	                },
	                offset:{
	                	required: true,
	                    min: 0
	                },
	                storage: {
	                    required: true,
	                    min: 0
	                },
	                time: {
	                    required: true,
	                },
	                category: {
	                    required: true,
	                },
	            },
	            
	            messages:{
	            	gname: {
	                    required: "请输入商品名",
	                    minlength:jQuery.validator.format("标题最少为{0}个字"),
	                    maxlength:jQuery.validator.format("标题最多为{0}个字")
	                },
	                price: {
	                    required: "请输入单价",
	                    minlength:jQuery.validator.format("单价最小值为0"),
	                },
	                offset:{
	                	required: "请输入折扣",
	                    minlength:jQuery.validator.format("单价最小值为0"),
	                },
	                storage: {
	                    required: "请输入收货地址",
	                },
	                time: {
	                    required: "请输入添加时间",
	                },
	                category: {
	                    required: "请选择商品种类",
	                },
	            }
	    });

	}
</script>


</head>
<body>
	<br>
	<form action="/easyBuy/AddGoodsController" method="get" 
		  enctype="multipart/form-data" id="addUserForm"
		  class="bs-example bs-example-form" role="form">
		
			<div  class="input-group">
				<span class="input-group-addon">商&nbsp;&nbsp;品&nbsp;名：</span>
				<input style=" width: 50%" type="text" class="form-control" id="gname" name="gname" placeholder="请输入商品名称">
			</div>
			<br>	
			<div  class="input-group">
				<span class="input-group-addon">单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价：</span>
				<input style=" width: 50%" type="number" class="form-control" id="price" name="price" min="0" placeholder="请输入单价">
			</div>
			<br>
			<div  class="input-group">
				<span class="input-group-addon">折&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;扣：</span>
				<input style=" width: 50%" type="number" class="form-control" id="offset" name="offset" min="0" placeholder="请输入折扣">
			</div>
			<br>
			<div  class="input-group">
				<span class="input-group-addon">数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量：</span>
				<input style=" width: 50%" type="number" class="form-control" id="storage" name="storage" min="0" placeholder="请输入数量">
			</div>
			<br>
			<div  class="input-group">
				<span class="input-group-addon">时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;间：</span>
				<input style=" width: 50%" type="datetime" class="form-control" 
					   id="time" name="time" placeholder="请输入添加时间"
					   onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
			</div>
			<br>
			<div  class="input-group">
				<span class="input-group-addon">类&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;型：</span>
				<div class="form-group">
      				<select class="form-control" style=" width: 50%" name="cname">
         				<option value="food" id="food">食物</option>
         				<option value="cloth" id="cloth">衣服</option>
      				</select>
   				</div>
			</div>
			<br>
			<div  class="input-group" align="center">
				<input type="submit" class="btn btn-primary"  id="submit" name="submit" onclick="javascript:formSubmit();" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" class="btn btn-primary"  id="reset" name="reset" value="重置">
			</div>
				
	</form>
</body>
</html>