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
});