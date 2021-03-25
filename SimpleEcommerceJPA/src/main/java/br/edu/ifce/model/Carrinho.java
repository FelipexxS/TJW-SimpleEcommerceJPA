package br.edu.ifce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Carrinho {
	
	@Id
	@GeneratedValue
	private Long id_carrinho;
	
	@OneToOne
	@JoinColumn
	private Cliente carrinho_cliente;
	
	@Column
	private Double valor_total;

	public Long getId_carrinho() {
		return id_carrinho;
	}

	public void setId_carrinho(Long id_carrinho) {
		this.id_carrinho = id_carrinho;
	}

	public Cliente getCarrinho_cliente() {
		return carrinho_cliente;
	}

	public void setCarrinho_cliente(Cliente carrinho_cliente) {
		this.carrinho_cliente = carrinho_cliente;
	}
	
	public Double getValor_total() {
		return valor_total;
	}

	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}
}
