package br.edu.ifce.code;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.edu.ifce.dao.ClienteDao;
import br.edu.ifce.model.Cliente;

@ManagedBean(name = "AuthMB")
@ViewScoped
public class AuthManagedBean {

	private ClienteDao clienteDao = new ClienteDao();
	private Cliente cliente = new Cliente();
	
	public String sendAuthRout() {
		cliente = clienteDao.getCliente(cliente.getEmail(), cliente.getPwd());
		if (cliente == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail ou senha incorretos", "Falha no Login!"));
			return null;
		}
		else {
			return "/store-frontpage";
		}
			
	}
	
	public String navigateRegister() {
		return "/cadastro";
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
