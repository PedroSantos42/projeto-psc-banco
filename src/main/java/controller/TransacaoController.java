package controller;

import java.util.List;

import business.TransacaoBusiness;
import contract.controllers.ITransacaoController;
import dao.transacao.EmprestimoDAO;
import dao.transacao.TransferenciaDAO;
import model.transacao.Emprestimo;
import model.transacao.Transferencia;

public class TransacaoController implements ITransacaoController {
	
	private TransacaoBusiness _transacaoBusiness = new TransacaoBusiness();
	
	/*********************
	 * ENTIDADE EMPRESTIMO
	 */
	
	public void addEmprestimo(Emprestimo emprestimo) {
		_transacaoBusiness.addEmprestimo(emprestimo);
	}
	
	public Emprestimo listEmprestimo(Emprestimo emprestimo) {
		return (Emprestimo) _transacaoBusiness.listEmprestimo(emprestimo);
	}
	
	public List<Emprestimo> listAllEmprestimo(Emprestimo emprestimo){
		return _transacaoBusiness.listAllEmprestimo(emprestimo);
	}
	
	public void updateEmprestimo(Emprestimo emprestimo) {
		_transacaoBusiness.updateEmprestimo(emprestimo);
	}
	
	public void removeEmprestimo(Emprestimo emprestimo) {
		_transacaoBusiness.removeEmprestimo(emprestimo);
	}
	
	/*******************
	 * ENTIDADE TRANSFERÊNCIA
	 */
	
	public void addTransferencia(Transferencia transferencia) {
		_transacaoBusiness.addTransferencia(transferencia);
	}
	
	public Transferencia listTransferencia(Transferencia transferencia) {
		return (Transferencia) _transacaoBusiness.listTransferencia(transferencia);
	}
	
	public List<Transferencia> listAllTransferencia(Transferencia transferencia){
		return _transacaoBusiness.listAllTransferencia(transferencia);
	}
	
	public void updateTransferencia (Transferencia transferencia) {
		_transacaoBusiness.updateTransferencia(transferencia);
	}
	
	public void removeTransferencia(Transferencia transferencia) {
		_transacaoBusiness.removeTransferencia(transferencia);
	}
}
