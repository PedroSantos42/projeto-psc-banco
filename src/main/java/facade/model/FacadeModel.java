package facade.model;

import dao.conta.ContaCorrenteDAO;
import dao.conta.ContaPoupancaDAO;
import dao.pessoa.ClienteDAO;
import dao.transacao.EmprestimoDAO;
import dao.transacao.TransferenciaDAO;

public class FacadeModel {

	// Pessoa
	private ClienteDAO _clienteDAO = new ClienteDAO();

	// Contas
	private ContaCorrenteDAO _contaCorrenteDAO = new ContaCorrenteDAO();
	private ContaPoupancaDAO _contaPoupancaDAO = new ContaPoupancaDAO();

	// Transações
	private EmprestimoDAO _emprestimoDAO = new EmprestimoDAO();
	private TransferenciaDAO _transferenciaDAO = new TransferenciaDAO();

	public ClienteDAO getClienteDAO() {
		return _clienteDAO;
	}

	public ContaCorrenteDAO getContaCorrenteDAO() {
		return _contaCorrenteDAO;
	}

	public ContaPoupancaDAO getContaPoupancaDAO() {
		return _contaPoupancaDAO;
	}

	public EmprestimoDAO getEmprestimoDAO() {
		return _emprestimoDAO;
	}

	public TransferenciaDAO getTransferenciaDAO() {
		return _transferenciaDAO;
	}
}
