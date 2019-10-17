package controller;

import java.util.List;
import contract.controllers.IPessoaController;
import dao.pessoa.ClienteDAO;
import dao.pessoa.FuncionarioDAO;
import model.pessoa.Cliente;
import model.pessoa.Funcionario;

public class PessoaController implements IPessoaController {

	private ClienteDAO _clienteDAO = new ClienteDAO();
	private FuncionarioDAO _funcionarioDAO = new FuncionarioDAO();
	
	/**********************
	 * ENTIDADE CLIENTE
	 */
	public void addCliente(Cliente cliente) {
		_clienteDAO.add(cliente);
	}

	public Cliente listCliente(Cliente cliente) {
		if (cliente != null && cliente.getPrimaryKey() != null) {
			return (Cliente) _clienteDAO.listByPrimaryKey(cliente.getClass(), cliente.getPrimaryKey());
		} else {
			return (Cliente) _clienteDAO.listByObject(cliente);
		}
	}
	
	public List<Cliente> listAllCliente(Cliente cliente) {
		return _clienteDAO.listAllCliente(cliente);
	}

	public void updateCliente(Cliente cliente) {
		_clienteDAO.update(cliente);
	}

	public void removeCliente(Cliente cliente) {
		if (cliente != null && cliente.getPrimaryKey() != null) {
			_clienteDAO.removeByPrimaryKey(cliente, cliente.getPrimaryKey());
		} else {
			_clienteDAO.removeByObject(cliente);
		}
	}
	
	/**********************
	 * ENTIDADE FUNCIONARIO
	 */
	public void addFuncionario(Funcionario funcionario) {
		_funcionarioDAO.add(funcionario);
	}

	public Funcionario listFuncionario(Funcionario funcionario) {
		if (funcionario != null && funcionario.getPrimaryKey() != null) {
			return (Funcionario) _funcionarioDAO.listByPrimaryKey(funcionario.getClass(), funcionario.getPrimaryKey());
		} else {
			return (Funcionario) _funcionarioDAO.listByObject(funcionario);
		}
	}
	
	public List<Funcionario> listAllFuncionario(Funcionario funcionario) {
		return _funcionarioDAO.listAllFuncionario(funcionario);
	}

	public void updateFuncionario(Funcionario funcionario) {
		_funcionarioDAO.update(funcionario);
	}

	public void removeFuncionario(Funcionario funcionario) {
		if (funcionario != null && funcionario.getPrimaryKey() != null) {
			_funcionarioDAO.removeByPrimaryKey(funcionario, funcionario.getPrimaryKey());
		} else {
			_funcionarioDAO.removeByObject(funcionario);
		}
	}
}
