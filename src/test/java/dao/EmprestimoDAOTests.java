package dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.transacao.EmprestimoDAO;
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
		Emprestimo e = new Emprestimo(id, numeroConta, valorTransacao, dataTransacao);

		// act
		_dao.add(e);

		Emprestimo e2 = (Emprestimo) _dao.listByObject(e);

		// assert
		assertEquals(e.toString(), e2.toString());
	}
}
