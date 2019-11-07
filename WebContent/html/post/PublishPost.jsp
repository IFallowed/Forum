<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>发表新贴</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../css/Frame.css">
<link rel="stylesheet" type="text/css" href="../../css/PublishPost.css">
<script type="text/javascript" src="../../js/PublishPost.js"></script>
<script src="https://at.alicdn.com/t/font_1457444_n4pzqtsz54.js"></script>
<script src="https://unpkg.com/wangeditor/release/wangEditor.min.js"></script>


</head>
<body>
	<div class="header">
		<a href="index.html"><i class="logo"></i></a>
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
		<label class="user"><a href="../user/UserSettings.html">用户名</a></label>
		<i class="avatar"></i>
	</div>
	
	<div class="mid_container claerfix">
		<div class="header_title li_color">
			发表新帖
		</div>
		<form >
			<div class="type_input lf">
				<label for="post_type" class="lf">所属专栏</label>
				<select id="post_type" class="rf">
					<option>请选择</option>
					<option>HTML</option>
					<option>CSS</option>
					<option>JAVASCRIPT</option>
					<option>JQUERY</option>
					<option>AJAX</option>
					<option>其他框架</option>
				</select>
			</div>
			<div class="title_input rf">
				<label for="post_title" class="lf">标题</label>
				<input type="text" id="post_title" >
			</div>
			
			<div id="post_editor">
			</div>
			<script type="text/javascript">
        		var E = window.wangEditor
        		var editor = new E('#post_editor')
        		editor.customConfig.uploadImgShowBase64 = true   // 使用 base64 保存图片
        		editor.create()
    		</script>
    		<input type="button" id="submit_post" class="btn btn-success active" value="立即发布">
		</form>
	</div>
</body>
</html>