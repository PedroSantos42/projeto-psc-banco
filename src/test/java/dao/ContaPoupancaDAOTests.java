package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import dao.conta.ContaPoupancaDAO;
import dao.pessoa.ClienteDAO;
import model.conta.ContaCorrente;
import model.conta.ContaPoupanca;
import model.pessoa.Pessoa;

public class ContaPoupancaDAOTests {

	private ContaPoupancaDAO _dao = new ContaPoupancaDAO();

	@BeforeClass
	public static void setUp() {
		System.out.println("Starting Conta Poupança DAO Tests...");
	}

	@AfterClass
	public static void tearDown() {
		System.out.println("Finishing Conta Poupança DAO Tests...");
//		UtilJPA.closeEntityManagerFactory();
	}

	@Test
	public void add_ValidArg_AddToDatabase() {
		// arrange
		int id = 7;
		int numeroConta = 7;
		double saldo = 99.0;
		String situacao = "a";

		Pessoa p = new Pessoa();
		p.setId(1);
		p = (Pessoa) new ClienteDAO().listByPrimaryKey(p.getClass(), p.getPrimaryKey());

		ContaPoupanca contaPoupanca = new ContaPoupanca(id, numeroConta, saldo, situacao, p, null);

		// act
		_dao.add(contaPoupanca);

		ContaPoupanca contaPoupanca2 = (ContaPoupanca) _dao.listByObject(contaPoupanca);

		// assert
		assertEquals(contaPoupanca.toString(), contaPoupanca2.toString());
	}

	@Test
	public void listByObject_ValidArg_ReturnValidRecord() {
		// arrange
		int id = 8;
		int numeroConta = 8;
		double saldo = 325.8;
		String situacao = "a";

		Pessoa p = new Pessoa();
		p.setId(1);
		p = (Pessoa) new ClienteDAO().listByPrimaryKey(p.getClass(), p.getPrimaryKey());

		ContaPoupanca contaPoupanca = new ContaPoupanca(id, numeroConta, saldo, situacao, p, null);

		// act
		_dao.add(contaPoupanca);

		ContaPoupanca contaPoupanca2 = (ContaPoupanca) _dao.listByObject(contaPoupanca);

		// assert
		assertEquals(contaPoupanca.toString(), contaPoupanca2.toString());
	}

	@Test
	public void listByPrimaryKey_ValidArg_ReturnValidRecord() {
		// arrange
		int id = 7;
		ContaPoupanca contaPoupanca = new ContaPoupanca();
		contaPoupanca.setId(id);

		// act
		ContaPoupanca contaPoupanca2 = (ContaPoupanca) _dao.listByPrimaryKey(contaPoupanca.getClass(),
				contaPoupanca.getPrimaryKey());

		// assert
		assertNotNull(contaPoupanca2);
	}

	@Test
	public void removeByObject_ValidArg_RemoveRecordFromDatabase() {
		// arrange
		int id = 9;
		int numeroConta = 9;
		double saldo = 540.0;
		String situacao = "a";

		Pessoa p = new Pessoa();
		p.setId(1);
		p = (Pessoa) new ClienteDAO().listByPrimaryKey(p.getClass(), p.getPrimaryKey());

		ContaPoupanca contaPoupanca = new ContaPoupanca(id, numeroConta, saldo, situacao, p, null);

		// act
		_dao.add(contaPoupanca);
		_dao.removeByObject(contaPoupanca);

		contaPoupanca = new ContaPoupanca();
		contaPoupanca.setId(id);
		contaPoupanca = (ContaPoupanca) _dao.listByPrimaryKey(contaPoupanca.getClass(), contaPoupanca.getPrimaryKey());

		// assert
		assertNull(contaPoupanca);
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
		int id = 10;
		int numeroConta = 33;
		double saldo = 100.0;
		String situacao = "b";

		Pessoa p = new Pessoa();
		p.setId(1);
		p = (Pessoa) new ClienteDAO().listByPrimaryKey(p.getClass(), p.getPrimaryKey());

		ContaPoupanca contaPoupanca = new ContaPoupanca(id, numeroConta, saldo, situacao, p, null);

		// act
		_dao.add(contaPoupanca);
		contaPoupanca.setSaldo(150.5);
		contaPoupanca.setSituacao("a");
		contaPoupanca.setNumeroConta(10);
		_dao.update(contaPoupanca);

		ContaPoupanca contaPoupanca2 = (ContaPoupanca) _dao.listByObject(contaPoupanca);

		// assert
		assertEquals(contaPoupanca.toString(), contaPoupanca2.toString());
	}

	@Test
	public void listAll_ValidArg_ReturnAllRecordsFromDatabase() {

		// arrange
		int id = 11;
		int numeroConta = 11;
		double saldo = 125.5;
		String situacao = "a";

		Pessoa p = new Pessoa();
		p.setId(1);
		p = (Pessoa) new ClienteDAO().listByPrimaryKey(p.getClass(), p.getPrimaryKey());

		ContaPoupanca contaPoupanca = new ContaPoupanca(id, numeroConta, saldo, situacao, p, null);

		// act
		ArrayList<ContaPoupanca> list = (ArrayList<ContaPoupanca>) _dao.listAllContaPoupanca(contaPoupanca);

		// assert
		assertTrue(list.size() == 3);
	}

}
