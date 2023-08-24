package com.nttdata.local.excepciones;

import java.util.Objects;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ExcepClienteNoExiste extends RuntimeException{
	
	private String code;
	private HttpStatus status;
	public ExcepClienteNoExiste(String code, HttpStatus status, String message) {
		super(message);
		this.code = code;
		this.status = status;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExcepClienteNoExiste other = (ExcepClienteNoExiste) obj;
		return Objects.equals(code, other.code) && status == other.status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, status);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
