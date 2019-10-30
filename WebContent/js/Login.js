//function barter_btn(bb){
//	$(bb).parent().hide();
//	$(bb).parent().siblings().show();
//}
$(function () {
    $('#form-tab a:first').tab('show');
    
    //login表单邮箱验证
	$('#login_mail').blur(function() {
		if(""==($(this).val().trim())){
			$(this).siblings('.form_info').prepend("<font style='color:#DC143C'>请输入邮箱</font>");
		}
		else {
			if($(this).val().trim().match(/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/)){
				$(this).siblings('.form_info').prepend("");
			}
			else{
				$(this).siblings('.form_info').prepend("<font style='color:#DC143C'>邮箱格式不正确</font>");
			}
		}
	});
	
	//login表单密码验证
	$('#login_password').blur(function() {
		if(""==($(this).val().trim())){
			$(this).siblings('.form_info').prepend("<font style='color:#DC143C'>请输入密码</font>");
		}
		else {
			$(this).siblings('.form_info').prepend("");
		}
	});
	
	//register表单邮箱验证
	$('#register_mail').blur(function() {
		if(""==($(this).val().trim())){
			$(this).siblings('.form_info').prepend("<font style='color:#DC143C'>请输入邮箱</font>");
		}
		else {
			if($(this).val().trim().match(/^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/)){
				$(this).siblings(".form_info").find("div").removeClass("div_hidden");
				$(this).siblings(".form_info").find("div").css("background-position","-147px 37px");
			}
			else{
				$(this).siblings(".form_info").find("div").addClass("div_hidden");
				$(this).siblings('.form_info').prepend("<font style='color:#DC143C'>邮箱格式不正确</font>");
			}
		}
	});
	
	//register表单密码验证
	$('#register_password').blur(function() {
		if(""==($(this).val().trim())){
			$(this).siblings('.form_info').prepend("<font style='color:#DC143C'>请输入密码</font>");
		}
		else {
			if(!$(this).val().trim().match(/^[0-9a-zA-Z%!@$#*&]{6,20}$/)){
				$(this).siblings('.form_info').prepend("<font style='color:#DC143C'>密码格式不正确：6-20位字母/数字/字符组合</font>");
			}
		}
	});
	
	//给密码框绑定一个keyup事件(当键盘抬起来会自动触发)
	$('#register_password').keyup(function(){
		var pwd = $(this).val().trim();
		$(this).siblings('.form_info').find("font").remove();
		if(pwd.length > 6 && pwd.length <= 14){
			$(this).siblings(".form_info").find("div").removeClass("div_hidden");
			if(/[0-9]/.test(pwd) && /[a-zA-Z]/.test(pwd) && /[%!@$#*&]/.test(pwd)){
				//中
				$(this).siblings(".form_info").find("div").css("background-position","-60px 37px");
			}
			else {
				//弱
				$(this).siblings(".form_info").find("div").css("background-position","-100px 38px");
			}
		}
		else if(pwd.length > 14 && pwd.length <= 20){
			$(this).siblings(".form_info").find("div").removeClass("div_hidden");
			if(/[0-9]/.test(pwd) && /[a-zA-Z]/.test(pwd) && /[%!@$#*&]/.test(pwd)){
				//强
				$(this).siblings(".form_info").find("div").css("background-position","-12px 37px");
			}
			else {
				//中
				$(this).siblings(".form_info").find("div").css("background-position","-60px 37px");
			}
		}
		else{
			$(this).siblings(".form_info").find("div").addClass("div_hidden");
		}
	});
});
