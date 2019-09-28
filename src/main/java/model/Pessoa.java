package model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import contract.models.IPessoa;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_pessoa")
public class Pessoa implements IPessoa {

	@Id
	@Column(name = "id_pessoa")
	private int id;
	
	@Column(nullable = false)
	private String cpf;

	@Column(nullable = false)
	private String nome;

	@Column(name = "data_nascimento",
			nullable = false)
	private Date dataNascimento;

	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	public Pessoa() {}

	public Pessoa(int id, String cpf, String nome, Date dataNascimento, Endereco endereco) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.endereco = (endereco == null) ? new Endereco() : endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
		endereco.setPessoa(this);
	}
	
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", dataNascimento=" + dataNascimento
				+ ", endereco=" + endereco + "]";
	}

	public Object getPrimaryKey() {
		return getId();
	}
}
