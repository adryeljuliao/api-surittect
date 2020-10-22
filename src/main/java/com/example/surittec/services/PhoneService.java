package com.example.surittec.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.surittec.models.Phone;
import com.example.surittec.models.User;
import com.example.surittec.repositories.PhoneRepository;

@Service
public class PhoneService {
	
	private static final Logger LOG = LoggerFactory.getLogger(User.class);
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	public void save(Phone phone) {
		phoneRepository.save(phone);
		LOG.info("telefone salvo com sucesso");
	}
	
	public void delete(Phone phone) {
		phoneRepository.delete(phone);
	}
	
	

}
