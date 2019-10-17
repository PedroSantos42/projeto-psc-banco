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

import dao.pessoa.FuncionarioDAO;
import model.Endereco;
import model.pessoa.Funcionario;
import util.UtilJPA;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FuncionarioDAOTests {

	private FuncionarioDAO _dao = new FuncionarioDAO();

	public static void setUp() {
		System.out.println("Iniciando Funcionario DAO testes...");
		UtilJPA.createEntityManagerFactory();
	}

	public static void tearDown() {
		System.out.println("Finalizando Funcionario DAO testes...");
//		UtilJPA.closeEntityManagerFactory();
	}

	@Test
	public void _01_add_ValidArg_AddToDatabase() {
		// arrange
		Date dataCadastro = new Date();
		int id = 6;
		String cpf = "cpf 1";
		String nome = "nome 1";

		int numero = 10;
		String logradouro = "logradouro 10";
		String complemento = "complemento 10";
		String bairro = "bairro 10";
		String cidade = "cidade 10";
		String uf = "uf 10";
		String cep = "cep 10";
		Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep);

		Funcionario f = new Funcionario(id, cpf, nome, dataCadastro, endereco, dataCadastro);

		// act
		_dao.add(f);

		Funcionario f2 = (Funcionario) _dao.listByObject(f);

		// assert
		assertEquals(f.toString(), f2.toString());
	}

	@Test
	public void _02_listByObject_ValidArg_ReturnValidRecord() {
		// arrange
		Date dataCadastro = new Date();
		int id = 7;
		String cpf = "cpf 2";
		String nome = "nome 2";

		int numero = 1;
		String logradouro = "logradouro 20";
		String complemento = "complemento 20";
		String bairro = "bairro 20";
		String cidade = "cidade 20";
		String uf = "uf 20";
		String cep = "cep 20";
		Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep);

		Funcionario f = new Funcionario(id, cpf, nome, dataCadastro, endereco, dataCadastro);

		// act
		_dao.add(f);

		Funcionario f2 = (Funcionario) _dao.listByObject(f);

		// assert
		assertEquals(f.toString(), f2.toString());
	}

	@Test
	public void _03_listByPrimaryKey_ValidArg_ReturnValidRecord() {
		// arrange
		int id = 7;
		Funcionario f = new Funcionario();
		f.setId(id);

		// act
		Funcionario f2 = (Funcionario) _dao.listByPrimaryKey(f.getClass(), f.getPrimaryKey());

		// assert
		assertNotNull(f2);
	}

	@Test
	public void _04_removeByObject_ValidArg_RemoveRecordFromDatabase() {
		// arrange
		Date dataCadastro = new Date();
		int id = 8;
		String cpf = "cpf 3";
		String nome = "nome 3";

		int numero = 1;
		String logradouro = "logradouro 30";
		String complemento = "complemento 30";
		String bairro = "bairro 30";
		String cidade = "cidade 30";
		String uf = "uf 30";
		String cep = "cep 30";
		Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep);

		Funcionario f = new Funcionario(id, cpf, nome, dataCadastro, endereco, dataCadastro);

		// act
		_dao.add(f);
		_dao.removeByObject(f);

		f = new Funcionario();
		f.setId(id);
		f = (Funcionario) _dao.listByPrimaryKey(f.getClass(), f.getPrimaryKey());

		// assert
		assertNull(f);
	}

	@Test
	public void _05_removeByPrimaryKey_ValidArg_RemoveRecordFromDatabase() {
		// arrange
		Date dataCadastro = new Date();
		int id = 9;
		String cpf = "cpf 4";
		String nome = "nome 4";

		int numero = 1;
		String logradouro = "logradouro 40";
		String complemento = "complemento 40";
		String bairro = "bairro 40";
		String cidade = "cidade 40";
		String uf = "uf 40";
		String cep = "cep 40";
		Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep);

		Funcionario f = new Funcionario(id, cpf, nome, dataCadastro, endereco, dataCadastro);

		// act
		_dao.add(f);
		_dao.removeByObject(f);

		f = new Funcionario();
		f.setId(id);
		f = (Funcionario) _dao.listByPrimaryKey(f.getClass(), f.getPrimaryKey());

		// assert
		assertNull(f);
	}

	@Test
	public void _06_update_ValidArg_UpdateRecordInDatabase() {
		// arrange
		Date dataCadastro = new Date();
		int id = 10;
		String cpf = "cpf 5";
		String nome = "nome 5";

		int numero = 1;
		String logradouro = "logradouro 50";
		String complemento = "complemento 50";
		String bairro = "bairro 50";
		String cidade = "cidade 50";
		String uf = "uf 50";
		String cep = "cep 50";
		Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep);

		Funcionario f = new Funcionario(id, cpf, nome, dataCadastro, endereco, dataCadastro);

		// act
		_dao.add(f);
		f.setNome(f.getNome() + " atualizado");
		_dao.update(f);

		Funcionario f2 = (Funcionario) _dao.listByObject(f);

		// assert
		assertEquals(f.toString(), f2.toString());
	}
	
	@Test
	public void _07_listAll_ValidArg_ReturnAllRecordsFromDatabase() {
		// arrange
		Date dataCadastro = new Date();
		int id = 11;
		String cpf = "cpf 6";
		String nome = "nome 6";
		
		int numero = 6;
		String logradouro = "logradouro 60";
		String complemento = "complemento 60";
		String bairro = "bairro 60";
		String cidade = "cidade 60";
		String uf = "uf 60";
		String cep = "cep 60";
		Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep);

		Funcionario f = new Funcionario(id, cpf, nome, dataCadastro, endereco, dataCadastro);
		
		// act
		ArrayList<Funcionario> list = (ArrayList<Funcionario>) _dao.listAllFuncionario(f);
		
		// assert
		assertTrue(list.size() == 3);
	}
}
