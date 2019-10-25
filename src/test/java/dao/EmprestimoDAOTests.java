package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.conta.ContaCorrenteDAO;
import dao.pessoa.ClienteDAO;
import dao.transacao.EmprestimoDAO;
import org.junit.Ignore;
import model.conta.Conta;
import model.conta.ContaCorrente;
import model.pessoa.Pessoa;
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

	@Test
	public void listByObject_ValidArg_ReturnValidRecord() {
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


	@Test
	public void listByPrimaryKey_ValidArg_ReturnValidRecord() {
		// arrange
		int id = 1;
		Emprestimo e = new Emprestimo ();
		e.setId(id);
		// act
		Emprestimo e2 = (Emprestimo) _dao.listByPrimaryKey(e.getClass(), e.getPrimaryKey());)
		// assert
		assertNotNull(e2);
		
	}

	@Test
	public void removeByObject_ValidArg_RemoveRecordFromDatabase() {
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
		_dao.removeByObject(e);
		
		e = new Emprestimo();
		e.setId(id);
		e = (Emprestimo) _dao.listByPrimaryKey(e.getClass(), e.getPrimaryKey());
		
		// assert
		assertNull(e);
	}

	@Test
	public void removeByPrimaryKey_ValidArg_RemoveRecordFromDatabase() {
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
		_dao.removeByPrimaryKey(e, e.getPrimaryKey());
		
		e = new Emprestimo();
		e.setId(id);
		e = (Emprestimo) _dao.listByPrimaryKey(e.getClass(), e.getPrimaryKey());
		// assert
		assertNull(e);
		
	}

	@Test
	public void update_ValidArg_UpdateRecordInDatabase() {
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
		_dao.update(e);
		Emprestimo e2 = (Emprestimo) _dao.listByObject(e);
		
		// assert
		assertEquals(e.toString(),e2.toString());
	}
}
