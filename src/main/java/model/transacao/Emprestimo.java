package model.transacao;


import javax.persistence.Entity;
import java.util.Date;
import contract.models.transacao.IEmprestimo;

@Entity
public class Emprestimo extends Transacao implements IEmprestimo {
	
	public Emprestimo () {
		super();
	}
	
	public Emprestimo (int id, int numeroConta, float valorTransacao, Date dataTransacao) {
		super(id, numeroConta, valorTransacao, dataTransacao);
	}

}
