package contract.dao;

import java.util.List;

import model.pessoa.Funcionario;

public interface IFuncionarioDAO {

	List<Funcionario> listAllFuncionario(Funcionario funcionario);
}
