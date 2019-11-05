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
					$("#settings_mail").attr("placeholder",result.mail);
					$("#settings_name").val(result.nickName);
					if(0 == result.sex){
						$("#myInfo input[type='radio']:first").attr('checked', 'true');
					}
					else{
						$("#myInfo input[type='radio']:last").attr('checked', 'true');
					}
					$("#settings_phone").val(result.phone);
					$("#settings_city").val(result.city);
					$("#settings_signature").text(result.signature);
				}
				else{
					$(".user a").text("游客" + result.id);
				}
				$(".user a").attr("href","UserSettings.html?userId=" + result.id);
			}
		}
	});
}