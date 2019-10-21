package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.conta.ContaCorrenteDAO;
import dao.pessoa.ClienteDAO;
import org.junit.Ignore;
import model.conta.ContaCorrente;
import model.pessoa.Pessoa;

public class ContaCorrenteDAOTests {

	private ContaCorrenteDAO _dao = new ContaCorrenteDAO();

	@BeforeClass
	public static void setUp() {
		System.out.println("Starting Conta DAO Tests...");
	}

	@AfterClass
	public static void tearDown() {
		System.out.println("Finishing Conta DAO Tests...");
//		UtilJPA.closeEntityManagerFactory();
	}

	@Test
	public void add_ValidArg_AddToDatabase() {
		// arrange
		int id = 1;
		int numeroConta = 1;
		double saldo = 100.0;
		String situacao = "a";

		Pessoa p = new Pessoa();
		p.setId(1);
		p = (Pessoa) new ClienteDAO().listByPrimaryKey(p.getClass(), p.getPrimaryKey());

		ContaCorrente contaCorrente = new ContaCorrente(id, numeroConta, saldo, situacao, p, null);

		// act
		_dao.add(contaCorrente);

		ContaCorrente contaCorrente2 = (ContaCorrente) _dao.listByObject(contaCorrente);

		// assert
		assertEquals(contaCorrente.toString(), contaCorrente2.toString());
	}

	@Test
	public void add_SecondAccountToSamePerson_MaintainSinglePessoaRecord() {
		// arrange
		int id = 2;
		int numeroConta = 2;
		double saldo = 250;
		String situacao = "b";

		Pessoa p = new Pessoa();
		p.setId(1);
		p = (Pessoa) new ClienteDAO().listByPrimaryKey(p.getClass(), p.getPrimaryKey());

		ContaCorrente contaCorrente = new ContaCorrente(id, numeroConta, saldo, situacao, p, null);

		// act
		_dao.add(contaCorrente);

		ContaCorrente contaCorrente2 = (ContaCorrente) _dao.listByObject(contaCorrente);

		// assert
		assertEquals(contaCorrente.toString(), contaCorrente2.toString());
	}

	@Test
	public void listByObject_ValidArg_ReturnValidRecord() {
		// arrange
		int id = 3;
		int numeroConta = 3;
		double saldo = 125.0;
		String situacao = "a";

		Pessoa p = new Pessoa();
		p.setId(1);
		p = (Pessoa) new ClienteDAO().listByPrimaryKey(p.getClass(), p.getPrimaryKey());

		ContaCorrente contaCorrente = new ContaCorrente(id, numeroConta, saldo, situacao, p, null);

		// act
		_dao.add(contaCorrente);

		ContaCorrente contaCorrente2 = (ContaCorrente) _dao.listByObject(contaCorrente);

		// assert
		assertEquals(contaCorrente.toString(), contaCorrente2.toString());
	}

	@Test
	public void listByPrimaryKey_ValidArg_ReturnValidRecord() {
		// arrange
		int id = 2;
		ContaCorrente contaCorrente = new ContaCorrente();
		contaCorrente.setId(id);

		// act
		ContaCorrente contaCorrente2 = (ContaCorrente) _dao.listByPrimaryKey(contaCorrente.getClass(),
				contaCorrente.getPrimaryKey());

		// assert
		assertNotNull(contaCorrente2);
	}

	@Test
	public void removeByObject_ValidArg_RemoveRecordFromDatabase() {
		// arrange
		int id = 4;
		int numeroConta = 4;
		double saldo = 140.0;
		String situacao = "a";

		Pessoa p = new Pessoa();
		p.setId(1);
		p = (Pessoa) new ClienteDAO().listByPrimaryKey(p.getClass(), p.getPrimaryKey());

		ContaCorrente contaCorrente = new ContaCorrente(id, numeroConta, saldo, situacao, p, null);

		// act
		_dao.add(contaCorrente);
		_dao.removeByObject(contaCorrente);

		contaCorrente = new ContaCorrente();
		contaCorrente.setId(id);
		contaCorrente = (ContaCorrente) _dao.listByPrimaryKey(contaCorrente.getClass(), contaCorrente.getPrimaryKey());

		// assert
		assertNull(contaCorrente);
	}

	@Ignore
	@Test
	public void removeByPrimaryKey_ValidArg_RemoveRecordFromDatabase() {
		// arrange

		// act

		// assert
	}

	@Test
	public void update_ValidArg_UpdateRecordInDatabase() {
		// arrange
		int id = 5;
		int numeroConta = 6;
		double saldo = 245.0;
		String situacao = "b";

		Pessoa p = new Pessoa();
		p.setId(1);
		p = (Pessoa) new ClienteDAO().listByPrimaryKey(p.getClass(), p.getPrimaryKey());

		ContaCorrente contaCorrente = new ContaCorrente(id, numeroConta, saldo, situacao, p, null);

		// act
		_dao.add(contaCorrente);
		contaCorrente.setSaldo(500);
		contaCorrente.setSituacao("a");
		contaCorrente.setNumeroConta(5);
		_dao.update(contaCorrente);

		ContaCorrente contaCorrente2 = (ContaCorrente) _dao.listByObject(contaCorrente);

		// assert
		assertEquals(contaCorrente.toString(), contaCorrente2.toString());

	}

	@Test
	public void listAll_ValidArg_ReturnAllRecordsFromDatabase() {

		// arrange
		int id = 6;
		int numeroConta = 6;
		double saldo = 85.5;
		String situacao = "a";

		Pessoa p = new Pessoa();
		p.setId(1);
		p = (Pessoa) new ClienteDAO().listByPrimaryKey(p.getClass(), p.getPrimaryKey());

		ContaCorrente contaCorrente = new ContaCorrente(id, numeroConta, saldo, situacao, p, null);

		// act
		ArrayList<ContaCorrente> list = (ArrayList<ContaCorrente>) _dao.listAllContaCorrente(contaCorrente);

		// assert
		assertTrue(list.size() == 3);

	}

}
