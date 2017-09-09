<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(document).ready(
		function(){
			$(".res").hide();
		}
	);
	function getRes(){
		$(".res").toggle();
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${formula }" var="f">
		<c:out value="${f}"/><br/>
		请输入答案:<input type="text" style="width:50px"/><br>
		<div class="res"><c:out value="${f.result }"/></div>
	</c:forEach>
	<br/>
	<input type="button" id="input" onclick="getRes()" value="显示/隐藏答案"/>
</body>
</html>