package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import contract.controllers.IContaController;
import model.conta.ContaCorrente;
import model.conta.ContaPoupanca;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaControllerTests {

	private IContaController _contaController = new ContaController();

	@BeforeClass
	public static void setUp() {
		System.out.println("Iniciando Conta Controller tests...");
	}

	@AfterClass
	public static void tearDown() {
		System.out.println("Finalizando Conta Controller tests...");
	}

	/*
	 * CONTA CORRENTE
	 */

	@Test
	public void _01_addContaCorrente_ValidArg_AddToDatabase() {
		// arrange
		ContaCorrente contaCorrente = new ContaCorrente();
		contaCorrente.setId(12);
		contaCorrente.setNumeroConta(12);
		contaCorrente.setSaldo(150.0);
		contaCorrente.setSituacao("a");

		contaCorrente.setPessoa(null);
		contaCorrente.setTransacoes(null);

		// act
		_contaController.addContaCorrente(contaCorrente);

		ContaCorrente contaCorrente2 = _contaController.listContaCorrente(contaCorrente);

		// assert
		assertEquals(contaCorrente.toString(), contaCorrente2.toString());
	}

	@Test
	public void _02_listContaCorrente_ValidArg_ReturnValidRecord() {
		// arrange
		ContaCorrente contaCorrente = new ContaCorrente();
		contaCorrente.setId(12);

		// act
		ContaCorrente contaCorrente2 = _contaController.listContaCorrente(contaCorrente);

		// assert
		assertEquals(contaCorrente.toString(), contaCorrente2.toString());

	}

	@Test
	public void _03_listAllContaCorrente_ValidArg_ReturnAllRecordsFromDatabase() {
		// arrange
		ContaCorrente contaCorrente = new ContaCorrente();

		// act
		ArrayList<ContaCorrente> list = (ArrayList<ContaCorrente>) _contaController.listAllContaCorrente(contaCorrente);

		// assert
		assertTrue(list.size() > 1);
	}

	@Test
	public void _04_updateContaCorrente_ValidArg_UpdateRecordInDatabase() {
		// arrange
		ContaCorrente contaCorrente = new ContaCorrente();
		contaCorrente.setNumeroConta(12);
		contaCorrente = _contaController.listContaCorrente(contaCorrente);

		contaCorrente.setSaldo(50.5);
		ContaCorrente contaCorrente2 = contaCorrente;

		// act
		_contaController.updateContaCorrente(contaCorrente);

		contaCorrente = _contaController.listContaCorrente(contaCorrente2);

		// assert
		assertEquals(contaCorrente.toString(), contaCorrente2.toString());

	}

	@Test
	public void _05_removeContaCorrente_ValidArg_RemoveRecordFromDatabase() {
		// arrange
		ContaCorrente contaCorrente = new ContaCorrente();
		contaCorrente.setNumeroConta(12);
		contaCorrente = _contaController.listContaCorrente(contaCorrente);

		// act
		_contaController.removeContaCorrente(contaCorrente);

		ContaCorrente contaCorrente2 = _contaController.listContaCorrente(contaCorrente);

		// assert
		assertNull(contaCorrente2);

	}

	/*
	 * CONTA POUPANÇA
	 */

	@Test
	public void _06_addContaPoupanca_ValidArg_AddToDatabase() {
		// arrange
		ContaPoupanca contaPoupanca = new ContaPoupanca();
		contaPoupanca.setId(13);
		contaPoupanca.setNumeroConta(13);
		contaPoupanca.setSaldo(177.0);
		contaPoupanca.setSituacao("a");

		contaPoupanca.setPessoa(null);
		contaPoupanca.setTransacoes(null);

		// act
		_contaController.addContaPoupanca(contaPoupanca);

		ContaPoupanca contaPoupanca2 = _contaController.listContaPoupanca(contaPoupanca);

		// assert
		assertEquals(contaPoupanca.toString(), contaPoupanca2.toString());
	}

	@Test
	public void _07_listContaPoupanca_ValidArg_ReturnValidRecord() {
		// arrange
		ContaPoupanca contaPoupanca = new ContaPoupanca();
		contaPoupanca.setId(13);

		// act
		ContaPoupanca contaPoupanca2 = _contaController.listContaPoupanca(contaPoupanca);

		// assert
		assertEquals(contaPoupanca.toString(), contaPoupanca2.toString());

	}

	@Test
	public void _08_listAllContaPoupanca_ValidArg_ReturnAllRecordsFromDatabase() {
		// arrange
		ContaPoupanca contaPoupanca = new ContaPoupanca();

		// act
		ArrayList<ContaPoupanca> list = (ArrayList<ContaPoupanca>) _contaController.listAllContaPoupanca(contaPoupanca);

		// assert
		assertTrue(list.size() > 1);
	}

	@Test
	public void _09_updateContaPoupanca_ValidArg_UpdateRecordInDatabase() {
		// arrange
		ContaPoupanca contaPoupanca = new ContaPoupanca();
		contaPoupanca.setNumeroConta(13);
		contaPoupanca = _contaController.listContaPoupanca(contaPoupanca);

		contaPoupanca.setSaldo(225.8);
		ContaPoupanca contaPoupanca2 = contaPoupanca;

		// act
		_contaController.updateContaPoupanca(contaPoupanca);

		contaPoupanca = _contaController.listContaPoupanca(contaPoupanca2);

		// assert
		assertEquals(contaPoupanca.toString(), contaPoupanca2.toString());

	}

	@Test
	public void _10_removeContaPoupanca_ValidArg_RemoveRecordFromDatabase() {
		// arrange
		ContaPoupanca contaPoupanca = new ContaPoupanca();
		contaPoupanca.setNumeroConta(12);
		contaPoupanca = _contaController.listContaPoupanca(contaPoupanca);

		// act
		_contaController.removeContaPoupanca(contaPoupanca);

		ContaPoupanca contaPoupanca2 = _contaController.listContaPoupanca(contaPoupanca);

		// assert
		assertNull(contaPoupanca2);

	}

}
