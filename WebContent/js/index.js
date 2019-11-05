$(function(){
	$(".top_nav li").click(function(){
		$(this).addClass("li_color");
		$(this).siblings().removeClass("li_color");
	});
	$(".post_nav a").click(function(){
		$(this).addClass("li_color");
		$(this).siblings().removeClass("li_color");
	});
	

	
});

function initLoad(){
	var paramStr = location.href.substring(location.href.indexOf("?") + 1);
	
	var param = location.href.substring(location.href.indexOf("?") + 1);
	$.ajax({
		type:"POST",
		url:"user/getUser.do",
		data:param,
		dataType:"json",
		success:function(result){
			if(result.code == "200"){
				if(null != result.nickName && "" != result.nickName){
					$(".user a").text(result.nickName);
				}
				else{
					$(".user a").text("游客" + result.id);
				}
				$(".user a").attr("href","html/user/UserSettings.html?userId=" + result.id);
			}
		}
	});
}
