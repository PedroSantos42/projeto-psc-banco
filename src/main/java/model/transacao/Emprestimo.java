package model.transacao;


import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import contract.models.transacao.IEmprestimo;
import model.conta.Conta;

@Entity
@DiscriminatorValue(value = "tipo_transacao")
public class Emprestimo extends Transacao implements IEmprestimo {
	
	@Column(name = "parcelas", nullable = false)
	private int parcelas;
	
	@Column(name = "juros", nullable = false)
	private double juros;
	
	public Emprestimo () {
		super();
	}
	
	public int getParcelas() {
		return parcelas;
	}



	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}



	public double getJuros() {
		return juros;
	}



	public void setJuros(double juros) {
		this.juros = juros;
	}



	public Emprestimo (int id, int numeroConta, float valorTransacao, Date dataTransacao, Conta conta, int parcelas, double juros) {
		super(id, numeroConta, valorTransacao, dataTransacao, conta);
		this.parcelas = parcelas;
		this.juros = juros;
	}

	@Override
	public String toString() {
		return "Emprestimo [parcelas=" + parcelas + ", juros=" + juros + ", getId()=" + getId() + ", getNumeroConta()="
				+ getNumeroConta() + ", getValorTransacao()=" + getValorTransacao() + ", getDataTransacao()="
				+ getDataTransacao() + ", getConta()=" + getConta() + ", getPrimaryKey()=" + getPrimaryKey()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}
}
