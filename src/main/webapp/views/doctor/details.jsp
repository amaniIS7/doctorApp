<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />

Doctor Name: ${doctor.name} <br>
Email Address: ${doctor.emailAddress} <br>

Gender: ${doctor.gender} <br>
Date of Birth: ${doctor.dateofBirth} <br><br>






<table>
	<c:forEach items="${doctor. getAppointment()}" var="appointment">
		<tr>
			<td> Patient Name ${appointment.patientName} </td>
		</tr>
		<tr>
			<td>reason For Appointment ${appointment.reasonForAppointment} </td>
		</tr>
			
	</c:forEach>
</table>