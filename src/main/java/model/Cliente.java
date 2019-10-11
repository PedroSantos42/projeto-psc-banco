package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;

import contract.models.ICliente;

@Entity(name = "Cliente")
@DiscriminatorColumn(name = "PessoaCliente")
public class Cliente extends Pessoa implements ICliente {

	@Column(name = "data_cadastro",
			nullable = false)
	private Date dataCadastro;

	public Cliente() {
	}

	public Cliente(Date dataCadastro, int id, String cpf, String nome, Date dataNascimento, Endereco endereco) {
		super(id, cpf, nome, dataNascimento, endereco);
		this.dataCadastro = dataCadastro;
	}

	public String toString() {
		return "ID: " + getId() + ", CPF: " + getCpf();
	}
}
