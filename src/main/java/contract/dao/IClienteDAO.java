package contract.dao;

import java.util.List;

import model.pessoa.Cliente;

public interface IClienteDAO {

	List<Cliente> listAllCliente(Cliente cliente);
}
