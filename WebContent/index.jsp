<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function sub(){
		var flagNumber = document.getElementById("flagNumber").value;
		if(flagNumber=="")
			document.getElementById("flagNumber").value="2";
		else 
			if(parseInt(flagNumber)<2){
				alert("参数个数必须大于等于2");
				return;
			}
		document.f.submit();
	}
</script>
<body>
	点击生成按钮生成算式<br/>
	<form action="calculator.do" name="f">
		请输入参数个数(默认为2):<input type="text" name="flagNumber" id="flagNumber"/><br>
		<input type="button" value="提交" onclick="sub()"/>
	</form>	
	
</body>
</html>