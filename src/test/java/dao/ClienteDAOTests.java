package dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import dao.pessoa.ClienteDAO;
import model.Endereco;
import model.pessoa.Cliente;
import util.UtilJPA;

public class ClienteDAOTests {

	private ClienteDAO _dao = new ClienteDAO();
	
	public static void setUp() {
		System.out.println("Iniciando ClienteDAO testes...");
		UtilJPA.createEntityManagerFactory();
	}
	
	public static void tearDown() {
		System.out.println("Finalizando ClienteDAO testes...");
//		UtilJPA.closeEntityManagerFactory();
	}
	
	@Test
	public void add_ValidArg_AddToDatabase() {
		// arrange
		Date dataCadastro = new Date();
		int id = 1;
		String cpf = "cpf 1";
		String nome = "nome 1";
		Date dataNascimento = new Date();
		
		int numero = 1;
		String logradouro = "logradouro 1";
		String complemento = "complemento 1";
		String bairro = "bairro 1";
		String cidade = "cidade 1";
		String uf = "uf 1";
		String cep = "cep 1";
		Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep);

		Cliente c = new Cliente(dataCadastro, id, cpf, nome, dataNascimento, endereco );
		
		// act
		_dao.add(c);
		
		Cliente c2 = (Cliente) _dao.listByObject(c);
		
		// assert
		assertEquals(c.toString(), c2.toString());
	}
}
