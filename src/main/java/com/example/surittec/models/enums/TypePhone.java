package com.example.surittec.models.enums;

public enum TypePhone {

	RESIDENTIAL(0, "Residencial"), 
	COMMERCIAL(1, "Comercial"), 
	PHONE(2, "Celular");

	private int code;
	private String description;

	private TypePhone(int code, String description) {
		this.code = code;
		this.description = description;
	} 

	public int getCode() {
		return code;
	}

	public String getDescription() { 
		return description;
	}
	
	public static TypePhone toEnum(Integer code) {
		if (code == null) {
			return null;
		}
		
		for (TypePhone typePhone : TypePhone.values()) {
			if (code.equals(typePhone.getCode())) {
				return typePhone;
			}
		}
		
		throw new IllegalArgumentException("Código inválido: " + code);
	}

}
