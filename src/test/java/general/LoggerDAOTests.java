package general;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import util.LoggerDAO;
import util.MyStrings;

public class LoggerDAOTests {

	private static LoggerDAO _logger;
	private Stream<String> stream;
	
	@BeforeClass
	public static void setUp() {
		System.out.println("Iniciando Logger testes...");
		_logger = new LoggerDAO();
	}
	
	@AfterClass
	public static void tearDown() {
		System.out.println("Finalizando Logger testes...");
	}
	
	@Test
	public void log_ValidErrorMessage_WriteToLoggerFile() throws IOException {
		// arrange
		String message = "Mensagem logger teste";
		
		// act
		_logger.log(message);
		
		StringBuilder contentBuilder = new StringBuilder();
		
		stream = Files.lines(Paths.get(MyStrings.LOGGER_SOURCE_FILE), StandardCharsets.UTF_8);
		
		stream.forEach(s -> contentBuilder.append(s));
		
		// assert
		assertEquals(message, contentBuilder.toString().substring(contentBuilder.toString().indexOf(message.charAt(0))));
	}
}
