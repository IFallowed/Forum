<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>基本设置</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/UserNav.js"></script>
<link rel="stylesheet" type="text/css" href="../../css/Frame.css">
<link rel="stylesheet" type="text/css" href="../../css/UserNav.css">
<link rel="stylesheet" type="text/css" href="../../css/UserSettings.css">
<script src="https://at.alicdn.com/t/font_1457444_10ldj8elo38p.js"></script>
<script type="text/javascript" src="../../js/UserSettings.js"></script>
<script type="text/javascript" src="../../js/ajaxfileupload.js"></script>

</head>
<body onload="initLoad()">
	<div class="header">
		<a href="../../index.jsp?userId=${user.id}"><i class="logo"></i></a>
		<ul class="header_nav clearfix">
			<li class="lf">
				<svg class="icon icon_size" aria-hidden="true" >
					<use xlink:href="#icon_white_jiaoliu"></use>
				</svg>
				<p class="rf">交流</p>
			</li>
			<li class="lf">
				<svg class="icon icon_size" aria-hidden="true" >
					<use xlink:href="#icon_chanpin"></use>
				</svg>
				<p class="rf">专区</p>
			</li>
			<li class="lf">
				<svg class="icon icon_size" aria-hidden="true" >
					<use xlink:href="#icon_ui"></use>
				</svg>
				<p class="rf">框架</p>
			</li>
		</ul>
		<label class="user"><a href="../../Login.jsp">用户名</a></label>
		<i class="avatar default_icon"></i>
		<img class="avatar div_hidden" src="${pageContext.request.contextPath}/userAvatar/${user.avatar}"></img>
		<label class="quit div_hidden"><a href="../../Login.jsp">退出</a></label>
	</div>
	<div class="mid_container clearfix">
		<div class="left_nav lf">
			<ul>
				<li>
					<a href="UserHomepage.jsp?userId=${user.id}">我的主页</a>
				</li>
				<li>
					<a href="#">用户中心</a>
				</li>
				<li class="li_bg_col">
					<a href="UserSettings.jsp?userId=${user.id}">基本设置</a>
				</li>
				<li>
					<a href="UserMessage.jsp?userId=${user.id}">我的消息</a>
				</li>
				<li>
					<a href="UserPost.jsp?userId=${user.id}">我的帖子</a>
				</li>
			</ul>
		</div>
		<div class="content rf">
			<div class="content_tab">
				<ul id="tab_ul" class="nav nav-tabs">
					<li class="active">
						<a href="#myInfo" class="li_color" data-toggle="tab">
							我的资料
						</a>
					</li>
					<li>
						<a href="#avatar" data-toggle="tab">
							头像
						</a>
					</li>
					<li>
						<a href="#pwd" data-toggle="tab">
							密码
						</a>
					</li>
				</ul>
			</div>
			<div class="tab-content">
				<div id="myInfo" class="tab-pane fade in active">
					<form role="form" >
						<div class="form_group clearfix">
							<label for="settings_mail">邮箱：</label>
							<input type="email" id="settings_mail" placeholder="${user.mail}" readonly="readonly">
						</div>
						<div class="form_group clearfix">
							<label for="settings_name">昵称：</label>
							<input type="text" id="settings_name" placeholder="" value="${user.nickName}">
						</div>
						<div class="form_radio clearfix">
								<label for="male"><input type="radio" name="sex" id="male" value="0" checked="checked">男</label>
			        			<label for="female"><input type="radio" name="sex" id="female" value="1">女</label>
							</div>
						<div class="form_group clearfix">
							<label for="settings_phone">手机：</label>
							<input type="text" id="settings_phone" placeholder="" value="${user.phone}">
						</div>
						<div class="form_group clearfix">
							<label for="settings_city">城市：</label>
							<input type="text" id="settings_city" placeholder="" value="${user.city}">
						</div>
						<div class="signature_group clearfix">
							<label for="settings_signature">签名：</label>
							<textarea rows="7" cols="15" id="settings_signature" placeholder="随便写些什么刷下存在感">${user.signature}</textarea>
						</div>
						<div class="form_group clearfix">
		    			<input type="button" id="settings_btn" class="btn btn-success onHover active" value="确认修改">
	  					</div>
					</form>
				</div>
				<div id="avatar" class="tab-pane fade">
					<form role="form" action="user/upAvatar.do" method="POST" enctype="multipart/form-data">
						<input type="button" id="avatar_select_btn" class="btn btn-success onHover active" value="选择文件">
						<p>建议尺寸168*168，支持jpg、png、gif，最大不能超过3M</p>
						<input type="file" name="file" id = "load_avatar">
						<img id="preview"src="${pageContext.request.contextPath}/userAvatar/${user.avatar}"></img>
						<input type="button" id="avatar_load_btn" class="btn btn-success onHover active" value="上传头像">
					</form>
				</div>
				<div id="pwd" class="tab-pane fade">
					<form role="form" action="#">
						<div class="form_group clearfix">
							<label for="old_pwd">当前密码：</label>
							<input type="email" id="old_pwd" placeholder="">
							<div class="msg">
								
							</div>
						</div>
						<div class="form_group clearfix">
							<label for="new_pwd">新密码：</label>
							<input type="text" id="new_pwd" placeholder="">
							<div class="msg">
								6-16位字母数字组合
							</div>
						</div>
						<div class="form_group clearfix">
							<label for="comfirm_pwd">确认密码：</label>
							<input type="text" id="comfirm_pwd" placeholder="">
							<div class="msg">
								
							</div>
						</div>
						<div class="form_group clearfix">
		    			<input type="button" id="pwd_btn" class="btn btn-success onHover active" value="确认修改">
	  					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>