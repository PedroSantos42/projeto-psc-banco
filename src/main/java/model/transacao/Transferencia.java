package model.transacao;

import javax.persistence.Entity;
import java.util.Date;
import contract.models.transacao.ITransferencia;

@Entity
public class Transferencia extends Transacao implements ITransferencia {
	
	public Transferencia () {
		super();
	}
	
	public Transferencia (int id, int numeroConta, float valorTransacao, Date dataTransacao) {
		super(id, numeroConta, valorTransacao, dataTransacao);
	}

}

