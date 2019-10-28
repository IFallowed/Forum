function load(){
	//加载全局文件
	//bootstrap引用
	//loadStyles("https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css")
	//loadScript("https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js")
	//loadScript("https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js")
	//全局css样式
	//loadStyles("../../css/Frame.css")
	//iconFont引用
	loadScript("https://at.alicdn.com/t/font_1457444_10ldj8elo38p.js")
	
	//
	for(var i = 0; i < arguments.length;i++) {
		if(arguments[i].endWith("css")) {
			loadStyles(arguments[i]);
		}
		if(arguments[i].endWith("js")) {
			loadScript(arguments[i]);
		}
	}
	
}

//动态加载s文件 
function loadScript(url) {                          
    var script = document.createElement("script");  
    script.type = "text/javascript";                
    script.src = url;                               
    document.getElementsByTagName("head")[0].appendChild(script); 
}                                                   
// 测试                                             
//loadScript("../js/zz.js");

//动态加载css文件                                              
function loadStyles(url) {                                     
  var link = document.createElement("link");                 
  link.type = "text/css";                                    
  link.rel = "stylesheet";                                   
  link.href = url;                                           
  document.getElementsByTagName("head")[0].appendChild(link);
}                                                              
// 测试                                                        
//loadStyles("../css/qw.css"); 

//实现String.endWith方法
String.prototype.endWith=function(str){
	if(str==null||str==""||this.length==0||str.length>this.length)
	  return false;
	if(this.substring(this.length-str.length)==str)
	  return true;
	else
	  return false;
	return true;
	}

//实现String.startWith方法
String.prototype.startWith=function(str){
	if(str==null||str==""||this.length==0||str.length>this.length)
	  return false;
	if(this.substr(0,str.length)==str)
	  return true;
	else
	  return false;
	return true;
	}