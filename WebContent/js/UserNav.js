$(function(){
	$(".left_nav li").each(function(){
		$(this).click(function(){
			$(this).addClass("li_bg_col");
			$(this).siblings().removeClass("li_bg_col");
		});
	});
	$(".content_tab a").each(function(){
		$(this).click(function(){
			$(this).addClass("tab_li_click");
			$(this).parent().siblings().children("a").removeClass("tab_li_click");
		});
	});
});