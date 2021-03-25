package br.edu.ifce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue
	private int idproduto;
	
	@Column (unique = true, nullable = false)
	private String nome_produto;
	
	@Column
	private Double preco_produto;
	
	@Column
	private String departamento;

	public int getIdproduto() {
		return idproduto;
	}
	
	public void setIdproduto(int idproduto) {
		this.idproduto = idproduto;
	}
	
	public String getNome_produto() {
		return nome_produto;
	}
	
	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}
	
	public Double getPreco_produto() {
		return preco_produto;
	}
	
	public void setPreco_produto(Double preco_produto) {
		this.preco_produto = preco_produto;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
}
