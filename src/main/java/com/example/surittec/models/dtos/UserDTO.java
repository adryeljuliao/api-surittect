package com.example.surittec.models.dtos;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.example.surittec.models.Address;
import com.example.surittec.models.Phone;
import com.example.surittec.models.User;
import com.example.surittec.models.enums.TypeUser;

public class UserDTO {

	@NotEmpty(message = "O campo nome é obrigatório.")
	@Size(min = 3, max = 100, message = "Campo nome deve ter no mínimo 3 caracteres e no máximo 100 caracteres")
	private String name;
	@NotEmpty(message = "O campo CPF é obrigatório.")
	private String cpf;
	@NotEmpty(message = "O campo CEP é obrigatório.")
	private String cep;
	@NotEmpty(message = "O campo logradouro é obrigatório.")
	private String place;
	@NotEmpty(message = "O campo bairro é obrigatório.")
	private String district;
	@NotEmpty(message = "O campo cidade é obrigatório.")
	private String city;
	@NotEmpty(message = "O campo UF é obrigatório.")
	private String uf;
	private String complement;
	@NotEmpty(message = "Pelo menos um telefone deve ser cadastrado.")
	@Valid
	private List<PhoneDTO> listPhones;
	@NotEmpty(message = "Pelo menos um e-mail deve ser cadastrado.")
	@Valid
	private Set<EmailDTO> listEmails;

	public UserDTO() {

	}

	public User userDtoToUser() {
		User user = new User();

		user.setName(name);
		user.setCpf(cpf);
		Address address = convertAddress();
		user.setAddress(address);
		address.setUser(user);
//		user.setListPhone();
		listEmails.stream().forEach(email -> user.getListEmail().add(email.getEmail()));
		user.setUserType(TypeUser.toEnum(1));
//		user.getListPhone().stream().forEach(phone -> user.addPhone(phone));
		toListPhone().stream().forEach(phone -> {
			user.addPhone(phone);
		});

		return user;
	}

	public List<Phone> toListPhone() {
		List<Phone> listPhones = this.listPhones.stream().map((phone) -> phone.phoneDtoToPhone())
				.collect(Collectors.toList());
		return listPhones;
	}

	public Address convertAddress() {
		return new Address(cep, place, district, city, uf, complement);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public List<PhoneDTO> getListPhones() {
		return listPhones;
	}

	public void setListPhones(List<PhoneDTO> listPhones) {
		this.listPhones = listPhones;
	}

	public Set<EmailDTO> getListEmails() {
		return listEmails;
	}

	public void setListEmails(Set<EmailDTO> listEmails) {
		this.listEmails = listEmails;
	}

}
