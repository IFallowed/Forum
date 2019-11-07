	var E = window.wangEditor;
	var editor = new E('#post_editor');
	editor.customConfig.uploadImgShowBase64 = true;   // 使用 base64 保存图片
	editor.create();
	
$(function(){
	$(".post_likeNum").click(function(){
		var href = $(this).find("use").attr("xlink:href");
		if(href == "#icon_nogood"){
			$(this).find("use").attr("xlink:href","#icon_good");
		}
		else {
			$(this).find("use").attr("xlink:href","#icon_nogood");
		}
	});
	
	$(".post_replyNum").click(function(){
		var name = $(this).parent().parent().siblings(".reply_userInfo").find(".post_userName").text().trim();
		var content = $(this).parent().parent().siblings(".post_content").html();
		editor.txt.clear();
		editor.txt.html("<blockquote contenteditable='false'>" +
				"@<a id ='reply_userName' href='#'>" + name + "</a>:" +
				"<blockquote>" + content + "</blockquote>" +
			"</blockquote>");
		editor.txt.append("<p>&nbsp;</p>");
	});
	

});

function initLoad(){
	var userId = getUrlParam("userId");
	var postId = getUrlParam("postId");

	if(null == userId || "" == userId){
		$(".quit").addClass("div_hidden"); //1
		$(".default_icon").removeClass("div_hidden"); //0
		$(".header img").addClass("div_hidden"); //1
	}
	else{
		$(".quit").removeClass("div_hidden");
	}
		$.ajax({
			type:"POST",
			url:"theme/getOneThemePost.do",
			data:{postId:postId},
			dataType:"json",
			success:function(result) {
				
			}
		});
	
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
