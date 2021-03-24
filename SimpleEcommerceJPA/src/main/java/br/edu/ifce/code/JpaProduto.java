package br.edu.ifce.code;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.edu.ifce.model.Produto;

public class JpaProduto {
	public static void main(String[] args) throws IOException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TJW");
		EntityManager manager = factory.createEntityManager();
		
		try {
			manager.getTransaction().begin();
			Produto produto = new Produto();
			produto.setNome_produto("Xbox Series X");
			produto.setPreco_produto(4999.99);
			produto.setDepartamento("Games");
			manager.persist(produto);
			
			Produto produto2 = new Produto();
			produto2.setNome_produto("Xbox Series S");
			produto2.setPreco_produto(2799.99);
			produto2.setDepartamento("Games");
			manager.persist(produto2);
			
			Produto produto3 = new Produto();
			produto3.setNome_produto("Sherlock Holmes: Um Estudo em Vermelho");
			produto3.setPreco_produto(44.99);
			produto3.setDepartamento("Livraria");
			manager.persist(produto3);
			
			Produto produto4 = new Produto();
			produto4.setNome_produto("George Orwell: 1984");
			produto4.setPreco_produto(48.75);
			produto4.setDepartamento("Livraria");
			manager.persist(produto4);
			
			Produto produto5 = new Produto();
			produto5.setNome_produto("Pulseira Inteligente");
			produto5.setPreco_produto(285.15);
			produto5.setDepartamento("Eletrônicos");
			manager.persist(produto5);
			
			Produto produto6 = new Produto();
			produto6.setNome_produto("Camisa Erro 404");
			produto6.setPreco_produto(58.70);
			produto6.setDepartamento("Roupas");
			manager.persist(produto6);
			
			manager.getTransaction().commit();
			manager.close();
			factory.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
