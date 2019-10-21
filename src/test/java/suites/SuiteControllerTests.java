package suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import controller.PessoaControllerTests;

@RunWith(Suite.class)
@SuiteClasses({
	PessoaControllerTests.class
})
public class SuiteControllerTests {

	@BeforeClass
	public static void setUp() {
		System.out.println("Starting Controllers Tests...");
	}
	
	@AfterClass
	public static void tearDown() {
		System.out.println("Finishing Controllers Tests...");
	}
}
