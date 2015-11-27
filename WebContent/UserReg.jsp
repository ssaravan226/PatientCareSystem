<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="StyleSheet.css" type="text/css">
<body>
<form method="POST" action="UserReg.do">
<div class="Header">
    <div class="bannerImg"></div>
    <div class="HeaderText"><label style="font-family:Calibri;font-size:80px;font-style:italic;">Patient Care System</label></div>
</div>

<div class="UserReg">
        <h5>User Registration Form</h5>
        <div class="RegForm">
            <div class="LabelCol" style="width:50%;float:left">
                <div id="FirstName">
                    <label>First Name</label>
                </div>
                <div id="LastName">
                    <label>Last Name</label>
                </div>
                <div id="Email">
                    <label>Email</label>
                </div>
                <div id="Pwd">
                    <label>Password</label>
                </div>
                <div id="ConfirmPwd">
                    <label>Confirm Password</label>
                </div>
                <div id="Address">
                    <label>Address</label>
                </div>
                <div id="ContactNum">
                    <label>Contact Number</label>
                </div>
                <div id="EmergContactName">
                    <label>Emergency Contact Name</label>
                </div>
                <div id="EmergContactNum">
                    <label>Emergency Contact Number</label>
                </div>
                <div id="Role">
                    <label>Role</label>
                </div>
                <div id="Security Question">
                    <label>Question</label>
                </div>
                <div id="Security Answer">
                    <label>Answer</label>
                </div>
            </div>
            <div class="textboxCol" style="width:50%;float:left">
                <div id="FirstNameTextBox">
                   <input id="Text1" type="text" name="FirstNameTextBox" />
                </div>
                <div id="LastNameTextBox">
                    <input id="Text2" type="text" name="LastNameTextBox" /> 
                </div>
                <div id="EmailTextBox">
                    <input id="Text3" type="text" name="EmailTextBox" />
                </div>
                <div id="PwdTextBox">
                    <input id="Text4" type="text" name="PwdTextBox" />
                </div>
                <div id="ConfirmPwdTextBox">
                    <input id="Text5" type="text"name="ConfirmPwdTextBox" />
                </div>
                <div id="AddrTextArea">
                    <input id="Text6" type="text" name="AddrTextArea" />
                </div>
                <div id="ConNumTextBox">
                    <input id="Text7" type="text" name="ConNumTextBox" />
                </div>
                <div id="ECNameTextBox">
                    <input id="Text8" type="text" name="ECNameTextBox" />
                </div>
                <div id="ECNumTextBox">
                    <input id="Text9" type="text" name="ECNumTextBox" />
                </div>
                <div class="RoleDropdown">
                    <select name="Role">
                    <option value="1">Patient</option>
                    <option value="2">Doctor</option>
                    <option value="3">Nurse</option>
                    <option value="4">Admin</option>
                    </select> 
                </div>
                <div id="SecurityQuestion">
                    <input id="Text9" type="label" name="SecurityQuestion" />
                </div>
                <div id="SecurityAnswer">
                    <input id="Text9" type="text" name="SecurityAnswer" />
                </div>
            </div>
            <input id="Submit1" type="submit" value="Register" />
        </div>
        <div style="color:red">${errorMessage}</div>
    </div>
    <div class="Footer"></div>
</div>
    </form>>
</body>
</html>
