<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/Login.js"></script>
<link rel="stylesheet" type="text/css" href="css/Login.css">
</head>
<!-- http://demo.demohuo.top/modals/30/3074/demo/ -->
<body>
	<div class="form_div">
		 <div class="form_nav">
			<ul id="form-tab" class="nav nav-tabs">
				<li class="active" >
					<a href="#login_form" id="login_tab" data-toggle="tab">
		            	登录
		            </a>
				</li>
				<li>
					<a href="#register_form" id="register_tab" data-toggle="tab">
		            	注册
		            </a>
				</li>
			</ul>
		</div> 
		<div class="tab-content">
			<div id="login_form" class="tab-pane fade in active">
				<form role="form" >
					<div class="form_group clearfix">
		    			<label class="form_info"></label>
	    				<label for="login_mail">邮箱：</label>
		    			<input type="email" id="login_mail" name="login_mail"  placeholder="请输入邮箱">
	  				</div>  				
	  				<div class="form_group clearfix">
	  					<label class="form_info"></label>
	    				<label for="login_password" >密码：</label>
		    			<input type="password" id="login_password" name="login_password" placeholder="请输入密码">
	  				</div>
	  				<div class="form_group clearfix">
	  					<label class="form_info">4+6=</label>
	    				<label for="login_HumanCheck">人类验证：</label>
		    			<input type="text" id="HumanCheck" name="HumanCheck" placeholder="请回答后面的问题">
	  				</div>
	  				<div class="form_group clearfix">
		    			<input type="button" id="login_btn" class="btn btn-success active" value="登录">
	  				</div>
				</form>
			</div>
			<div id="register_form" class="tab-pane fade">
				<form role="form" >
					<div class="form_group clearfix">
						<div class="form_info"><div class="div_hidden"></div></div>
	    				<label for="register_mail">邮箱：</label>
		    			<input type="email" id="register_mail" name="register_mail" placeholder="bbs@google.com">
	  				</div>
	  				<div class="form_group clearfix">
	  					<div class="form_info"><div class="div_hidden"></div></div>
	    				<label for="register_name" >昵称：</label>
		    			<input type="text" id="register_name" name="register_name" placeholder="请输入昵称">
	  				</div>
	  				<div class="form_group clearfix">
	  					<div class="form_info"><div class="div_hidden"></div></div>
	    				<label for="register_password" >密码：</label>
		    			<input type="password" id="register_password" name="register_password" placeholder="6-20位字母/数字/字符组合">
	  				</div>
	  				<div class="form_group clearfix">
	    				<label class="radio_label">性别：</label>
			    		<label for="male"><input type="radio" name="sex" id="male" value="0" checked="checked">男</label>
		        		<label for="female"><input type="radio" name="sex" id="female" value="1">女</label>
	  				</div>
	  				<div class="form_group clearfix">
	  					<label class="form_info">5-3</label>
	    				<label for="register_HumanCheck">人类验证：</label>
		    			<input type="text" id="HumanCheck" name="HumanCheck" placeholder="请回答后面的问题">
	  				</div> 
	  				<div class="form_group clearfix">
		    			<input type="button" id="register_btn" class="btn btn-success active" value="注册" >
	  				</div>
				</form>
			</div>	
		</div>
	</div> 
</body>
</html>