package dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.conta.ContaCorrenteDAO;
import dao.transacao.EmprestimoDAO;
import org.junit.Ignore;
import model.conta.Conta;
import model.transacao.Emprestimo;;

public class EmprestimoDAOTests {
	private EmprestimoDAO _dao = new EmprestimoDAO();

	@BeforeClass
	public static void setUp() {
		System.out.println("Starting Emprestimo DAO Tests...");
	}

	@AfterClass
	public static void tearDown() {
		System.out.println("Finishing Emprestimo DAO Tests...");
//		UtilJPA.closeEntityManagerFactory();
	}

	@Test
	public void add_ValidArg_AddToDatabase() {
		// arrange
		int id = 1;
		int numeroConta = 1;
		float valorTransacao = 400f;
		Date dataTransacao = new Date();
		
		Conta conta = new Conta();
		
		conta.setId(1);
		conta = (Conta) new ContaCorrenteDAO().listByPrimaryKey(conta.getClass(), conta.getPrimaryKey());
		
		Emprestimo e = new Emprestimo(id, numeroConta, valorTransacao, dataTransacao, conta);

		// act
		_dao.add(e);

		Emprestimo e2 = (Emprestimo) _dao.listByObject(e);

		// assert
		assertEquals(e.toString(), e2.toString());
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
