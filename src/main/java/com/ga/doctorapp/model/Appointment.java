package com.ga.doctorapp.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="Appointment")
public class Appointment {

	 @Id
	  @GeneratedValue
	  private int id;
	  private String patientName;
	  private Date date;
	  private String reasonForAppointment;

		@ManyToOne
		@JoinColumn(name = "FK_doctorId")
		private Doctor doctor;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getReasonForAppointment() {
		return reasonForAppointment;
	}

	public void setReasonForAppointment(String reasonForAppointment) {
		this.reasonForAppointment = reasonForAppointment;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	
}
