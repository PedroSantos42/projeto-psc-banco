package model.conta;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

import contract.models.conta.IContaCorrente;
import model.Pessoa;

@Entity(name = "ContaCorrente")
@DiscriminatorColumn(name = "ContaCorrente")
public class ContaCorrente extends Conta implements IContaCorrente {
	
	public ContaCorrente() {
		super();
	}

	public ContaCorrente(int id, int numeroConta, double saldo, String situacao, Pessoa pessoa) {
		super(id, numeroConta, saldo, situacao, pessoa);		
	}

	@Override
	public String toString() {
		return "ContaCorrente [getId()=" + getId() + ", getNumeroConta()=" + getNumeroConta() + ", getSaldo()="
				+ getSaldo() + ", getSituacao()=" + getSituacao() + ", toString()=" + super.toString()
				+ ", getPrimaryKey()=" + getPrimaryKey() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
		
}
