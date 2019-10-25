package contract.controllers;

import java.util.List;

import model.transacao.Emprestimo;
import model.transacao.Transferencia;

public interface ITransacaoController {
	
	// CRUD Emprestimo
	void addEmprestimo(Emprestimo Emprestimo);
	Emprestimo listEmprestimo(Emprestimo Emprestimo);
	List<Emprestimo> listAllEmprestimo(Emprestimo Emprestimo);
	void updateEmprestimo(Emprestimo Emprestimo);
	void removeEmprestimo(Emprestimo Emprestimo);	
	
	// CRUD Transferencia
	void addTransferencia(Transferencia Transferencia);
	Transferencia listTransferencia(Transferencia Transferencia);
	List<Transferencia> listAllTransferencia(Transferencia Transferencia);
	void updateTransferencia(Transferencia Transferencia);
	void removeTransferencia(Transferencia Transferencia);	


}
