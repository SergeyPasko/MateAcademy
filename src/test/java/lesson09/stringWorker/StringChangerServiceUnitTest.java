package lesson09.stringWorker;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import lesson09.junit.stringWorker.StringChangerService;
import lesson09.junit.stringWorker.StringLowerUpperService;

/**
 * @author spasko
 */
public class StringChangerServiceUnitTest {
	private StringChangerService stringChangerService;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("BeforeClass MainJunitTest.class");
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("AfterClass MainJunitTest.class");
	}

	@Before
	public void initTest() {
		System.out.println("Before MainJunitTest.class");
		StringLowerUpperService lowerUpperService = new StringLowerUpperService();
		stringChangerService = new StringChangerService(lowerUpperService);
	}

	@After
	public void afterTest() {
		System.out.println("After MainJunitTest.class");
	}

	@Test
	public void testAddEnd() {
		String expected = "MainStrEndString";
		String actual = stringChangerService.addEnd("EndString", "MainStr");
		assertEquals(expected, actual);
	}

	@Test
	public void testAddEndWhenInputNull() {
		String expected = "nullEndString";
		String actual = stringChangerService.addEnd("EndString", null);
		assertEquals(expected, actual);
	}

	@Test
	public void testAddEndWhenEndNull() {
		String expected = "MainStrnull";
		String actual = stringChangerService.addEnd(null, "MainStr");
		assertEquals(expected, actual);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddEndWhenEndEqualsInput() {
		stringChangerService.addEnd("string", "string");
	}

	// ...all others tests
}
