<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<link rel="stylesheet" href="StyleSheet.css" type="text/css">
<form method="POST" action="MedicalHistory.do">
<div class="Header">
    <div class="bannerImg"></div>
    <div class="HeaderText"><label style="font-family:Calibri;font-size:80px;font-style:italic;">Patient Care System</label></div>
</div>

<body>
    <h5>Medical History</h5>
    <div class="DivMedHistory">
        <div class="row1">
            <label >Are you under a physician's care now? </label>
            <input id="Radio1" type="radio" name="radiocare" value="Y" />Yes
            <input id="Radio2" type="radio" name="radiocare" value="N" />No
        </div>
        <div class="CommonRow">
            If yes please explain : <textarea id="TextArea1" cols="20" rows="2" name="CareExplanation"></textarea>
        </div>

        <div class="row2">
            <label>Have you ever been hospitalized or had a moajor operation? </label>
            <input id="Radio3" type="radio" name="radiosurgery" value="Y" />Yes
            <input id="Radio4" type="radio" name="radiosurgery" value="N" />No
        </div>
        <div class="CommonRow">
            If yes please explain : <textarea id="TextArea2" cols="20" rows="2" name="surExplanation"></textarea>
        </div>

        <div class="row3">
            <label>Are you taking any medication, pills or drugs? </label>
            <input id="Radio5" type="radio" name="radiomedication" value="Y" />Yes
            <input id="Radio6" type="radio" name="radiomedication" value="N" />No
        </div>
        <div class="CommonRow">
            If yes please explain : <textarea id="TextArea3" cols="20" rows="2" name="medExpanation"></textarea>
        </div>
         <div class="row4">
            <label>Do you use tobacoo? </label>
            <input id="Radio7" type="radio" name="radiotobacco" value="Y" />Yes
            <input id="Radio8" type="radio" name="radiotobacco" value="N" />No
        </div>
         <div class="row5">
            <label>Are you allergic to any of the following? </label>
             <input id="Checkbox1" type="checkbox" value="Aspirin" name="chkallergy" />Asprin
             <input id="Checkbox2" type="checkbox" value="Pencilin" name="chkallergy" />Pencilin
             <input id="Checkbox3" type="checkbox" value="Codeine" name="chkallergy" />Codeine
             <input id="Checkbox4" type="checkbox" value="Latex" name="chkallergy" />Latex
             <input id="Checkbox5" type="checkbox" value="Other" name="chkallergy" />Other
        </div>
         <div class="CommonRow">
            If yes please explain : <textarea id="TextArea4" cols="20" rows="2" name="allerExplanation"></textarea>
        </div>
        <input id="Submit1" type="submit" value="submit" />
      </div>
      <div style="color:red">${errorMessage}</div>
      <div class="Footer"></div>
</div>
      </form>
</body>
</html>