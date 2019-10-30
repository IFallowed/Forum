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