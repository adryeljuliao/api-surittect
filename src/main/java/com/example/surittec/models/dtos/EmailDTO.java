package com.example.surittec.models.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EmailDTO {

	@Email(message = "Campo de e-mail inválido")
	@NotEmpty(message = "Campo e-mail não pode ser vazio")
	private String email;

	public EmailDTO() {}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
