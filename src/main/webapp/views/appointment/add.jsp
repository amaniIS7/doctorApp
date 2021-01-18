<jsp:include page="../shared/_layout.jsp" />

<form action="${appName}appointment/add" method="post">

	<div class="form-group">
		<label>patient Name</label> <input type="text" name="patientName" class="form-control">
	</div>

	<div class="form-group">
		<label>Reason For Appointment </label> <input type="text" name="reasonForAppointment" class="form-control">
	</div>

	<div class="form-group">
		<label>Date </label> <input type="date" name="date"  class="form-control">
	</div>

<div class="form-group">
		<label>Doctors</label>
		<select name="doctor" class="form-control">
			<c:forEach items="${doctors}" var="doctor">
				<option value="${doctor.id}"> ${doctor.name} </option>
			</c:forEach>	
		</select>
	</div>

	<button type="submit" class="btn btn-primary">Submit</button>

</form>