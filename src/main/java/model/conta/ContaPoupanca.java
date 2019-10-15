package model.conta;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

import contract.models.conta.IContaPoupanca;
import model.Pessoa;

@Entity(name = "ContaPoupanca")
@DiscriminatorColumn(name = "ContaPoupanca")
public class ContaPoupanca extends Conta implements IContaPoupanca {

	public ContaPoupanca() {
		super();
	}

	public ContaPoupanca(int id, int numeroConta, double saldo, String situacao, Pessoa pessoa) {
		super(id, numeroConta, saldo, situacao, pessoa);
	}

	@Override
	public String toString() {
		return "ContaPoupanca [getId()=" + getId() + ", getNumeroConta()=" + getNumeroConta() + ", getSaldo()="
				+ getSaldo() + ", getSituacao()=" + getSituacao() + ", toString()=" + super.toString()
				+ ", getPrimaryKey()=" + getPrimaryKey() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}	

}
