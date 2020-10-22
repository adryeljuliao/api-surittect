package com.example.surittec.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;

	private List<FieldMessage> erros = new ArrayList<>();
	public ValidationError(Integer status, String message, Long timeStamp) {
		super(status, message, timeStamp);
		// TODO Auto-generated constructor stub
	}
	public List<FieldMessage> getErros() {
		return erros;
	}
	public void addErro(String fieldName, String message) {
		this.erros.add(new FieldMessage(fieldName, message));
	}
	
	

}
