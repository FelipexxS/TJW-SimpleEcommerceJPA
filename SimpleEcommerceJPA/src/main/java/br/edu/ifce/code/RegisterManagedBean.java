package br.edu.ifce.code;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.edu.ifce.dao.ClienteDao;
import br.edu.ifce.model.Cliente;
import br.edu.ifce.model.Endereco;
import br.edu.ifce.model.Telefone;

@ManagedBean(name = "RegisterMB")
@ViewScoped
public class RegisterManagedBean {
	
	private ClienteDao clienteDao = new ClienteDao();
	private Cliente cliente = new Cliente();
	private Telefone telefone = new Telefone();
	private Endereco endereco = new Endereco();
	
	public void registrar() {
		clienteDao.addCliente(cliente, endereco, telefone);
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Telefone getTelefone() {
		return this.telefone;
	}
	
	public void setTelefone (Telefone telefone) {
		this.telefone = telefone;
	}
	
	public Endereco getEndereco() {
		return this.endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String navigateBack() {
		return "/index";
	}
	
}
