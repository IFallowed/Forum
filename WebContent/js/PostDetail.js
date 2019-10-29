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