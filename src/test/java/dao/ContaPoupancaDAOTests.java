package dao;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.conta.ContaPoupancaDAO;
import dao.pessoa.ClienteDAO;
import model.conta.ContaPoupanca;
import model.pessoa.Pessoa;
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
		int id = 3;
		int numeroConta = 2;
		double saldo = 99.0;
		String situacao = "a";
		
		Pessoa p = new Pessoa();
		p.setId(1);
		p = (Pessoa) new ClienteDAO().listByPrimaryKey(p.getClass(), p.getPrimaryKey());
		
		ContaPoupanca conta = new ContaPoupanca(id, numeroConta, saldo, situacao, p, null);
		
		// act
		_dao.add(conta);
		
		ContaPoupanca conta2 = (ContaPoupanca) _dao.listByObject(conta);
		
		// assert
		assertEquals(conta.toString(), conta2.toString());
	}
}
