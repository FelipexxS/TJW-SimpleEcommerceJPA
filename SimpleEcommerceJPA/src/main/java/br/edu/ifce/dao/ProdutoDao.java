package br.edu.ifce.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifce.model.Produto;

public class ProdutoDao {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("TJW");
	EntityManager manager = factory.createEntityManager();
	
	public List<Produto> getAllProdutos() {
		return manager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
	}
	
}
