package br.edu.ifce.code;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.edu.ifce.dao.CarrinhoDao;
import br.edu.ifce.dao.ProdutoDao;
import br.edu.ifce.model.Carrinho;
import br.edu.ifce.model.Produto;

@ManagedBean(name = "StoreMB")
@ViewScoped
public class StoreManagedBean {
	
	List<Produto> produtos = new ArrayList<Produto>();
	ProdutoDao produtoDao = new ProdutoDao();
	List<Carrinho> itensCarrinho = new ArrayList<Carrinho>();
	CarrinhoDao carrinhoDao = new CarrinhoDao();
	Carrinho carrinho = new Carrinho();
	Produto produto = new Produto();
	String nomeCliente;
	
	@ManagedProperty("#{AuthMB}")
	private AuthManagedBean authManagedBean;
	
	public AuthManagedBean getAuthManagedBean() {
		return authManagedBean;
	}

	public void setAuthManagedBean(AuthManagedBean authManagedBean) {
		this.authManagedBean = authManagedBean;
	}

	@PostConstruct
	public void onInit() {
		
		this.getListProduto();
		setNomeCliente(authManagedBean.getCliente().getNome_cliente());
		
		if (getListCarrinho() != null) {
			itensCarrinho = getListCarrinho();
		}
	}
	
	public void getListProduto() {
		this.produtos = produtoDao.getAllProdutos();
	}
	
	public List<Carrinho> getListCarrinho() {
		return carrinhoDao.getAllItens();
	}
	
	public void addItem() {
		carrinhoDao.inserirItemCarrinho(produto, authManagedBean.getCliente());
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Carrinho getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Carrinho> getItensCarrinho() {
		return itensCarrinho;
	}

	public void setItensCarrinho(List<Carrinho> itensCarrinho) {
		this.itensCarrinho = itensCarrinho;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	
	
	
}
