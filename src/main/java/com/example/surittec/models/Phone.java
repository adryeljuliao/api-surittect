package com.example.surittec.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.surittec.models.enums.TypePhone;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table
public class Phone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer phoneType;
	private String phone;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Phone(TypePhone phoneType, String phone) {
		super();
		this.phoneType = phoneType.getCode();
		this.phone = phone;
	}

	public Phone() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypePhone getPhoneType() {
		return TypePhone.toEnum(phoneType);
	}

	public void setPhoneType(TypePhone phoneType) {
		this.phoneType = phoneType.getCode();
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
