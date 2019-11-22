package model.transacao;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import contract.models.transacao.IEmprestimo;
import model.conta.Conta;

@Entity
@DiscriminatorValue(value = "tipo_transacao")
public class Emprestimo extends Transacao implements IEmprestimo {
	
	public Emprestimo () {
		super();
	}
	
	public Emprestimo (int id, int numeroConta, float valorTransacao, Date dataTransacao, Conta conta) {
		super(id, numeroConta, valorTransacao, dataTransacao, conta);
	}
	
	@Override
	public String toString() {
		return "Emprestimo [getId()=" + getId() + ", getNumeroConta()=" + getNumeroConta() + ", getValorTransacao()=" + getValorTransacao()
				+ ", getDataTransacao()=" + getDataTransacao() + ", toString()=" + super.toString() + ", getPrimaryKey()=" + getPrimaryKey()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}
