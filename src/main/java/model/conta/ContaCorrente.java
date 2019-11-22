package model.conta;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import contract.models.conta.IContaCorrente;
import model.pessoa.Pessoa;
import model.transacao.Transacao;

@Entity(name = "ContaCorrente")
@DiscriminatorValue(value = "ContaCorrente")
public class ContaCorrente extends Conta implements IContaCorrente {
	
	public ContaCorrente() {
		super();
	}

	public ContaCorrente(int id, int numeroConta, double saldo, String situacao, Pessoa pessoa, List<Transacao> transacoes) {
		super(id, numeroConta, saldo, situacao, pessoa, transacoes);		
	}

	@Override
	public String toString() {
		return "ContaCorrente [getId()=" + getId() + ", getNumeroConta()=" + getNumeroConta() + ", getSaldo()="
				+ getSaldo() + ", getSituacao()=" + getSituacao() + ", toString()=" + super.toString()
				+ ", getPrimaryKey()=" + getPrimaryKey() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
		
}
