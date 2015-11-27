<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
<link rel="stylesheet" href="StyleSheet.css" type="text/css">
<script src="jquery-1.8.2.min.js" type="text/javascript"></script>
<script type="text/javascript">

    $(document).ready(function () {

        //Default Action
        $(".tab_content").hide(); //Hide all content
        $("ul.tabs li:first").addClass("active").show(); //Activate first tab
        $(".tab_content:first").show(); //Show first tab content

        //On Click Event
        $("ul.tabs li").click(function () {
            $("ul.tabs li").removeClass("active"); //Remove any "active" class
            $(this).addClass("active"); //Add "active" class to selected tab
            $(".tab_content").hide(); //Hide all tab content
            var activeTab = $(this).find("a").attr("href"); //Find the rel attribute value to identify the active tab + content
            $(activeTab).fadeIn(); //Fade in the active content
            return false;
        });

    });
</script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#tab1").load("SymptomForm.jsp");
        $("#tab2").load("http://localhost:8080/Patient_System/ViewPatient");
    });
</script>
</head>
<body>

<div class="MainDiv">

<div class="container">
  <ul class="tabs">
    <li><a href="#tab1">Enter Symptom</a></li>
    <li><a href="#tab2">View Symptom</a></li>
  </ul>
  <div class="tab_container">
    <div id="tab1" class="tab_content">
    </div>
    <div id="tab2" class="tab_content">
    </div>
  </div>
</div>


</body>
</html>