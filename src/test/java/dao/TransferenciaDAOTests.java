package dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.conta.ContaCorrenteDAO;
import dao.transacao.TransferenciaDAO;
import org.junit.Ignore;
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

	@Ignore
	@Test
	public void listByObject_ValidArg_ReturnValidRecord() {
		// arrange
		
		// act
		
		// assert
	}

	@Ignore
	@Test
	public void listByPrimaryKey_ValidArg_ReturnValidRecord() {
		// arrange
		
		// act
		
		// assert
	}

	@Ignore
	@Test
	public void removeByObject_ValidArg_RemoveRecordFromDatabase() {
		// arrange
		
		// act
		
		// assert
	}

	@Ignore
	@Test
	public void removeByPrimaryKey_ValidArg_RemoveRecordFromDatabase() {
		// arrange
		
		// act
		
		// assert
	}

	@Ignore
	@Test
	public void update_ValidArg_UpdateRecordInDatabase() {
		// arrange
		
		// act
		
		// assert
	}
}
