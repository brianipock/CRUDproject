<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="updateDoctor.do">
<input type="hidden" name="name" value="${doctorName}">
<h2>Update the Doctor Name</h2>
<h4>Update the Doctor's First Name</h4>
<input type="text" name="fname" />
<h4>Update the Doctor's Last Name</h4>
<input type="text" name="lname" />
<h4>Update the Doctor's Gender</h4>
<input type="text" name="gender" />
<input type="submit" value="Submit" />
</form>
</body>
</html>