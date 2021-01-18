package com.ga.doctorapp.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="Doctor")
public class Doctor {
	 @Id
	  @GeneratedValue
	  private int id;
	  private String name;
	  private String emailAddress;
	  
	 @Column(length = 50)
	 private String gender;
	 private Date dateofBirth;
	 private String specialty;

		@OneToMany(mappedBy="doctor")
		private Set<Appointment> Appointment;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public Date getDateofBirth() {
			return dateofBirth;
		}

		public void setDateofBirth(Date dateofBirth) {
			this.dateofBirth = dateofBirth;
		}

		public String getSpecialty() {
			return specialty;
		}

		public void setSpecialty(String specialty) {
			this.specialty = specialty;
		}

		public Set<Appointment> getAppointment() {
			return Appointment;
		}

		public void setAppointment(Set<Appointment> appointment) {
			Appointment = appointment;
		}
	
	
}
