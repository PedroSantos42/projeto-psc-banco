package dao;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.conta.ContaPoupancaDAO;
import model.conta.ContaPoupanca;
import util.UtilJPA;

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
		int id = 2; 
		int numeroConta = 2;
		double saldo = 99.0;
		String situacao = "a";
		
		ContaPoupanca conta = new ContaPoupanca(id, numeroConta, saldo, situacao);
		
		// act
		_dao.add(conta);
		
		ContaPoupanca conta2 = (ContaPoupanca) _dao.listByObject(conta);
		
		// assert
		assertEquals(conta.toString(), conta2.toString());
	}
}
