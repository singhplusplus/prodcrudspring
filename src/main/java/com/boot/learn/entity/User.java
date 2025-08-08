package com.boot.learn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Table(
		name = "kcm_user",
		uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

	@Id
	@SequenceGenerator(
			name = "kcm_user_sequence",
			sequenceName = "kcm_user_sequence",
			allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kcm_user_sequence")
	private Long userId;

	@NotBlank @Email
	private String email;

	@NotBlank
	private String fullName;

	@NotBlank @Size(min = 8, max=40)
	private String password;

	private String role;

}
