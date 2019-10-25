package contract.dao;

import java.util.List;
import model.transacao.Emprestimo;

public interface IEmprestimoDAO {
	List<Emprestimo> listAllEmprestimo(Emprestimo Emprestimo);
}
