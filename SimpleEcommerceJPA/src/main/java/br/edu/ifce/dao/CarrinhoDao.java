package br.edu.ifce.dao;

import java.util.Collection;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import br.edu.ifce.model.Carrinho;
import br.edu.ifce.model.Cliente;
import br.edu.ifce.model.Produto;


public class CarrinhoDao {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("TJW");
	EntityManager manager = factory.createEntityManager();
	
	public Carrinho getCarrinhoByCliente(Cliente cliente) {
		
		try {
			Carrinho carrinho = (Carrinho) manager
					.createQuery("SELECT c from Carrinho c where c.carrinho_cliente = :cliente")
					.setParameter("cliente", cliente).getSingleResult();
			return carrinho;
		} catch (NoResultException e) {
			return null;
		}
	}

	public boolean addCarrinho(Cliente cliente) {
		try {
			Carrinho novoCarrinho = new Carrinho();
			novoCarrinho.setCarrinho_cliente(cliente);
			novoCarrinho.setValor_total(0.00);
			manager.persist(novoCarrinho);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean inserirItemCarrinho(Produto produto, Cliente cliente) {
		try {

			Carrinho carrinhoExc = getCarrinhoByCliente(cliente);
			manager.getTransaction().begin();
			carrinhoExc.getItens_carrinho().add(produto);
			manager.getTransaction().commit();
			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean excluirItemCarrinho(Produto produto, Cliente cliente) {
		try {

			Carrinho carrinhoExc = getCarrinhoByCliente(cliente);
			Collection<Produto> itensCarrinho = carrinhoExc.getItens_carrinho();
			Iterator<Produto> itensInterator = itensCarrinho.iterator();
			while (itensInterator.hasNext()) {
				Produto prd = itensInterator.next();
				if (prd.equals(produto)) {
					itensInterator.remove();
				}
			}
			
			manager.getTransaction().begin();
			carrinhoExc.setItens_carrinho(itensCarrinho);
			manager.getTransaction().commit();
			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
