<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add a New Doctor</title>
</head>
<body>
	<form action="addDoctor.do">
		<h2>Add a New Doctor</h2>
		<h4>Add the Doctors First Name</h4>
		<input type="text" name="fname" />
		<h4>Add the Doctors Last Name</h4>
		<input type="text" name="lname" />
		<h4>Add the Doctors Gender</h4>
		<input type="text" name="gender" /> <input type="submit"
			value="Submit" />
	</form>
</body>
</html>