package com.ga.doctorapp.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "User")
public class User {
	
		@Id
		@GeneratedValue
		private int id;
		private String firstName;
		private String lastName;
		private String emailAddress;
		private String password;
		private String userRole;
		
		@Column(name="createdAt", nullable = false, updatable = false)
		@CreationTimestamp
		private LocalDateTime createAt;
		
		@Column(name="updatedat", nullable = false, updatable = true)
		@UpdateTimestamp
		private LocalDateTime updateAt;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public LocalDateTime getCreateAt() {
			return createAt;
		}

		public void setCreateAt(LocalDateTime createAt) {
			this.createAt = createAt;
		}

		public LocalDateTime getUpdateAt() {
			return updateAt;
		}

		public void setUpdateAt(LocalDateTime updateAt) {
			this.updateAt = updateAt;
		}

		public String getUserRole() {
			return userRole;
		}

		public void setUserRole(String userRole) {
			this.userRole = userRole;
		}
		

	}