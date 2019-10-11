package suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import general.LoggerTests;

@RunWith(Suite.class)
@SuiteClasses({
	SuiteDAOTests.class,
	LoggerTests.class
})
public class SuiteAllTests {

	@BeforeClass
	public static void setUp() {
		System.out.println("Starting All Unit Tests...");
	}
	
	@AfterClass
	public static void tearDown() {
		System.out.println("Finishing All Unit Tests...");
	}
}
