<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../shared/_layout.jsp" />

Pationt Name : ${appointment.patientName} <br>
Reason For Appointment: ${appointment.reasonForAppointment} <br>

Date of Appointment: ${appointment.date} <br><br>

With Doctor: ${appointment.doctor.name}



