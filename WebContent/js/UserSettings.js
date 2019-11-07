$(function(){
	var userId = getUrlParam("userId");
	$("#settings_btn").click(function(){
		var nickName = $("#settings_name").val().trim();
		var phone = $("#settings_phone").val().trim();
		var city = $("#settings_city").val().trim();
		var signature = $("#settings_signature").val().trim();
		var sex= $("#myInfo input[type='radio']:checked").val().trim();
		var param = "userId=" + userId + "&nickName=" + nickName + "&sex=" + sex + "&phone=" + phone + "&city=" + city + "&signature=" + signature;
		var flag = window.confirm("确定要修改吗？");
		if(flag){
			$.ajax({
				type:"POST",
				url:"user/updateUser.do",
				data:param,
				dataType:"json",
				success:function(result){
					if(result.code == "200"){
						alert("修改成功");
						location.reload();
					}
				}
			});
		}
	});
	
	$("#new_pwd").blur(function(){
		update_newPwd();
	});
	
	$("#comfirm_pwd").blur(function(){
		update_confPwd();
	})
	
	$("#pwd_btn").click(function(){
		if(update_newPwd() && update_confPwd()){
			var Opwd = $("#old_pwd").val().trim();
			var Npwd = $("#new_pwd").val().trim();
			
			var param = "userId=" + userId + "&Opwd=" + Opwd + "&Npwd=" + Npwd;
			var flag = window.confirm("确定要修改密码吗？");
			if(flag){
				$.ajax({
					type:"POST",
					url:"user/updatePwd.do",
					data:param,
					dataType:"json",
					success:function(result){
						if(result.code == "200"){
							alert("修改成功，请重新登录");
							location.href = "../../Login.jsp";
						}
						else if(result.code == "203"){
							$("#old_pwd").siblings(".msg").find("font").remove();
							$("#old_pwd").siblings('.msg').prepend("<font style='color:#DC143C'>" + result.msg + "</font>");
						}
					}
				});
			}
		}
	});
	
	$("#avatar_select_btn").click(function(){
		$("#load_avatar").click();
	});
	
	$("#load_avatar").change(function(){
		//获取文件
		var file = $(this)[0].files[0];
	    console.log($(this)[0].files);
	  //判断是否支持FileReader
		if(window.FileReader){
			var reader = new FileReader();
		}
		else{
			alert("您的设备不支持图片预览功能，请换用其他浏览器");
		}
		reader.readAsDataURL(file);
		//读取完成
		reader.onload = function(e) {
			$("#preview").attr("src",e.target.result);
		};
	});
	
	$("#avatar_load_btn").click(function(){
		var flag = window.confirm("确认上传图片？");
		if(flag){
//			var formData = new FormData();
//			var imgFile = document.getElementById("load_avatar");
//			var fileObj = imgFile.files[0];
//			formData.append("avatar",fileObj);
			var userId = location.href.substring(location.href.indexOf("=") + 1);
			$.ajaxFileUpload({
				url:"user/upAvatar.do",
				type:"POST",
				secureuri:false,
				fileElementId:'load_avatar',
				data: {userId:userId},
				dataType : 'json',
//				data:formData,
//				async:false,
//				processData:false,
//				contentType:false,
				success:function(result){
					if(result.code =="200"){
						alert("上传成功");
						var src = $(".header img").attr("src");
						src = src.substring(0,src.lastIndexOf("/") + 1) + result.img;
						$(".header img").attr("src",src);
					}
					else if(result.code =="206"){
						alert(result.msg);
					}
				}
			});
		}
	});
});

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
					$(".default_icon").addClass("div_hidden");
					$(".header img").removeClass("div_hidden");
					if(0 == result.sex){
						$("#myInfo input[type='radio']:first").attr('checked', 'true');
					}
					else{
						$("#myInfo input[type='radio']:last").attr('checked', 'true');
					}
				}
				else{
					$(".user a").text("用户" + result.id);
				}
				$(".user a").attr("href","html/user/UserSettings.jsp?userId=" + result.id);
			}
		}
	});
}

function update_newPwd(){
	var pwd = $("#new_pwd").val().trim();
	$("#new_pwd").siblings(".msg").find("font").remove();
	if(""==($("#new_pwd").val().trim())){
		$("#new_pwd").siblings('.msg').prepend("<font style='color:#DC143C'>请输入密码</font>");
		return false;
	}
	else{
		if(!$("#new_pwd").val().trim().match(/^[0-9a-zA-Z%!@$#*&]{6,20}$/)){
			$("#new_pwd").siblings('.msg').prepend("<font style='color:#DC143C'>密码格式不正确：6-20位字母/数字/字符组合</font>");
			return false;
		}
		else {
			return true;
		}
	}
}

function update_confPwd(){
	var Npwd = $("#new_pwd").val().trim();
	var Cpwd = $("#comfirm_pwd").val().trim();
	$("#comfirm_pwd").siblings(".msg").find("font").remove();
	if(Npwd != Cpwd){
		$("#comfirm_pwd").siblings('.msg').prepend("<font style='color:#DC143C'>两次输入的密码不一致</font>");
		return false;
	}
	else{
		return true;
	}
}

function imgPreView(fileDom) {
	//判断是否支持FileReader
	if(window.FileReader){
		var reder = new FilerReader();
	}
	else{
		alert("您的设备不支持图片预览功能，请换用其他浏览器");
	}
	
	//获取文件
	var file = fileDom.files[0];
	var imageType = /^image\//;
	//是否是图片
	if(!imageType.test(file.type)){
		alert("请选择图片");
		return;
	}
	
	//读取完成
	reader.onload = function(e) {
		//获取图片dom
		var img = document.getElementById("preview");
		//图片路径设置为读取的图片
		img.src = e.target.result;
	};
	reader.readAsDataURL(file);
}

function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg); //匹配目标参数
	if (r != null) return unescape(r[2]);
	return null; //返回参数值
}