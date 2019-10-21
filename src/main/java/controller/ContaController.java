package controller;

import java.util.List;

import contract.controllers.IContaController;
import dao.conta.ContaCorrenteDAO;
import dao.conta.ContaPoupancaDAO;
import model.conta.ContaCorrente;
import model.conta.ContaPoupanca;

public class ContaController implements IContaController {

	private ContaCorrenteDAO _contaCorrenteDAO = new ContaCorrenteDAO();
	private ContaPoupancaDAO _contaPoupancaDAO = new ContaPoupancaDAO();

	/**********************
	 * ENTIDADE CONTA CORRENTE
	 */
	public void addContaCorrente(ContaCorrente contaCorrente) {
		_contaCorrenteDAO.add(contaCorrente);

	}

	public ContaCorrente listContaCorrente(ContaCorrente contaCorrente) {
		if (contaCorrente != null && contaCorrente.getPrimaryKey() != null) {
			return (ContaCorrente) _contaCorrenteDAO.listByPrimaryKey(contaCorrente.getClass(),
					contaCorrente.getPrimaryKey());
		} else {
			return (ContaCorrente) _contaCorrenteDAO.listByObject(contaCorrente);
		}
	}

	public List<ContaCorrente> listAllContaCorrente(ContaCorrente contaCorrente) {
		return _contaCorrenteDAO.listAllContaCorrente(contaCorrente);
	}

	public void updateContaCorrente(ContaCorrente contaCorrente) {
		_contaCorrenteDAO.update(contaCorrente);

	}

	public void removeContaCorrente(ContaCorrente contaCorrente) {
		if (contaCorrente != null && contaCorrente.getPrimaryKey() != null) {
			_contaCorrenteDAO.removeByPrimaryKey(contaCorrente, contaCorrente.getPrimaryKey());
		} else {
			_contaCorrenteDAO.removeByObject(contaCorrente);
		}
	}

	/**********************
	 * ENTIDADE CONTA POUPANÇA
	 */

	public void addContaPoupanca(ContaPoupanca contaPoupanca) {
		_contaPoupancaDAO.add(contaPoupanca);

	}

	public ContaPoupanca listContaPoupanca(ContaPoupanca contaPoupanca) {
		if (contaPoupanca != null && contaPoupanca.getPrimaryKey() != null) {
			return (ContaPoupanca) _contaPoupancaDAO.listByPrimaryKey(contaPoupanca.getClass(),
					contaPoupanca.getPrimaryKey());
		} else {
			return (ContaPoupanca) _contaPoupancaDAO.listByObject(contaPoupanca);
		}
	}

	public List<ContaPoupanca> listAllContaPoupanca(ContaPoupanca contaPoupanca) {
		return _contaPoupancaDAO.listAllContaPoupanca(contaPoupanca);
	}

	public void updateContaPoupanca(ContaPoupanca contaPoupanca) {
		_contaPoupancaDAO.update(contaPoupanca);

	}

	public void removeContaPoupanca(ContaPoupanca contaPoupanca) {
		if (contaPoupanca != null && contaPoupanca.getPrimaryKey() != null) {
			_contaPoupancaDAO.removeByPrimaryKey(contaPoupanca, contaPoupanca.getPrimaryKey());
		} else {
			_contaPoupancaDAO.removeByObject(contaPoupanca);
		}
	}

}
