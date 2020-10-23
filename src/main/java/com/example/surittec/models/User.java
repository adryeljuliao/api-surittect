package com.example.surittec.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.surittec.models.enums.TypeUser;

@Entity
@Table(name = "s_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private Integer userType;
	private String cpf;
	private String password;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	private Address address;

	@OneToMany(mappedBy = "user")
	@ElementCollection
	@CollectionTable(name = "phone")
	@Column(name = "phone")
	private List<Phone> listPhone;

	@ElementCollection
	@CollectionTable(name = "email")
	@Column(name = "email")
	private Set<String> listEmail;

	public User() {
		listPhone = new ArrayList<>();
		listEmail = new HashSet<>();
	}

	public User(String name, TypeUser userType, String cpf, String password, Address address) {
		super();
		this.name = name;
		this.userType = userType.getCode();
		this.cpf = cpf;
		this.address = address;
		this.password = password;
	}

	public void addPhone(Phone phone) {
		listPhone.add(phone);
		phone.setUser(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public TypeUser getUserType() {
		return TypeUser.toEnum(userType);
	}

	public void setUserType(TypeUser userType) {
		this.userType = userType.getCode();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Phone> getListPhone() {
		return listPhone;
	}

	public void setListPhone(List<Phone> listPhone) {
		this.listPhone = listPhone;
	}

	public Set<String> getListEmail() {
		return listEmail;
	}

	public void setListEmail(Set<String> listEmail) {
		this.listEmail = listEmail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
