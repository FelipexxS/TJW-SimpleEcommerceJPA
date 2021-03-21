package br.edu.ifce.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import br.edu.ifce.model.Carrinho;
import br.edu.ifce.model.Cliente;
import br.edu.ifce.utils.JPAUtil;

public class ClienteDao {
	
	public Cliente getCliente(String email, String senha) {
		try {
			Cliente clienteAtual = (Cliente) JPAUtil.getEntityManager()
					.createQuery("SELECT u from Cliente u where u.email = :email and  u.pwd = :senha")
					.setParameter("email", email)
					.setParameter("senha", senha).getSingleResult();
			return clienteAtual;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public boolean addCliente(Cliente cliente) {
		try {
			JPAUtil.getEntityManager().persist(cliente);
			CarrinhoDao carrinhodao = new CarrinhoDao();
			carrinhodao.addCarrinho(cliente);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
