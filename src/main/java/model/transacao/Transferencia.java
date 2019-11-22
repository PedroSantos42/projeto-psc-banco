package model.transacao;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import contract.models.transacao.ITransferencia;
import model.conta.Conta;

@Entity(name = "Transferencia")
@DiscriminatorValue(value = "TransacaoTransferencia")
public class Transferencia extends Transacao implements ITransferencia {
	
	public Transferencia () {
		super();
	}
	
	public Transferencia (int id, int numeroConta, float valorTransacao, Date dataTransacao, Conta conta) {
		super(id, numeroConta, valorTransacao, dataTransacao, conta);
	}
	
	@Override
	public String toString() {
		return "Transferencia [getId()=" + getId() + ", getNumeroConta()=" + getNumeroConta() + ", getValorTransacao()=" + getValorTransacao()
				+ ", getDataTransacao()=" + getDataTransacao() + ", toString()=" + super.toString() + ", getPrimaryKey()=" + getPrimaryKey()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

}

