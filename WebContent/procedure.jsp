<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="styles" href="styles.css">
<title>Plastic</title>
</head>
<body>
	<h2>Plastic Surgery</h2>
<ul>
	<li><a href="getProcedures.do">View procedures</a></li>
	<li><a href="getCountries.do">View Countries</a></li>
	<li><a href="getFacilities.do">View Facilities</a></li>
	<li><a href="getDoctors.do">View Doctors</a></li>
</ul>
	<c:choose>
	<c:when test="${not empty procedures}">
		<form action="goToAddProcedureForm.do">
			<input type="submit" value="Add New Procedure" />
		</form>
	</c:when>
	<c:when test="${not empty countries}">
		<form action="goToAddCountryForm.do">
			<input type="submit" value="Add New Country" />
		</form>
	</c:when>
	<c:when test="${not empty facilities}">
		<form action="goToAddFacilityForm.do">
			<input type="submit" value="Add New Facility" />
		</form>
	</c:when >
	<c:when test="${not empty doctors}">
	<form action="goToAddDoctorForm.do">
			<input type="submit" value="Add New Doctor" />
		</form>
	</c:when>
	</c:choose>
	<c:forEach var="procedure" items="${procedures}">
		<form action="removeProcedure.do">
			${procedure.procedureName} 
			<input type="hidden" name="name" value="${procedure.procedureName}" /> 
			<input type="submit" value="Remove" />
		</form>
	<%-- 	<form action="getProcedureByName.do">
			<input type="hidden" name="name" value="${procedure.procedureName}" /> 
			<input type="submit" value="Get Procedure" />
		</form> --%>
		<a href="goToProcedureForm.do?name=${procedure.procedureName}">Update</a>
	</c:forEach>
	<c:forEach var="country" items="${countries}">
		<form action="removeCountry.do">
			${country.name } 
			<input type="hidden" name="name" value="${country.name}" /> 
			<input type="submit" value="Remove" />
		</form>
		<a href="goToCountryForm.do?name=${country.name}">Update</a>
	</c:forEach>
	<c:forEach var="doctor" items="${doctors}">
		<form action="removeDoctor.do">
			${doctor.name} 
			<input type="hidden" name="name" value="${doctor.name}" /> 
			<input type="submit" value="Remove" />
		</form>
		<a href="goToDoctorForm.do?name=${doctor.name}">Update</a>
	</c:forEach>
	<c:forEach var="facility" items="${facilities}">
		<form action="removeFacility.do">
			${facility.name}
			${facility.address} 
			<input type="hidden" name="name" value="${facility.name}" /> 
			<input type="submit" value="Remove" />
		</form>
		<a href="goToFacilityForm.do?name=${facility.name}">Update</a>
	</c:forEach>
	<c:forEach var="country" items="${procedure.listOfCountries}">
		<form action="getProcedureByName.do">
			${country.name} 
			<input type="submit" value="Remove" />
		</form>
	</c:forEach>


</body>
</html>