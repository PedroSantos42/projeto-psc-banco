package model.transacao;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;

import java.util.Date;

import contract.models.transacao.ITransacao;
import model.conta.Conta;

@Entity(name = "Transacao")
@Table(name = "transacao")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_transacao")
public class Transacao implements ITransacao {

	@Id
	@Column (name = "id_transacao")
	private int id;
	
	@Column (name = "numero_conta", nullable = false)
	private int numeroConta;
	
	@Column (name = "valor_transacao", nullable = false)
	private float valorTransacao;
	
	@Column (name = "data_transacao", nullable = false)
	private Date dataTransacao;
	
	@ManyToOne
	@JoinColumn(name = "id_conta", nullable = false)
	private Conta conta;
	
	public Transacao () {}
	
	public Transacao (int id, int numeroConta, float valorTransacao, Date dataTransacao, Conta conta) {
		super();
		this.id = id;
		this.numeroConta = numeroConta;
		this.valorTransacao = valorTransacao;
		this.dataTransacao = dataTransacao;
		this.conta = conta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public float getValorTransacao() {
		return valorTransacao;
	}

	public void setValorTransacao(float valorTransacao) {
		this.valorTransacao = valorTransacao;
	}

	public Date getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Object getPrimaryKey() {
		return getId();
	}

	@Override
	public String toString() {
		return "Transacao [id=" + id + ", numeroConta=" + numeroConta + ", valorTransacao=" + valorTransacao
				+ ", dataTransacao=" + formatDate(dataTransacao) + "]";
	}
	
	private static String formatDate(Date date) {
		String formatedDate = String.valueOf(date.getDay()) 	+ "/";
		formatedDate += String.valueOf(date.getMonth()) 		+ "/";
		formatedDate += String.valueOf(date.getYear() + 1900) 	+ " ";
		formatedDate += String.valueOf(date.getHours()) 		+ ":";
		formatedDate += String.valueOf(date.getMinutes()) 		+ ":";
		formatedDate += date.getSeconds() < 10 ? "0" + String.valueOf(date.getSeconds()) : String.valueOf(date.getSeconds());
		
		return formatedDate;
	}
}
