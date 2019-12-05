package model.pessoa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import contract.models.pessoa.IFuncionario;
import model.Endereco;

@Entity(name = "Funcionario")
@Table(name = "funcionario")
@DiscriminatorValue(value = "PessoaFuncionario")
public class Funcionario extends Pessoa implements IFuncionario {

	@Column(name = "data_contratacao", nullable = true)
	private Date dataContratacao;

	public Funcionario() { }

	public Funcionario(int id, String cpf, String nome, Date dataNascimento, Endereco endereco, Date dataContratacao) {
		super(id, cpf, nome, dataNascimento, endereco);
		this.dataContratacao = dataContratacao;
	}

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public String toString() {
		return "ID: " + getId() + ", CPF: " + getCpf();
	}
}
