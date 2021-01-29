<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />

<table class="table table-striped">

	<tr>
		<th>Doctor Name</th>
		<th>Email Address</th>
		<th>Gender</th>
		<th>Date of Birth</th>
		
		<th>specialty</th>
			<% if(session.getAttribute("user") != null) { %>
		<th>Actions</th>
		<% } %>
	</tr>

	<c:forEach items="${doctors}" var="doctor">
		<tr>
			<td><a href="${appName}doctor/details?id=${doctor.id}">${doctor.name}</a></td>
			<td>${doctor.emailAddress}</td>
			<td>${doctor.gender}</td>
			<td>${doctor.dateofBirth}</td>
             <td>${doctor.specialty}</td>
       
					</tr>
	</c:forEach>
</table>