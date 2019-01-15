package lesson09;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import lesson09.junit.Fruit;
import lesson09.junit.FruitShop;
import lesson09.junit.FruitType;

/**
 * @author spasko
 */
public class FruitShopUnitTest {
	private FruitShop fruitShop;
	private static Fruit apple;
	private static Fruit pear;
	private static Fruit strawberry;
	private static Fruit orange;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("BeforeClass MainJunitTest.class");
		apple = new Fruit(FruitType.APPLE, 50, LocalDate.of(2019, Month.JANUARY, 10), 7, null);
		pear = new Fruit(FruitType.PEAR, 40, LocalDate.of(2019, Month.JANUARY, 11), 25, null);
		strawberry = new Fruit(FruitType.STRAWBERRY, 10, LocalDate.of(2018, Month.DECEMBER, 29), 80, null);
		orange = new Fruit(FruitType.ORANGE, 50, LocalDate.of(2018, Month.DECEMBER, 1), 30, null);
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("AfterClass MainJunitTest.class");
	}

	@Before
	public void initTest() {
		System.out.println("Before MainJunitTest.class");
		List<Fruit> fruits = new ArrayList<>();
		fruits.add(apple);
		fruits.add(pear);
		fruits.add(strawberry);
		fruits.add(orange);
		fruitShop = new FruitShop("Our test shop", fruits);
	}

	@After
	public void afterTest() {
		System.out.println("After MainJunitTest.class");
		fruitShop = null;
	}

	@Test
	public void testAllFresh() {
		List<Fruit> expected = new ArrayList<>();
		expected.add(apple);
		List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2019, Month.FEBRUARY, 28));
		assertEquals(expected, actual);
	}

	@Test
	public void testAllFreshShouldBeNothing() {
		List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2099, Month.FEBRUARY, 28));
		assertTrue(actual.size() == 0);
	}

	@Test(expected = NullPointerException.class)
	public void testAllFreshDateNull() {
		fruitShop.allFresh(null);
	}

	@Test
	public void testAllFreshAndFruitType() {
		List<Fruit> expected = new ArrayList<>();
		expected.add(orange);
		List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.ORANGE, LocalDate.of(2019, Month.JANUARY, 12));
		assertEquals(expected, actual);
	}

	@Test
	public void testAllFreshAndFruitTypeShouldBeNothing() {
		List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.PEAR, LocalDate.of(2099, Month.FEBRUARY, 28));
		assertTrue(actual.size() == 0);

		actual = fruitShop.allFreshAndFruitType(null, LocalDate.of(2019, Month.JANUARY, 12));
		assertTrue(actual.size() == 0);
	}

	// ...all others tests
}
