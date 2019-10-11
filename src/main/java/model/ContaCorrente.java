package model;

//import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

import contract.models.IContaCorrente;

@Entity(name = "ContaCorrente")
//@DiscriminatorColumn(name = "ContaCorrente")
public class ContaCorrente extends Conta implements IContaCorrente {
	

	public ContaCorrente() {
		super();
	}

	public ContaCorrente(int id, int numeroConta, double saldo, String situacao) {
		super(id, numeroConta, saldo, situacao);		
	}

	@Override
	public String toString() {
		return "ContaCorrente [getId()=" + getId() + ", getNumeroConta()=" + getNumeroConta() + ", getSaldo()="
				+ getSaldo() + ", getSituacao()=" + getSituacao() + ", toString()=" + super.toString()
				+ ", getPrimaryKey()=" + getPrimaryKey() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
		
}
