package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.pessoa.ClienteDAO;
import model.Endereco;
import model.pessoa.Cliente;
import util.UtilJPA;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteDAOTests {

	private static final String List = null;
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
	public void _01_add_ValidArg_AddToDatabase() {
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

		Cliente c = new Cliente(dataCadastro, id, cpf, nome, dataNascimento, endereco);

		// act
		_dao.add(c);

		Cliente c2 = (Cliente) _dao.listByObject(c);

		// assert
		assertEquals(c.toString(), c2.toString());
	}

	@Test
	public void _02_listByObject_ValidArg_ReturnValidRecord() {
		// arrange
		Date dataCadastro = new Date();
		int id = 2;
		String cpf = "cpf 2";
		String nome = "nome 2";
		Date dataNascimento = new Date();

		int numero = 1;
		String logradouro = "logradouro 2";
		String complemento = "complemento 2";
		String bairro = "bairro 2";
		String cidade = "cidade 2";
		String uf = "uf 2";
		String cep = "cep 2";
		Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep);

		Cliente c = new Cliente(dataCadastro, id, cpf, nome, dataNascimento, endereco);

		// act
		_dao.add(c);

		Cliente c2 = (Cliente) _dao.listByObject(c);

		// assert
		assertEquals(c.toString(), c2.toString());
	}

	@Test
	public void _03_listByPrimaryKey_ValidArg_ReturnValidRecord() {
		// arrange
		int id = 2;
		Cliente c = new Cliente();
		c.setId(id);

		// act
		Cliente c2 = (Cliente) _dao.listByPrimaryKey(c.getClass(), c.getPrimaryKey());

		// assert
		assertNotNull(c2);
	}

	@Test
	public void _04_removeByObject_ValidArg_RemoveRecordFromDatabase() {
		// arrange
		Date dataCadastro = new Date();
		int id = 3;
		String cpf = "cpf 3";
		String nome = "nome 3";
		Date dataNascimento = new Date();

		int numero = 1;
		String logradouro = "logradouro 3";
		String complemento = "complemento 3";
		String bairro = "bairro 3";
		String cidade = "cidade 3";
		String uf = "uf 3";
		String cep = "cep 3";
		Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep);

		Cliente c = new Cliente(dataCadastro, id, cpf, nome, dataNascimento, endereco);

		// act
		_dao.add(c);
		_dao.removeByObject(c);

		c = new Cliente();
		c.setId(id);
		c = (Cliente) _dao.listByPrimaryKey(c.getClass(), c.getPrimaryKey());

		// assert
		assertNull(c);
	}

	@Test
	public void _05_removeByPrimaryKey_ValidArg_RemoveRecordFromDatabase() {
		// arrange
		Date dataCadastro = new Date();
		int id = 4;
		String cpf = "cpf 4";
		String nome = "nome 4";
		Date dataNascimento = new Date();

		int numero = 1;
		String logradouro = "logradouro 4";
		String complemento = "complemento 4";
		String bairro = "bairro 4";
		String cidade = "cidade 4";
		String uf = "uf 4";
		String cep = "cep 4";
		Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep);

		Cliente c = new Cliente(dataCadastro, id, cpf, nome, dataNascimento, endereco);

		// act
		_dao.add(c);
		_dao.removeByObject(c);

		c = new Cliente();
		c.setId(id);
		c = (Cliente) _dao.listByPrimaryKey(c.getClass(), c.getPrimaryKey());

		// assert
		assertNull(c);
	}

	@Test
	public void _06_update_ValidArg_UpdateRecordInDatabase() {
		// arrange
		Date dataCadastro = new Date();
		int id = 5;
		String cpf = "cpf 5";
		String nome = "nome 5";
		Date dataNascimento = new Date();

		int numero = 1;
		String logradouro = "logradouro 5";
		String complemento = "complemento 5";
		String bairro = "bairro 5";
		String cidade = "cidade 5";
		String uf = "uf 5";
		String cep = "cep 5";
		Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep);

		Cliente c = new Cliente(dataCadastro, id, cpf, nome, dataNascimento, endereco);

		// act
		_dao.add(c);
		c.setNome(c.getNome() + " atualizado");
		_dao.update(c);

		Cliente c2 = (Cliente) _dao.listByObject(c);

		// assert
		assertEquals(c.toString(), c2.toString());
	}
	
	@Test
	public void _07_listAll_ValidArg_ReturnAllRecordsFromDatabase() {
		// arrange
		Date dataCadastro = new Date();
		int id = 6;
		String cpf = "cpf 6";
		String nome = "nome 6";
		Date dataNascimento = new Date();
		
		int numero = 6;
		String logradouro = "logradouro 6";
		String complemento = "complemento 6";
		String bairro = "bairro 6";
		String cidade = "cidade 6";
		String uf = "uf 6";
		String cep = "cep 6";
		Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep);

		Cliente c = new Cliente(dataCadastro, id, cpf, nome, dataNascimento, endereco);
		
		// act
		ArrayList<Cliente> list = (ArrayList<Cliente>) _dao.listAllCliente(c);
		
		// assert
		assertTrue(list.size() == 3);
	}
}
