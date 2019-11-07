$(function(){
	$("#submit_post").click(function(){
		var title = $("#post_title").val();
		var type = $("#post_type").val();
		var content = editor.html();
		var userId = getUrlParam("userId");
		
		$.ajax({
			type:"POST",
			url:"theme/addOneThemePost.do",
			data:{userId:userId,
				title:title,
				type:type,
				content:content
				},
			dataType:"json",
			success:function(result) {
				
			}
		});
	});
});

function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); //匹配目标参数
	if (r != null) return unescape(r[2]);
	return null; //返回参数值
}