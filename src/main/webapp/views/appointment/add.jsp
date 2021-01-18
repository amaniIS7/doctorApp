<jsp:include page="../shared/_layout.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<form action="${appName}appointment/add" method="post">
	<div class="form-group">
		<label>Appointment Date</label><input type="date" name="date" class="form-control">
	</div>
	<div>
		<label>patient Name</label><input type="text" name="patientName" class="form-control">
	</div>
	<div>
		<label>reason For Appointment</label><input type="text" name="reasonForAppointment" class="form-control">
	</div>
	<label>Doctor</label> <select name="doctor"  class="form-control">
			<c:forEach items="${doctors}" var="doctor">
				<option value="${doctor.id}">${doctor.name}</option>
			</c:forEach>
			</select>
			<br>
	<button type="submit"  class="btn btn-primary" >SUBMIT</button>
</form>