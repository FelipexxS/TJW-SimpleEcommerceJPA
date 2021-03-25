package br.edu.ifce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemCarrinho {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Produto produto;
	
	@ManyToOne
	private Carrinho item_carrinho;
	
	@Column
	private int quantidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Carrinho getItem_carrinho() {
		return item_carrinho;
	}

	public void setItem_carrinho(Carrinho item_carrinho) {
		this.item_carrinho = item_carrinho;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
