<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body  {
    background-image: url("paper.gif");
    background-color: #cccccc;
}
form {
    border: 3px solid #f1f1f1;
}
input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}
button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}
.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="CreateModule.jsp" class="btn btn-info" role="button">Create Module</a>|
<a href="ViewModule.jsp" class="btn btn-info" role="button">View Module</a><br><hr>

<body>

<h2>Module Form</h2>

<form action="ModuleRegisterAndViewServlet" name="myForm" method="post">
  <input type="hidden" name="registerForm" value="registerForm">

  <div class="container">
    <label><b>Module Code</b></label>
    <input type="text" placeholder="Enter module Code" name="mcode" required>

    <label><b>Module Name</b></label>
    <input type="text" placeholder="Enter module Name" name="mname" required>
        
    <label><b>No Of Hours</b></label>
    <input type="text" placeholder="Enter no of hours" name="mhours" required>
    
    <button type="submit" val>Create Module</button>
    <button type="reset">Reset</button>
    <input type="checkbox" name="status" checked="checked"> Is Module Active
  </div>

  
</form>

</body>
</html>

</body>
</html>