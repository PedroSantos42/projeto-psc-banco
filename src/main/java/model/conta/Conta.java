package model.conta;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import contract.models.conta.IConta;
import model.Pessoa;
import model.transacao.Transacao;

@Entity(name = "Conta")
@Table(name = "conta")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_conta")
public class Conta implements IConta {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conta")
	private int id;

	@Column(name = "numero_conta", nullable = false)
	private int numeroConta;

	@Column(nullable = false)
	private double saldo;

	@Column(nullable = false)
	private String situacao;

	@ManyToOne
	@JoinColumn(name = "id_pessoa", nullable = false)
	private Pessoa pessoa;

	@OneToMany(mappedBy = "conta")
	private List<Transacao> transacoes;

	public Conta() {
		super();
	}

	public Conta(int id, int numeroConta, double saldo, String situacao, Pessoa pessoa, List<Transacao> transacoes) {
		super();
		this.id = id;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.situacao = situacao;
		this.pessoa = pessoa;
		this.transacoes = transacoes != null ? transacoes : null;
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

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", numeroConta=" + numeroConta + ", saldo=" + saldo + ", situacao=" + situacao + "]";
	}

	public Object getPrimaryKey() {
		return getId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + numeroConta;
		long temp;
		temp = Double.doubleToLongBits(saldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((situacao == null) ? 0 : situacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (id != other.id)
			return false;
		if (numeroConta != other.numeroConta)
			return false;
		if (Double.doubleToLongBits(saldo) != Double.doubleToLongBits(other.saldo))
			return false;
		if (situacao == null) {
			if (other.situacao != null)
				return false;
		} else if (!situacao.equals(other.situacao))
			return false;
		return true;
	}

}
