<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Password</title>
</head>
<jsp:useBean id="msg" class="java.lang.String" scope="request"></jsp:useBean>
<body>
<form action="./updatepassword" method="post" style="width: 200px; height: 400px; background-color=yellow; margin-top: 100px; margin-left: 500px">
<h3 style="color: red">Update Password Here</h3>
		<h4><%=msg %></h4>
		<span style="color: red;float: left"><a href="./home">HOME</a><a href="./logout"></span><span style="color: red;float: right">Logout</span></a>
		<br><br>
		New Password:<input type="password" name="newpass" placeholder="Enter New Password"><br><br><br>
		Confirm Password:<input type="password" name="confirm" placeholder="Confirm Password">
		<br><br>
		<input type="submit" value="Update" style="color: blue;float: right">
	</form>
</body>
</html>