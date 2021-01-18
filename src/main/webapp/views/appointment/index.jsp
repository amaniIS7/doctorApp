<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />

<table class="table table-striped">

	<tr>
		<th>patient Name</th>
		<th>Date</th>
		<th>reason For Appointment</th>
	</tr>

	<c:forEach items="${appointments}" var="appointment">
		<tr>
			<td><a href="${appName}appointment/detail?id=${appointment.id}">${appointment.patientName}</a></td>
			<td>${appointment.reasonForAppointment}</td>
			<td>${appointment.date}</td>

			
				<td><a href="${appName}appointment/delete?id=${appointment.id}">Delete</a></td>
		</tr>
	</c:forEach>
</table>