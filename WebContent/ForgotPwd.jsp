<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>>
</head>
<link rel="stylesheet" href="StyleSheet.css" type="text/css">
<body>
<form method="POST" action="ForgotPwd.do">
<div class="Header">
    <div class="bannerImg"></div>
    <div class="HeaderText"><label style="font-family:Calibri;font-size:80px;font-style:italic;">Patient Care System</label></div>
</div>

<label>Forgot your password?</label>
	<br/>
    <label>Please answer the following security question</label>
    <label>A new password will be emailed to you for the next Login.</label>
    <br/>
    <label>Email</label>
    <br/>
    <input id="Text1" type="text" name="email" />
    <br/>
    <label>What is your pet name?</label>
    <br/>
    <input id="Text2" type="password" name="answer" />
    <br/>
    <input id="Submit1" type="submit" value="submit" />
    <div style="color:red">${errorMessage}</div>
    <div class="Footer"></div>
</div>
</form>
</body>
</html>