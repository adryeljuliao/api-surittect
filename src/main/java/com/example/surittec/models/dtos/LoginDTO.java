package com.example.surittec.models.dtos;

public class LoginDTO {

	private String cpf;
	private String password;
	
	public LoginDTO() {
		
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
