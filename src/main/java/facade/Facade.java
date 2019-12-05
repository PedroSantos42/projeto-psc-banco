package facade;

import java.util.List;

import controller.ContaController;
import controller.PessoaController;
import controller.TransacaoController;
import model.conta.Conta;
import model.conta.ContaCorrente;
import model.conta.ContaPoupanca;
import model.pessoa.Cliente;
import model.pessoa.Funcionario;
import model.pessoa.Pessoa;
import model.transacao.Emprestimo;
import model.transacao.Transacao;
import model.transacao.Transferencia;

public class Facade {
	private PessoaController _pessoaController;
	private TransacaoController _transacaoController;
	private ContaController _contaController;
	
	public Facade() {
		_pessoaController = new PessoaController();
		_transacaoController = new TransacaoController();
		_contaController = new ContaController();
	}
	
	// INI - MÉTODOS RELACIONADOS AS ENTIDADES DERIVADAS DE PESSOA
	
	public void addPessoa(Pessoa pessoa) {
		if (pessoa.getClass() == Cliente.class)
			_pessoaController.addCliente((Cliente)pessoa);
		else
			_pessoaController.addFuncionario((Funcionario)pessoa);
	}
	
	public void removePessoa(Pessoa pessoa) {
		if (pessoa.getClass() == Cliente.class)
			_pessoaController.removeCliente((Cliente)pessoa);
		else
			_pessoaController.removeFuncionario((Funcionario)pessoa);
	}
	
	public void updatePessoa(Pessoa pessoa) {
		if (pessoa.getClass() == Cliente.class)
			_pessoaController.updateCliente((Cliente)pessoa);
		else
			_pessoaController.updateFuncionario((Funcionario)pessoa);
	}

	public Cliente listCliente(Cliente cliente) {
		return _pessoaController.listCliente(cliente);
	}

	public Funcionario listFuncionario(Funcionario funcionario) {
		return _pessoaController.listFuncionario(funcionario);
	}
	
	public List<Cliente> listAllCliente(Cliente cliente) {
		return _pessoaController.listAllCliente(cliente);
	}
	
	public List<Funcionario> listAllFuncionario(Funcionario funcionario) {
		return _pessoaController.listAllFuncionario(funcionario);
	}
	
	// FIM - MÉTODOS RELACIONADOS AS ENTIDADES DERIVADAS DE PESSOA
	// INI - MÉTODOS RELACIONADOS AS ENTIDADES DERIVADAS DE TRANSACAO

	public void addTransacao(Transacao transacao) {
		if (transacao.getClass() == Emprestimo.class)
			_transacaoController.addEmprestimo((Emprestimo) transacao);
		else
			_transacaoController.addTransferencia((Transferencia) transacao);
	}

	public void removeTransacao(Transacao transacao) {
		if (transacao.getClass() == Emprestimo.class)
			_transacaoController.removeEmprestimo((Emprestimo) transacao);
		else
			_transacaoController.removeTransferencia((Transferencia) transacao);
	}

	public void updateTransacao(Transacao transacao) {
		if (transacao.getClass() == Emprestimo.class)
			_transacaoController.updateEmprestimo((Emprestimo) transacao);
		else
			_transacaoController.updateTransferencia((Transferencia) transacao);
	}

	public Emprestimo listEmprestimo(Emprestimo emprestimo) {
		return _transacaoController.listEmprestimo(emprestimo);
	}

	public Transferencia listTransferencia(Transferencia transferencia) {
		return _transacaoController.listTransferencia(transferencia);
	}
	
	public List<Emprestimo> listAllEmprestimo(Emprestimo emprestimo) {
		return _transacaoController.listAllEmprestimo(emprestimo);
	}
	
	public List<Transferencia> listAllTransferencia(Transferencia transferencia) {
		return _transacaoController.listAllTransferencia(transferencia);
	}
	
	// FIM - MÉTODOS RELACIONADOS AS ENTIDADES DERIVADAS DE TRANSACAO
	// INI - MÉTODOS RELACIONADOS AS ENTIDADES DERIVADAS DE CONTA
	

	public void addConta(Conta conta) {
		if (conta.getClass() == ContaCorrente.class)
			_contaController.addContaCorrente((ContaCorrente) conta);
		else
			_contaController.addContaPoupanca((ContaPoupanca) conta);
	}

	public void removeConta(Conta conta) {
		if (conta.getClass() == ContaCorrente.class)
			_contaController.removeContaCorrente((ContaCorrente) conta);
		else
			_contaController.removeContaPoupanca((ContaPoupanca) conta);
	}

	public void updateConta(Conta conta) {
		if (conta.getClass() == ContaCorrente.class)
			_contaController.updateContaCorrente((ContaCorrente) conta);
		else
			_contaController.updateContaPoupanca((ContaPoupanca) conta);
	}

	public ContaCorrente listContaCorrente(ContaCorrente contaCorrente) {
		return _contaController.listContaCorrente(contaCorrente);
	}

	public ContaPoupanca listContaPoupanca(ContaPoupanca contaPoupanca) {
		return _contaController.listContaPoupanca(contaPoupanca);
	}
	
	public List<ContaCorrente> listAllContaCorrente(ContaCorrente contaCorrente) {
		return _contaController.listAllContaCorrente(contaCorrente);
	}
	
	public List<ContaPoupanca> listAllContaPoupanca(ContaPoupanca contaPoupanca) {
		return _contaController.listAllContaPoupanca(contaPoupanca);
	}	
}
