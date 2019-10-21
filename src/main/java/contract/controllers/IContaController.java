package contract.controllers;

import java.util.List;

import model.conta.ContaCorrente;
import model.conta.ContaPoupanca;

public interface IContaController {
	
	// CRUD Conta Corrente
	void addContaCorrente(ContaCorrente contaCorrente);
	ContaCorrente listContaCorrente(ContaCorrente contaCorrente);
	List<ContaCorrente> listAllContaCorrente(ContaCorrente contaCorrente);
	void updateContaCorrente(ContaCorrente contaCorrente);
	void removeContaCorrente(ContaCorrente contaCorrente);	
	
	// CRUD Conta Poupança
	void addContaPoupanca(ContaPoupanca contaPoupanca);
	ContaPoupanca listContaPoupanca(ContaPoupanca contaPoupanca);
	List<ContaPoupanca> listAllContaPoupanca(ContaPoupanca contaPoupanca);
	void updateContaPoupanca(ContaPoupanca contaPoupanca);
	void removeContaPoupanca(ContaPoupanca contaPoupanca);	

}
