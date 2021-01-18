<jsp:include page="../shared/_layout.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table class="table table-striped">
<tr>
<th> Appointment's Date </th>
<th> patient Name </th>
<th> reason For Appointment </th>
<th> Action </th>

</tr>
<c:forEach items="${appointments}" var="appointment">
<tr>
<td>${appointment.date}</td>
<td>${appointment.patientName}</td>
<td>${appointment.reasonForAppointment}</td>
<td>
		
		 <a href="${appName}appointment/delete?id=${appointment.id}">Delete</a> 
		</td>
	</tr>
	</c:forEach>
</table>