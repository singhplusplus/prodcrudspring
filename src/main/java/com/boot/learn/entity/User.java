package com.boot.learn.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class User {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@NotBlank @Email
	private String email;

	@NotBlank
	private String fullName;

	@NotBlank @Size(min = 8, max=40)
	private String password;

	private String role;

}
