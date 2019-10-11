package model.transacao;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Column;

import java.util.Date;

import contract.models.transacao.ITransacao;

@Entity(name = "Transacao")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_transacao")
public class Transacao implements ITransacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_transacao")
	private int id;
	
	//Dúvida!
	@Column (name = "numero_conta", nullable = false)
	private int numeroConta;
	
	@Column (name = "valor_transacao", nullable = false)
	private float valorTransacao;
	
	@Column (name = "data_transacao", nullable = false)
	private Date dataTransacao;
	
	public Transacao () {}
	
	public Transacao (int id, int numeroConta, float valorTransacao, Date dataTransacao) {
		super();
		this.id = id;
		this.numeroConta = numeroConta;
		this.valorTransacao = valorTransacao;
		this.dataTransacao = dataTransacao;
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

	public Object getPrimaryKey() {
		return null;
	}
}
