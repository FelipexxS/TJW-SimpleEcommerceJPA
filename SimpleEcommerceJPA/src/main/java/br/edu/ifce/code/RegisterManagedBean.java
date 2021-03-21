package br.edu.ifce.code;

import br.edu.ifce.dao.ClienteDao;
import br.edu.ifce.model.Cliente;
import br.edu.ifce.model.Endereco;
import br.edu.ifce.model.Telefone;

public class RegisterManagedBean {
	
	private ClienteDao clienteDao = new ClienteDao();
	private Cliente novoCliente = new Cliente();
	private Telefone novoTelefone = new Telefone();
	private Endereco novoEnd = new Endereco();
	
	public void Registrar() {
		
	}
}
