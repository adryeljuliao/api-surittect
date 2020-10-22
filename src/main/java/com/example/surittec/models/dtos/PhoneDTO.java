package com.example.surittec.models.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.example.surittec.models.Phone;
import com.example.surittec.models.enums.TypePhone;

public class PhoneDTO {

	@Min(0)
	@Max(2)
	private Integer typeCode;
	@NotEmpty(message = "O campo telefone é obrigatório.")
	private String phone;

	public PhoneDTO() {
	}

	public Phone phoneDtoToPhone() {
		TypePhone phoneType = TypePhone.toEnum(typeCode);
		Phone phone = new Phone(phoneType, this.phone);
		
		return phone;
	}
	
	public PhoneDTO(Integer typeCode, String phone) {
		super();
		this.typeCode = typeCode;
		this.phone = phone;
	}

	public Integer getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(Integer typeCode) {
		this.typeCode = typeCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
