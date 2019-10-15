package model.conta;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

import contract.models.conta.IContaPoupanca;
import model.pessoa.Pessoa;
import model.transacao.Transacao;

@Entity(name = "ContaPoupanca")
@DiscriminatorColumn(name = "ContaPoupanca")
public class ContaPoupanca extends Conta implements IContaPoupanca {

	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(int id, int numeroConta, double saldo, String situacao, Pessoa pessoa, List<Transacao> transacoes) {
		super(id, numeroConta, saldo, situacao, pessoa, transacoes);
	}

	@Override
	public String toString() {
		return "ContaPoupanca [getId()=" + getId() + ", getNumeroConta()=" + getNumeroConta() + ", getSaldo()="
				+ getSaldo() + ", getSituacao()=" + getSituacao() + ", toString()=" + super.toString()
				+ ", getPrimaryKey()=" + getPrimaryKey() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}	

}
