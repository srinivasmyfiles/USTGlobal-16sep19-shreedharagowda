<%@ page language='java' contentType='text/html; charset=ISO-8859-1'
    pageEncoding='ISO-8859-1'%>
    <jsp:useBean id="msg" class="java.lang.String" scope="request"></jsp:useBean>
    <%@page session="false" %>
    <jsp:useBean id="msg1" class="java.lang.String" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset='ISO-8859-1'>
<title>Insert title here</title>
</head>
<%
String id="";
Cookie[] cookies=request.getCookies();
if(cookies!=null) {
	for (Cookie cookie : cookies) {
		if(cookie.getName().equals("alwaysremember")) {
			id=cookie.getValue();
		}	
	}
}
%>
<body>
<form action='./login' method='post' style='width: 200px; height: 400px; margin-top: 100px; margin-left: 500px'>
		   <h3 style='color: red'>Login Here</h3>
		   <%=msg %>
		   <%=msg1 %>
		   name :<input type='text' name='id' placeholder='Enter UserID' value='<%=id%>'><br><br>
		password:<input type='password' name='password' placeholder='Enter Password'> <br>
		<input style='margin-left: 50px' type='checkbox' value='checked' name='remember'>Remember Me
		<br> <input type='submit' name='submit' value='Login' style='color: blue;'><br>
		<br> <a style='float: left' href='register.html'>Register</a>
	</form>
</body>
</html>