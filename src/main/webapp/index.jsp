<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=path%>/resources/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#formbutton').on('click', function(e) {
			$.ajax({
				url:'<%=path%>/testServlet',
				data:{user:'xxx',password:'bbbb'},
				type:'GET',
				datetype:'text',
				success:function(data){
					alert('xxxx yyyy');
				}
			})
		})
	});
</script>
</head>
<body>
	<h1>index1</h1>

	<form action="post">
		<input type="button" id="formbutton" value="XXXXXX" />
	</form>
</body>
</html>