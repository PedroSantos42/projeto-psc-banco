package controller;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import contract.controllers.IPessoaController;
import dao.EnderecoDAO;
import model.Endereco;
import model.pessoa.Cliente;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PessoaControllerTests {

	private IPessoaController _pessoaController = new PessoaController();
	
	@BeforeClass
	public static void setUp() {
		System.out.println("Iniciando Pessoa Controller tests...");
	}
	
	@AfterClass
	public static void tearDown() {
		System.out.println("Finalizando Pessoa Controller tests...");
	}
	
	@Test
	public void _01_addCliente_ValidArg_AddToDatabase() {
		// arrange
		Cliente cliente = new Cliente();
		cliente.setId(12);
		cliente.setCpf("cpf 12");
		cliente.setNome("nome 12");
		cliente.setDataNascimento(new Date());
		Endereco[] e = (Endereco[]) new EnderecoDAO().listAllEndereco(new Endereco()).toArray();
		cliente.setEndereco(e[0]);
		
		// act
		_pessoaController.addCliente(cliente);
		
		Cliente cliente2 = _pessoaController.listCliente(cliente);
		
		// assert
		assertEquals(cliente.toString(), cliente2.toString());
	}
	
	@Ignore
	@Test
	public void _02_listCliente_ValidArg_ReturnValidRecord() {
		// arrange
		
		// act
		
		// assert
	}
	
	@Ignore
	@Test
	public void _03_listAllCliente_ValidArg_ReturnAllRecordsFromDatabase() {
		// arrange
		
		// act
		
		// assert
	}
	
	@Ignore
	@Test
	public void _04_updateCliente_ValidArg_UpdateRecordInDatabase() {
		// arrange
		
		// act
		
		// assert
	}
	
	@Ignore
	@Test
	public void _05_updateCliente_ValidArg_RemoveRecordFromDatabase() {
		// arrange
		
		// act
		
		// assert
	}

	/*
	* FUNCIONARIO
	*/
	
	@Ignore
	@Test
	public void _06_addFuncionario_ValidArg_AddToDatabase() {
		// arrange
		
		// act
		
		// assert
	}
	
	@Ignore
	@Test
	public void _07_listFuncionario_ValidArg_ReturnValidRecord() {
		// arrange
		
		// act
		
		// assert
	}
	
	@Ignore
	@Test
	public void _08_listAllFuncionario_ValidArg_ReturnAllRecordsFromDatabase() {
		// arrange
		
		// act
		
		// assert
	}
	
	@Ignore
	@Test
	public void _09_updateFuncionario_ValidArg_UpdateRecordInDatabase() {
		// arrange
		
		// act
		
		// assert
	}
	
	@Ignore
	@Test
	public void _10_updateFuncionario_ValidArg_RemoveRecordFromDatabase() {
		// arrange
		
		// act
		
		// assert
	}
}
