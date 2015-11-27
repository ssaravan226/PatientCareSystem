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
<form method="POST" action="Symptom.do">
<div class="Header">
    <div class="bannerImg"></div>
    <div class="HeaderText"><label style="font-family:Calibri;font-size:80px;font-style:italic;">Patient Care System</label></div>
</div>

<div class="SymptomForm">
            <div class="LeftCol" style="width:50%;float:left">
                <div id="PatientName">
                    <label>Patient's Name</label>
                </div>
                <div id="PatientsDoc">
                    <label>Patient's Doctor</label>
                </div>
                <div class="Symptom">
                    <label>Symptom 1</label>
                </div>
                <div class="PainLevel">
                    <label>Pain Level</label>
                </div>
                <div class="Symptom">
                    <label>Symptom 2</label>
                </div>
                <div class="PainLevel">
                    <label>Pain Level</label>
                </div>
                <div class="Symptom">
                    <label>Symptom 3</label>
                </div>
                <div class="PainLevel">
                    <label>Pain Level</label>
                </div>
                <div class="Symptom">
                    <label>Symptom 4</label>
                </div>
                <div class="PainLevel">
                    <label>Pain Level</label>
                </div>
                <div class="Symptom">
                    <label>Symptom 5</label>
                </div>
                <div class="PainLevel">
                    <label>Pain Level</label>
                </div>
                <div id="AddtionalInfo">
                    <label>Additional Information</label>
                </div>
            </div>
            <div class="RightCol" style="width:50%;float:left">
                <div id="PatientNameTextBox">
                   <div style="color:green">${name}</div>
                </div>
                <div id="PatientsDocTextBox">
                   <div style="color:green">${doctor}</div>
                </div>
                <div class="SymptomDropDown">
                    <select name="SymptomDD1">
                    <option value="ChestPain">Chest Pain</option>
                    <option value="Nausea">Nausea</option>
                    <option value="Fever">Fever</option>
                    <option value="HeadAche">Head Ache</option>
                    <option value="Skin Rash">Skin Rash</option>
                    <option value="Convolution">Convolution</option>
                    <option value="Blurred Vision">Blurred Vision</option>
                    </select> 
                </div>
                <div class="PainLevelDropDown">
                    <select name="PainLevelDD1">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    </select> 
                </div>
                <div class="SymptomDropDown">
                    <select name="SymptomDD2">
                    <option value="ChestPain">Chest Pain</option>
                    <option value="Nausea">Nausea</option>
                    <option value="Fever">Fever</option>
                    <option value="HeadAche">Head Ache</option>
                    <option value="Skin Rash">Skin Rash</option>
                    <option value="Convolution">Convolution</option>
                    <option value="Blurred Vision">Blurred Vision</option>
                    </select> 
                </div>
                <div class="PainLevelDropDown">
                    <select name="PainLevelDD2">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    </select> 
                </div><div class="SymptomDropDown">
                    <select name="SymptomDD3">
                    <option value="ChestPain">Chest Pain</option>
                    <option value="Nausea">Nausea</option>
                    <option value="Fever">Fever</option>
                    <option value="HeadAche">Head Ache</option>
                    <option value="Skin Rash">Skin Rash</option>
                    <option value="Convolution">Convolution</option>
                    <option value="Blurred Vision">Blurred Vision</option>
                    </select> 
                </div>
                <div class="PainLevelDropDown">
                    <select name="PainLevelDD3">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    </select> 
                </div><div class="SymptomDropDown">
                    <select name="SymptomDD4">
                    <option value="ChestPain">Chest Pain</option>
                    <option value="Nausea">Nausea</option>
                    <option value="Fever">Fever</option>
                    <option value="HeadAche">Head Ache</option>
                    <option value="Skin Rash">Skin Rash</option>
                    <option value="Convolution">Convolution</option>
                    <option value="Blurred Vision">Blurred Vision</option>
                    </select> 
                </div>
                <div class="PainLevelDropDown">
                    <select name="PainLevelDD4">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    </select> 
                </div><div class="SymptomDropDown">
                    <select name="SymptomDD5">
                   <option value="ChestPain">Chest Pain</option>
                    <option value="Nausea">Nausea</option>
                    <option value="Fever">Fever</option>
                    <option value="HeadAche">Head Ache</option>
                    <option value="Skin Rash">Skin Rash</option>
                    <option value="Convolution">Convolution</option>
                    <option value="Blurred Vision">Blurred Vision</option>
                    </select> 
                </div>
                <div class="PainLevelDropDown">
                    <select name="PainLevelDD5">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    </select>                 
                </div>
                <div id="AddtionalInfoTextArea">
                    <textarea id="TextArea1" cols="20" rows="2"></textarea>
                </div>                
            </div>            
            <input id="Submit1" type="submit" value="Submit" />
            <input id="Submit2" type="submit" value="Edit" />
        </div>
        <div style="color:red">${errorMessage}</div>
        <div class="MedHistory">
                <a href="http://localhost:8080/Patient_System/MedicalHistoryForm.jsp">Update Medical History</a>
            </div>
        <div class="ViewSymptom">
                <a href="http://localhost:8080/Patient_System/ViewPatient">Link to Most Recent Symptom</a>
         </div>
         <div class="Footer"></div>
</div>
   </form>
</body>
</html>