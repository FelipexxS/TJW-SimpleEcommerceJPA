package br.edu.ifce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Telefone {
	
	@Id
	@GeneratedValue
	private Long idtelefone;
	
	@Column
	private String numTelefone;


	public Long getIdtelefone() {
		return idtelefone;
	}


	public void setIdtelefone(Long idtelefone) {
		this.idtelefone = idtelefone;
	}


	public String getNumTelefone() {
		return numTelefone;
	}


	public void setNumTelefone(String numTelefone) {
		this.numTelefone = numTelefone;
	}

}
