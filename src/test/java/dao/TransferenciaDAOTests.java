package dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.transacao.TransferenciaDAO;
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
		Transferencia t = new Transferencia(id, numeroConta, valorTransacao, dataTransacao);

		// act
		_dao.add(t);

		Transferencia t2 = (Transferencia) _dao.listByObject(t);

		// assert
		assertEquals(t.toString(), t2.toString());
	}
}
