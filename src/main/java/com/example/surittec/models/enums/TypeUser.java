package com.example.surittec.models.enums;

public enum TypeUser {
	
	ADMIN(0, "Administrador"),
	CLIENT(1, "Cliente");
	
	private int code;
	private String description;
	
	private TypeUser(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static TypeUser toEnum(Integer code) {
		if (code == null) {
			return null;
		}
		
		for (TypeUser typeUser : TypeUser.values()) {
			if (code.equals(typeUser.getCode())) {
				return typeUser;
			}
		}
		
		throw new IllegalArgumentException("Código inválido: " + code);
	}
	
}
