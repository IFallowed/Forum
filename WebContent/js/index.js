$(function(){
	
	$(".top_nav li").click(function(){
		$(this).addClass("li_color");
		$(this).siblings().removeClass("li_color");
	});
	$(".post_nav a").click(function(){
		$(this).addClass("li_color");
		$(this).siblings().removeClass("li_color");
	});
	
	$(".pageNav").on("click","li",function(){
		
		var txt = $(this).find("span").text();
		var page;
		if("首页" == txt){
			page = $(this).find("i").text();
		}
		else if("尾页" == txt){
			page = $(this).find("i").text();
		}
		else {
			page = txt;
		}
		
		getAllPost(page);
		location.reload();

	});
	
});


function getAllPost(pageNo){
	 $.ajax({
			type:"POST",
			url:"theme/getThemePosts.do",
			data:{
				pageNo:pageNo
			},
			dataType:"json",
			success:function(result){
//				var dataLength = result.dataList.length;
//				var html = "<li  class='post_li clearfix'>" + 
//				"<a href='#'><img id='user_avatar' src='${pageContext.request.contextPath}/userAvatar/${post.user.avatar}'></a>"
//				+"<div class='post_info'>" +"<p><span class='post_state'>未结</span><a href='html/post/PostDetail.jsp?postId=" + 
//				"'><span class='post_userName'>"
			}
		}); 
	
}

function initLoad(){
	var userId = getUrlParam("userId");

	if(null == userId || "" == userId){
		$(".quit").addClass("div_hidden"); //1
		$(".default_icon").removeClass("div_hidden"); //0
		$(".header img").addClass("div_hidden"); //1
	}
	else{
		$(".quit").removeClass("div_hidden");
	}
	
	var pageNo = getUrlParam("pageNo");
	if(null == pageNo || "" == pageNo){
		pageNo = "1";
	}
	getAllPost(pageNo);
	
	setTimeout(function(){
		$.ajax({
			type:"POST",
			url:"user/getUser.do",
			data:{userId:userId},
			dataType:"json",
			success:function(result){
				if(result.code == "200"){
					if(null != result.nickName && "" != result.nickName){
						$(".user a").text(result.nickName);
						$(".default_icon").addClass("div_hidden");
						$(".header img").removeClass("div_hidden");
					}
					else{
						$(".user a").text("用户" + result.id);
					}
					$(".user a").attr("href","html/user/UserSettings.jsp?userId=" + result.id);
				}
			}
		});
	 },500);
}

function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); //匹配目标参数
	if (r != null) return unescape(r[2]);
	return null; //返回参数值
}
