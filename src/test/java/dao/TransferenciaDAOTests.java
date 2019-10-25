package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.conta.ContaCorrenteDAO;
import dao.transacao.TransferenciaDAO;
import model.conta.Conta;
import model.transacao.Transferencia;

public class TransferenciaDAOTests {

	private TransferenciaDAO _dao = new TransferenciaDAO();

	@BeforeClass
	public static void setUp() {
		System.out.println("Starting Transferencia DAO Tests...");
	}

	@AfterClass
	public static void tearDown() {
		System.out.println("Finishing Transferencia DAO Tests...");
//		UtilJPA.closeEntityManagerFactory();
	}

	@Test
	public void add_ValidArg_AddToDatabase() {
		// arrange
		int id = 2;
		int numeroConta = 1;
		float valorTransacao = 25.90f;
		Date dataTransacao = new Date();
		
		Conta conta = new Conta();
		conta.setId(1);
		
		conta = (Conta) new ContaCorrenteDAO().listByPrimaryKey(conta.getClass(), conta.getPrimaryKey());
		
		Transferencia t = new Transferencia(id, numeroConta, valorTransacao, dataTransacao, conta);

		// act
		_dao.add(t);

		Transferencia t2 = (Transferencia) _dao.listByObject(t);

		// assert
		assertEquals(t.toString(), t2.toString());
	}

	@Test
	public void listByObject_ValidArg_ReturnValidRecord() {
		// arrange
		int id = 2;
		int numeroConta = 1;
		float valorTransacao = 25.90f;
		Date dataTransacao = new Date();
		
		Conta conta = new Conta();
		conta.setId(1);
		
		conta = (Conta) new ContaCorrenteDAO().listByPrimaryKey(conta.getClass(), conta.getPrimaryKey());
		
		Transferencia t = new Transferencia(id, numeroConta, valorTransacao, dataTransacao, conta);
		// act
		_dao.add(t);
		
		Transferencia t2 = (Transferencia) _dao.listByObject(t);
		// assert
		assertEquals(t.toString(), t2.toString());
	}

	@Test
	public void listByPrimaryKey_ValidArg_ReturnValidRecord() {
		// arrange
		int id = 2;
		Transferencia t = new Transferencia();
		t.setId(id);
		// act
		Transferencia t2 = (Transferencia) _dao.listByPrimaryKey(t.getClass(), t.getPrimaryKey());
		// assert
		
		assertNotNull(t2);	
	}

	@Test
	public void removeByObject_ValidArg_RemoveRecordFromDatabase() {
		// arrange
		int id = 2;
		int numeroConta = 1;
		float valorTransacao = 25.90f;
		Date dataTransacao = new Date();
		
		Conta conta = new Conta();
		conta.setId(1);
		
		conta = (Conta) new ContaCorrenteDAO().listByPrimaryKey(conta.getClass(), conta.getPrimaryKey());
		
		Transferencia t = new Transferencia(id, numeroConta, valorTransacao, dataTransacao, conta);
		// act
		_dao.add(t);
		_dao.removeByObject(t);
		
		t = new Transferencia();
		t.setId(id);
		t = (Transferencia) _dao.listByPrimaryKey(t.getClass(), t.getPrimaryKey());
		// assert
		assertNull(t);
	}

	@Test
	public void removeByPrimaryKey_ValidArg_RemoveRecordFromDatabase() {
		// arrange
		int id = 2;
		int numeroConta = 1;
		float valorTransacao = 25.90f;
		Date dataTransacao = new Date();
		
		Conta conta = new Conta();
		conta.setId(1);
		
		conta = (Conta) new ContaCorrenteDAO().listByPrimaryKey(conta.getClass(), conta.getPrimaryKey());
		
		Transferencia t = new Transferencia(id, numeroConta, valorTransacao, dataTransacao, conta);
		// act
		_dao.add(t);
		_dao.removeByPrimaryKey(t, t.getPrimaryKey());
		
		t = new Transferencia();
		t.setId(id);
		t = (Transferencia) _dao.listByPrimaryKey(t.getClass(), t.getPrimaryKey());
		// assert
		assertNull(t);
	}

	@Test
	public void update_ValidArg_UpdateRecordInDatabase() {
		// arrange
		int id = 2;
		int numeroConta = 1;
		float valorTransacao = 25.90f;
		Date dataTransacao = new Date();
		
		Conta conta = new Conta();
		conta.setId(1);
		
		conta = (Conta) new ContaCorrenteDAO().listByPrimaryKey(conta.getClass(), conta.getPrimaryKey());
		
		Transferencia t = new Transferencia(id, numeroConta, valorTransacao, dataTransacao, conta);
		// act
		_dao.add(t);
		_dao.update(t);
		
		Transferencia t2 = (Transferencia) _dao.listByObject(t);
		// assert
		assertEquals(t.toString(), t2.toString());
	}
}
