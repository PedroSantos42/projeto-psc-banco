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

import contract.controllers.ITransacaoController;
import controller.TransacaoController;
import model.transacao.Emprestimo;
import model.transacao.Transferencia;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransacaoControllerTests {
	
	private ITransacaoController _transacaoController = new TransacaoController();

	@BeforeClass
	public static void setUp() {
		System.out.println("Iniciando Conta Controller tests...");
	}

	@AfterClass
	public static void tearDown() {
		System.out.println("Finalizando Conta Controller tests...");
	}

	/* 
	 * EMPRESTIMO
	 */
	
	@Test
	public void _01_addEmprestimo_ValidArg_AddToDatabase() {
		// arrange
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setId(15);
		emprestimo.setNumeroConta(15);
		emprestimo.setValorTransacao(150);
		emprestimo.setDataTransacao(new Date());

		emprestimo.setConta(null);

		// act
		_transacaoController.addEmprestimo(emprestimo);

		Emprestimo emprestimo2 = _transacaoController.listEmprestimo(emprestimo);

		// assert
		assertEquals(emprestimo.toString(),emprestimo2.toString());
		
	}

	@Test
	public void _02_listEmprestimo_ValidArg_ReturnValidRecord() {
		// arrange
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setId(15);

		// act
		Emprestimo emprestimo2 = _transacaoController.listEmprestimo(emprestimo);

		// assert
		assertEquals(emprestimo.toString(), emprestimo2.toString());

	}

	@Test
	public void _03_listAllEmprestimo_ValidArg_ReturnAllRecordsFromDatabase() {
		// arrange
		Emprestimo emprestimo = new Emprestimo();

		// act
		ArrayList<Emprestimo> list = (ArrayList<Emprestimo>) _transacaoController.listAllEmprestimo(emprestimo);

		// assert
		assertTrue(list.size() > 1);
	}

	@Test
	public void _04_updateEmprestimo_ValidArg_UpdateRecordInDatabase() {
		// arrange
		Emprestimo emprestimo = new Emprestimo ();
		emprestimo.setNumeroConta(15);
		emprestimo = _transacaoController.listEmprestimo(emprestimo);

		emprestimo.setValorTransacao(150);
		Emprestimo emprestimo2 = new Emprestimo();

		// act
		_transacaoController.updateEmprestimo(emprestimo);

		emprestimo = _transacaoController.listEmprestimo(emprestimo2);

		// assert
		assertEquals(emprestimo.toString(), emprestimo2.toString());

	}

	@Test
	public void _05_removeEmprestimo_ValidArg_RemoveRecordFromDatabase() {
		// arrange
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setNumeroConta(15);
		emprestimo = _transacaoController.listEmprestimo(emprestimo);

		// act
		_transacaoController.removeEmprestimo(emprestimo);

		Emprestimo emprestimo2 = _transacaoController.listEmprestimo(emprestimo);

		// assert
		assertNull(emprestimo2);
		
	}
	
	/*
	 * TRANSFERÊNCIA
	 */
	
	@Test
	public void _06_addTransferencia_ValidArg_AddToDatabase() {
		// arrange
		Transferencia transferencia = new Transferencia();
		transferencia.setId(15);
		transferencia.setNumeroConta(15);
		transferencia.setValorTransacao(150);
		transferencia.setDataTransacao(new Date());

		transferencia.setConta(null);

		// act
		_transacaoController.addTransferencia(transferencia);

		Transferencia transferencia2 = _transacaoController.listTransferencia(transferencia);

		// assert
		assertEquals(transferencia.toString(),transferencia2.toString());
		
	}

	@Test
	public void _07_listTransferencia_ValidArg_ReturnValidRecord() {
		// arrange
		Transferencia transferencia = new Transferencia();
		transferencia.setId(15);

		// act
		Transferencia transferencia2 = _transacaoController.listTransferencia(transferencia);

		// assert
		assertEquals(transferencia.toString(), transferencia2.toString());

	}

	@Test
	public void _08_listAllTransferencia_ValidArg_ReturnAllRecordsFromDatabase() {
		// arrange
		Transferencia transferencia = new Transferencia();

		// act
		ArrayList<Transferencia> list = (ArrayList<Transferencia>) _transacaoController.listAllTransferencia(transferencia);

		// assert
		assertTrue(list.size() > 1);
	}

	@Test
	public void _09_updateTransferencia_ValidArg_UpdateRecordInDatabase() {
		// arrange
		Transferencia transferencia = new Transferencia();
		transferencia.setNumeroConta(15);
		transferencia = _transacaoController.listTransferencia(transferencia);

		transferencia.setValorTransacao(150);
		Transferencia transferencia2 = new Transferencia();

		// act
		_transacaoController.updateTransferencia(transferencia);

		transferencia = _transacaoController.listTransferencia(transferencia2);

		// assert
		assertEquals(transferencia.toString(), transferencia2.toString());

	}

	@Test
	public void _10_removeTransferencia_ValidArg_RemoveRecordFromDatabase() {
		// arrange
		Transferencia transferencia = new Transferencia();
		transferencia.setNumeroConta(15);
		transferencia = _transacaoController.listTransferencia(transferencia);

		// act
		_transacaoController.removeTransferencia(transferencia);

		Transferencia transferencia2 = _transacaoController.listTransferencia(transferencia);

		// assert
		assertNull(transferencia2);
		
	}
	

}
