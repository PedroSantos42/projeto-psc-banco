package contract.controllers;

import java.util.List;

import model.pessoa.Cliente;
import model.pessoa.Funcionario;

public interface IPessoaController {
	
	// CRUD Cliente
	void addCliente(Cliente cliente);
	Cliente listCliente(Cliente cliente);
	List<Cliente> listAllCliente(Cliente cliente);
	void updateCliente(Cliente cliente);
	void removeCliente(Cliente cliente);
	
	// CRUD Funcionario
	void addFuncionario(Funcionario funcionario);
	Funcionario listFuncionario(Funcionario funcionario);
	List<Funcionario> listAllFuncionario(Funcionario funcionario);
	void updateFuncionario(Funcionario funcionario);
	void removeFuncionario(Funcionario funcionario);
}
