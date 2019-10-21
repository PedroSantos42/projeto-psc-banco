package contract.dao;

import java.util.List;
import model.conta.ContaCorrente;

public interface IContaCorrenteDAO {
	List<ContaCorrente> listAllContaCorrente(ContaCorrente contaCorrente);

}
