<%@page import="com.forum.util.PageModel"%>
<%@page import="com.forum.util.DateUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/Frame.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<script src="js/index.js"></script>
<script src="https://at.alicdn.com/t/font_1457444_0dujhpcw06s.js"></script>
</head>
<body onload="initLoad()">
	<div class="header">
		<a href="index.jsp?userId=${user.id} }"><i class="logo"></i></a>
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
		<label class="user"><a href="Login.jsp">用户名</a></label>
		<i class="avatar"></i>
		<img class="avatar" src="${pageContext.request.contextPath}/userAvatar/${user.avatar}"></img>
		<label class="quit div_hidden"><a href="Login.jsp">退出</a></label>
	</div>
	
	<div class="top_container clearfix">
		<ul class="top_nav lf clearfix">
			<li class="li_color">首页</li>
			<li>HTML</li>
			<li>CSS</li>
			<li>JAVASCRIPT</li>
			<li>JQUERY</li>
			<li>AJAX</li>
			<li>前端框架</li>
		</ul>
		<p class="lf">|</p>
		<ul class="top_nav rf_nav lf clearfix">
			<li>我发表的贴</li>
			<li>我收藏的贴</li>
		</ul>
		<button id="submitPost" class="btn btn-success rf active" onclick="javaScript:location.href='html/post/PublishPost.jsp?userId=${user.id}'">发表新帖</button>
		<svg class="icon icon_size rf" aria-hidden="true" >
			<use xlink:href="#icon_sousuo"></use>
		</svg>
	</div>
	
	<div class="mid_container clearfix">
		<div class="left_content lf">
			<div class="top_post">
				<div class="top_lab">
					置顶
				</div>
				<ul>
					<li class="post_li clearfix">
						<a href="#"><img id="user_avatar" src="img/0.jpg"></a>
						<div class="post_info">
							<p>
								<span class="post_state">完结</span>
								<a href="html/post/PostDetail.jsp?postId=${post.id}"><span class="post_title">帖子主题</span></a>
								<span class="post_state">精贴</span>
							</p>
							<p class="clearfix">
								<a  href="html/user/UserHomePage.jsp?userId=${user.id}"><span class="post_userName">用户名</span></a>
								<span class="post_publishTime" >2小时前</span>
								<span class="post_replyNum rf">
									<svg class="icon icon_min_size" aria-hidden="true" >
										<use xlink:href="#icon_liulan"></use>
									</svg>
									1
								</span>
								<span class="post_replyNum rf">
									<svg class="icon icon_min_size" aria-hidden="true" >
										<use xlink:href="#icon_discuss"></use>
									</svg>
									1
								</span>
							</p>
						</div>
					</li>
				</ul>
			</div>
			<div class="post_ul">
				<div class="post_nav">
					<a href="#" class="li_color">综合</a>
					|
					<a href="#">未结</a>
					|
					<a href="#">已结</a>
					|
					<a href="#">精华</a>
				</div>
				<ul>
					<li class="post_li clearfix">
						<a href="#"><img id="user_avatar" src="img/0.jpg"></a>
						<div class="post_info">
							<p>
								<span class="post_state">未结</span>
								<a href="html/post/PostDetail.jsp?postId=${post.id}&userId=${user.id}"><span class="post_title">帖子主题</span></a>
							</p>
							<p class="clearfix">
								<a href="html/user/UserHomePage.jsp?userId=${post.id}"><span class="post_userName">用户名</span></a>
								<span class="post_publishTime" >2小时前</span>
								<span class="post_gold">悬赏:<span>10</span>金币</span>
								<span class="post_replyNum rf">
									<svg class="icon" aria-hidden="true" >
										<use xlink:href="#icon_liulan"></use>
									</svg>
									1
								</span>
								<span class="post_replyNum rf">
									<svg class="icon" aria-hidden="true" >
										<use xlink:href="#icon_discuss"></use>
									</svg>
									1
								</span>
							</p>
						</div>
					</li>

					<c:forEach items="${pageModel.dataList}" var="post" varStatus="status">
						<li  class="post_li clearfix">
							<a href="#"><img id="user_avatar" src="${pageContext.request.contextPath}/userAvatar/${post.user.avatar}"></a>
							<div class="post_info">
								<p>
									<span class="post_state">未结</span>
								<a href="html/post/PostDetail.jsp?postId=${post.id}&userId=${user.id}"><span class="post_title">${post.title}</span></a>
								</p>
								<p class="clearfix">
									<a href="html/user/UserHomePage.jsp?userId=${post.user.id}"><span class="post_userName">${post.user.nickName}</span></a>
									<span class="post_publishTime">${post.timeDelay}</span>
									<span class="post_gold">悬赏:<span>${post.gold}</span>金币</span>
									<span class="post_replyNum rf">
										<svg class="icon" aria-hidden="true" >
											<use xlink:href="#icon_liulan"></use>
										</svg>
										${post.browseNum }
									</span>
									<span class="post_replyNum rf">
										<svg class="icon" aria-hidden="true" >
											<use xlink:href="#icon_discuss"></use>
										</svg>
										${post.replyNum }
									</span>
								</p>
							</div>
						</li>
					</c:forEach>
				</ul>
				
				<nav aria-label="Page navigation" >
  					<ul class="pagination pagination-lg pageNav" >
  						<li>
        					<span aria-hidden="true">首页</span>
        					<i class="div_hidden">${pageModel.firstNo }</i>
    					</li>
    					<li>
        					<span aria-hidden="true">${pageModel.preNo }</span>
        					<i class="div_hidden">${pageModel.preNo }</i>
    					</li>
    					<li class="active">
    						<span>${pageModel.pageNo }</span>
    						<i class="div_hidden">${pageModel.pageNo }</i>
    					</li>
    					<li>
        					<span aria-hidden="true">${pageModel.nextNo }</span>
        					<i class="div_hidden">${pageModel.nextNo }</i>
    					</li>
    					<li>
        					<span aria-hidden="true">尾页</span>
        					<i class="div_hidden">${pageModel.totalPage }</i>
    					</li>
  					</ul>
				</nav>
			</div>
		</div>
		<div class="right_content rf"></div>
	</div>
</body>
</html>