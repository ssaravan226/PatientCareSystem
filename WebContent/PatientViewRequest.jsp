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
<form method="POST" action="ViewPatient">
<div class="Header">
    <div class="bannerImg"></div>
    <div class="HeaderText"><label style="font-family:Calibri;font-size:80px;font-style:italic;">Patient Care System</label></div>
</div>

<div class="InfoDiv">
    <div class="LabelCol" style="width:50%;float:left">
                <div id="PatientName">
                    <label>Patient's Name</label>
                </div>
                <div id="DocName">
                    <label>Docotor's Name</label>
                </div>
                <div id="Symptoms">
                    <label>Symptoms</label>
                </div>
    </div>
    <div class="textboxCol" style="width:50%;float:left">
                <div id="PatientsTextBox">
                   <div style="color:green">${name}</div>
                </div>
                <div id="DocNameTextBox">
                   <div style="color:green">${doctor}</div>
                </div>
                <div id="SymptomsTextBox">
                   <div style="color:green">${symptom}</div>
                </div>
    </div>
</div>
<div class="PrescriptionDiv">
    <div style="width:100%;text-align:center">Prescription</div>
    <table style="width: 100%;">
        <tr>
            <td style="text-align:center">Drug</td>
            <td style="text-align:center">Dosage</td>
            <td style="text-align:center">Frequency</td>
        </tr>
        <tr>
            <td><div style="color:green">${drug}</div></td>
            <td><div style="color:green">${dosage}</div></td>
            <td><div style="color:green">${frequency}</div></td>
        </tr>
    </table>
</div>
<br/>
<div style="color:red">${errorMessage}</div>
<div class="CommentsDiv">
<label>Comments</label>
	<br/>
	<div style="color:green">${comment}
	<br/>
</div>


	<div class="UpdateComment">
        <label>Enter Comment</label>
        <input id="Text10" type="text" name="commentUpdate"/>
    </div>
    <div class="SubmitBtn">
        <input id="Submit1" type="submit" value="submit" />
    </div>
    <div class="Footer"></div>
</div>
</form>
</body>
</html>