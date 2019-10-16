package dao;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Endereco;
import util.UtilJPA;

public class EnderecoDAOTests {

	private EnderecoDAO _dao = new EnderecoDAO();
	
	@BeforeClass
	public static void setUp() {
		System.out.println("Iniciando EnderecoDAO testes...");
		UtilJPA.createEntityManagerFactory();
	}
	
	@AfterClass
	public static void tearDown() {
		System.out.println("Finalizando EnderecoDAO testes...");
//		UtilJPA.closeEntityManagerFactory();
	}
	
	@Test
	public void add_ValidArg_AddToDatabase() {
		// arrange
		String logradouro = "Rua 123";
		int numero = 1;
		String complemento = "apto 1";
		String bairro = "Bairro 1";
		String cidade = "Cidade 1";
		String uf = "UF 1";
		String cep = "CEP 1";
		Endereco e = new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep);
		
		// act
		_dao.add(e);
		
		Endereco e2 = (Endereco) _dao.listByObject(e);
		
		// assert
		assertEquals(e.toString(), e2.toString());
	}
	
	@Test
	public void listByObject_ValidArg_ReturnValidRecord() {
		// arrange
		
		// act
		
		// assert
	}
	
	@Test
	public void listByPrimaryKey_ValidArg_ReturnValidRecord() {
		// arrange
		
		// act
		
		// assert
	}
	
	@Test
	public void removeByObject_ValidArg_RemoveRecordFromDatabase() {
		// arrange
		
		// act
		
		// assert
	}
	
	@Test
	public void removeByPrimaryKey_ValidArg_RemoveRecordFromDatabase() {
		// arrange
		
		// act
		
		// assert
	}
	
	@Test
	public void update_ValidArg_UpdateRecordInDatabase() {
		// arrange
		
		// act
		
		// assert
	}
}
