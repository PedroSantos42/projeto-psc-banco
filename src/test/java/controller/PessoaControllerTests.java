package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import contract.controllers.IPessoaController;
import model.Endereco;
import model.pessoa.Cliente;
import model.pessoa.Funcionario;

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
		cliente.setDataCadastro(new Date());
		
		Endereco endereco = new Endereco();
		endereco.setLogradouro("logradouro 70");
		endereco.setComplemento("complemento 70");
		endereco.setBairro("bairro 70");
		endereco.setCidade("cidade 70");
		endereco.setUf("uf 70");
		endereco.setCep("cep 70");
		
		cliente.setEndereco(endereco);
		
		// act
		_pessoaController.addCliente(cliente);
		
		Cliente cliente2 = _pessoaController.listCliente(cliente);
		
		// assert
		assertEquals(cliente.toString(), cliente2.toString());
	}
	
	@Test
	public void _02_listCliente_ValidArg_ReturnValidRecord() {
		// arrange
		Cliente cliente = new Cliente();
		cliente.setId(12);
		cliente.setCpf("cpf 12");
		
		// act
		Cliente cliente2 = _pessoaController.listCliente(cliente);
		
		// assert
		assertEquals(cliente.toString(), cliente2.toString());
	}
	
	@Test
	public void _03_listAllCliente_ValidArg_ReturnAllRecordsFromDatabase() {
		// arrange
		Cliente cliente = new Cliente();
		
		// act
		ArrayList<Cliente> list = (ArrayList<Cliente>) _pessoaController.listAllCliente(cliente);
		
		// assert
		assertTrue(list.size() > 1);
	}
	
	@Test
	public void _04_updateCliente_ValidArg_UpdateRecordInDatabase() {
		// arrange
		Cliente cliente = new Cliente();
		cliente.setId(12);
		cliente = _pessoaController.listCliente(cliente);
		
		cliente.setNome(cliente.getNome() + " atualizado");
		Cliente cliente2 = cliente;
		
		// act
		_pessoaController.updateCliente(cliente);
		
		cliente = _pessoaController.listCliente(cliente2);
		
		// assert
		assertEquals(cliente.toString(), cliente2.toString());
	}
	
	@Test
	public void _05_removeCliente_ValidArg_RemoveRecordFromDatabase() {
		// arrange
		Cliente cliente = new Cliente();
		cliente.setId(12);
		cliente = _pessoaController.listCliente(cliente);

		// act
		_pessoaController.removeCliente(cliente);
		
		Cliente cliente2 = _pessoaController.listCliente(cliente);
		
		// assert
		assertNull(cliente2);
	}

	/*
	* FUNCIONARIO
	*/
	
	@Test
	public void _06_addFuncionario_ValidArg_AddToDatabase() {
		// arrange
		Funcionario funcionario = new Funcionario();
		funcionario.setId(12);
		funcionario.setCpf("cpf 12");
		funcionario.setNome("nome 12");
		funcionario.setDataNascimento(new Date());
		funcionario.setDataContratacao(new Date());

		Endereco endereco = new Endereco();
		endereco.setLogradouro("logradouro 70");
		endereco.setComplemento("complemento 70");
		endereco.setBairro("bairro 70");
		endereco.setCidade("cidade 70");
		endereco.setUf("uf 70");
		endereco.setCep("cep 70");

		funcionario.setEndereco(endereco);

		// act
		_pessoaController.addFuncionario(funcionario);

		Funcionario funcionario2 = _pessoaController.listFuncionario(funcionario);

		// assert
		assertEquals(funcionario.toString(), funcionario2.toString());
	}
	
	@Test
	public void _07_listFuncionario_ValidArg_ReturnValidRecord() {
		// arrange
		Funcionario funcionario = new Funcionario();
		funcionario.setId(12);
		funcionario.setCpf("cpf 12");

		// act
		Funcionario funcionario2 = _pessoaController.listFuncionario(funcionario);

		// assert
		assertEquals(funcionario.toString(), funcionario2.toString());
	}
	
	@Test
	public void _08_listAllFuncionario_ValidArg_ReturnAllRecordsFromDatabase() {
		// arrange
		Funcionario funcionario = new Funcionario();
		
		// act
		ArrayList<Funcionario> list = (ArrayList<Funcionario>) _pessoaController.listAllFuncionario(funcionario);
		
		// assert
		assertTrue(list.size() > 1);
	}
	
	@Test
	public void _09_updateFuncionario_ValidArg_UpdateRecordInDatabase() {
		// arrange
		Funcionario funcionario = new Funcionario();
		funcionario.setId(12);
		funcionario = _pessoaController.listFuncionario(funcionario);
		
		funcionario.setNome(funcionario.getNome() + " atualizado");
		Funcionario funcionario2 = funcionario;
		
		// act
		_pessoaController.updateFuncionario(funcionario);
		
		funcionario = _pessoaController.listFuncionario(funcionario2);
		
		// assert
		assertEquals(funcionario.toString(), funcionario2.toString());
	}
	
	@Test
	public void _10_removeFuncionario_ValidArg_RemoveRecordFromDatabase() {
		// arrange
		Funcionario funcionario = new Funcionario();
		funcionario.setId(12);
		funcionario = _pessoaController.listFuncionario(funcionario);

		// act
		_pessoaController.removeFuncionario(funcionario);
		
		Funcionario funcionario2 = _pessoaController.listFuncionario(funcionario);
		
		// assert
		assertNull(funcionario2);
	}
}
