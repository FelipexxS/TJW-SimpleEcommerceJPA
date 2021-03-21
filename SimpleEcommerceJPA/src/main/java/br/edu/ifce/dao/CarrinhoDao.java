package br.edu.ifce.dao;

import java.util.Collection;
import java.util.Iterator;

import javax.persistence.NoResultException;

import br.edu.ifce.model.Carrinho;
import br.edu.ifce.model.Cliente;
import br.edu.ifce.model.Produto;
import br.edu.ifce.utils.JPAUtil;

public class CarrinhoDao {

	public Carrinho getCarrinhoByCliente(Cliente cliente) {
		try {
			Carrinho carrinho = (Carrinho) JPAUtil.getEntityManager()
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
			JPAUtil.getEntityManager().persist(novoCarrinho);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean inserirItemCarrinho(Produto produto, Cliente cliente) {
		try {

			Carrinho carrinhoExc = getCarrinhoByCliente(cliente);
			JPAUtil.getEntityManager().getTransaction().begin();
			carrinhoExc.getItens_carrinho().add(produto);
			JPAUtil.getEntityManager().getTransaction().commit();
			
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
			
			JPAUtil.getEntityManager().getTransaction().begin();
			carrinhoExc.setItens_carrinho(itensCarrinho);
			JPAUtil.getEntityManager().getTransaction().commit();
			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
