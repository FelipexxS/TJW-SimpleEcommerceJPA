package br.edu.ifce.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import br.edu.ifce.model.Carrinho;
import br.edu.ifce.model.Cliente;
import br.edu.ifce.model.Endereco;
import br.edu.ifce.model.Telefone;
import br.edu.ifce.utils.JPAUtil;

public class ClienteDao {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("TJW");
	EntityManager manager = factory.createEntityManager();
	
	public Cliente getCliente(String email, String senha) {
		try {
			
			Cliente clienteAtual = (Cliente) manager
					.createQuery("SELECT u from Cliente u where u.email = :email and  u.pwd = :senha")
					.setParameter("email", email)
					.setParameter("senha", senha).getSingleResult();
			return clienteAtual;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public boolean addCliente(Cliente cliente, Endereco endereco, Telefone telefone) {
		try {
			manager.getTransaction().begin();
			if (telefone.getNumTelefone() != null) {
				manager.persist(telefone);
				cliente.setTelefone(telefone);
			}
			
			manager.persist(endereco);
			cliente.setEndereco(endereco);
			manager.persist(cliente);
			CarrinhoDao carrinhodao = new CarrinhoDao();
			carrinhodao.addCarrinho(cliente);
			manager.getTransaction().commit();
			manager.close();
			factory.close();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
