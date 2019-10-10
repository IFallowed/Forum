<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基本设置</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/UserNav.js"></script>
<link rel="stylesheet" type="text/css" href="css/Frame.css">
<link rel="stylesheet" type="text/css" href="css/UserNav.css">
<link rel="stylesheet" type="text/css" href="css/UserSettings.css">
</head>
<body>
	<div class="mid_container clearfix">
		<div class="left_nav lf">
			<ul>
				<li>
					<a href="#">我的主页</a>
				</li>
				<li>
					<a href="#">用户中心</a>
				</li>
				<li class="li_bg_col">
					<a href="UserSettings.jsp">基本设置</a>
				</li>
				<li>
					<a href="UserInfo.jsp">我的消息</a>
				</li>
				<li>
					<a href="#">账户充值/会员</a>
				</li>
			</ul>
		</div>
		<div class="content rf">
			<div class="content_tab">
				<ul id="tab_ul" class="nav nav-tabs">
					<li class="active">
						<a href="#myInfo" data-toggle="tab">
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
					<form role="form" action="#">
						<div class="form_group clearfix">
							<label for="settings_mail">邮箱：</label>
							<input type="email" id="login_mail" placeholder="固定值不可更改">
						</div>
						<div class="form_group clearfix">
							<label for="settings_name">昵称：</label>
							<input type="text" id="login_mail" placeholder="">
						</div>
						<div class="form_group clearfix">
							<label for="settings_phone">手机：</label>
							<input type="text" id="login_mail" placeholder="">
						</div>
						<div class="form_group clearfix">
							<label for="settings_city">城市：</label>
							<input type="text" id="login_mail" placeholder="">
						</div>
						<div class="form_group clearfix">
							<label for="settings_">城市：</label>
							<input type="text" id="login_mail" placeholder="">
						</div>
					</form>
				</div>
				<div id="avatar" class="tab-pane fade">
				
				</div>
				<div id="pwd" class="tab-pane fade">
				
				</div>
			</div>
		</div>
	</div>
</body>
</html>