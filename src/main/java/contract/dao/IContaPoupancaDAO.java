package contract.dao;

import java.util.List;
import model.conta.ContaPoupanca;

public interface IContaPoupancaDAO {
	List<ContaPoupanca> listAllContaPoupanca(ContaPoupanca contaPoupanca);

}
