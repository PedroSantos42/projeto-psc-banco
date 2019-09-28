package suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import dao.EnderecoDAOTests;
import util.UtilJPA;
import dao.ClienteDAOTests;;

@RunWith(Suite.class)
@SuiteClasses({
	EnderecoDAOTests.class,
	ClienteDAOTests.class
	})
public class SuiteDAOTests {

	@BeforeClass
	public static void setUp() {
		System.out.println("Starting DAO Suite Tests...");
	}

	@AfterClass
	public static void tearDown() {
		System.out.println("Finishing DAO Suite Tests...");
//		UtilJPA.closeEntityManagerFactory();
	}
}
