package br.edu.ifce.code;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifce.dao.CarrinhoDao;
import br.edu.ifce.dao.ProdutoDao;
import br.edu.ifce.model.Produto;

@ManagedBean(name = "storeMB")
@ViewScoped
public class StoreManagedBean {
	
	List<Produto> produto = new ArrayList<Produto>();
	ProdutoDao produtoDao = new ProdutoDao();
	CarrinhoDao carrinhoDao = new CarrinhoDao();
	
	public void getListProduto() {
		this.produto = produtoDao.getAllProdutos();
	}
	
	public void adicionaCarrinho() {
		
	}
}
