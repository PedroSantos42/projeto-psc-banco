package controller;

import java.util.List;

import contract.controllers.ITransacaoController;
import dao.transacao.EmprestimoDAO;
import dao.transacao.TransferenciaDAO;
import model.transacao.Emprestimo;
import model.transacao.Transferencia;

public class TransacaoController implements ITransacaoController {
	
	private EmprestimoDAO _emprestimoDAO = new EmprestimoDAO();
	private TransferenciaDAO _transferenciaDAO = new TransferenciaDAO();
	
	/*********************
	 * ENTIDADE EMPRESTIMO
	 */
	
	public void addEmprestimo(Emprestimo emprestimo) {
		_emprestimoDAO.add(emprestimo);
		
	}
	
	public Emprestimo listEmprestimo(Emprestimo emprestimo) {
		if(emprestimo != null && emprestimo.getPrimaryKey() != null) {
			return (Emprestimo) _emprestimoDAO.listByPrimaryKey(emprestimo.getClass(),emprestimo.getPrimaryKey());
		} else {
			return (Emprestimo) _emprestimoDAO.listByObject(emprestimo);
		}
	}
	
	public List<Emprestimo> listAllEmprestimo(Emprestimo emprestimo){
		return _emprestimoDAO.listAllEmprestimo(emprestimo);
	}
	
	public void updateEmprestimo(Emprestimo emprestimo) {
		_emprestimoDAO.update(emprestimo);
	}
	
	public void removeEmprestimo(Emprestimo emprestimo) {
		if (emprestimo != null && emprestimo.getPrimaryKey() != null) {
			_emprestimoDAO.removeByPrimaryKey(emprestimo, emprestimo.getPrimaryKey());
		} else {
			_emprestimoDAO.removeByObject(emprestimo);
		}
	}
	
	/*******************
	 * ENTIDADE TRANSFERÊNCIA
	 */
	
	public void addTransferencia(Transferencia transferencia) {
		_transferenciaDAO.add(transferencia);
	}
	
	public Transferencia listTransferencia(Transferencia transferencia) {
		if(transferencia != null && transferencia.getPrimaryKey() != null) {
			return (Transferencia) _transferenciaDAO.listByPrimaryKey(transferencia.getClass(), transferencia.getPrimaryKey());
		} else {
			return (Transferencia) _transferenciaDAO.listByObject(transferencia);
		}
	}
	
	public List<Transferencia> listAllTransferencia(Transferencia transferencia){
		return _transferenciaDAO.listAllTransferencia(transferencia);
	}
	
	public void updateTransferencia (Transferencia transferencia) {
		_transferenciaDAO.update(transferencia);
	}
	
	public void removeTransferencia(Transferencia transferencia) {
		if (transferencia != null && transferencia.getPrimaryKey() != null) {
			_transferenciaDAO.removeByPrimaryKey(transferencia, transferencia.getPrimaryKey());
		} else {
			_transferenciaDAO.removeByObject(transferencia);
		}
	}
}
