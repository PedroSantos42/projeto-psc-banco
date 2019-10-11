package general;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import util.MyLogger;

public class LoggerTests {

	private MyLogger _logger;
	
	@BeforeClass
	public static void setUp() {
		System.out.println("Iniciando Logger testes...");
		MyLogger _logger = new MyLogger();
	}
	
	@AfterClass
	public static void tearDown() {
		System.out.println("Finalizando Logger testes...");
	}
	
	@Test
	public void log_ValidErrorMessage_WriteToLoggerFile() {
		// arrange
		String message = "Mensagem de erro teste";
		
		// act
		
		// assert
	}
	
	@Test
	public void formatDate_ValidDate_ReturnDDMMAAAAFormat() {
		
	}
}
