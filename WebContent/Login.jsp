<%@ page import="java.util.*" %>
<%@ page contentType="text/html; charset=ISO-8859-1" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="StyleSheet.css" type="text/css">
<body>
<form method="POST" action="Login.do">
<div class="MainDiv">
<div class="Header">
    <div class="bannerImg"></div>
    <div class="HeaderText"><label style="font-family:Calibri;font-size:80px;font-style:italic;">Patient Care System</label></div>
</div>
<div class="LoginBox">	
    <div class="LoginRow">
        <label>Email</label>
        <input id="Text1" type="text" name="email"/>
    </div>
    <div class="PwdRow">
        <label>Password</label>
        <input id="Text2" type="password" name="pwd"/>
    </div>
    <div class="ForgotPwdRow">
        <a href="http://localhost:8080/Patient_System/ForgotPwd.jsp">Forgot Password</a>
        <a href="http://localhost:8080/Patient_System/UserReg.jsp">New User</a>
    </div>
    <div class="SubmitBtn">
        <input id="Submit1" type="submit" value="submit" />
    </div>
</div>
<div class="Footer"></div>
</div>
<div style="color:red">${errorMessage}</div>

</form>


</body>
</html>