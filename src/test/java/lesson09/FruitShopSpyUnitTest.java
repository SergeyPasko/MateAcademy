package lesson09;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import lesson09.junit.Fruit;
import lesson09.junit.FruitShop;
import lesson09.junit.FruitType;

/**
 * @author spasko
 */
@RunWith(MockitoJUnitRunner.class)
public class FruitShopSpyUnitTest {
	@Spy
	@InjectMocks
	private FruitShop fruitShop;
	@Mock
	private List<Fruit> fruits;
	@Mock
	private Fruit apple;
	@Mock
	private Fruit pear;
	@Mock
	private Fruit strawberry;
	@Mock
	private Fruit orange;

	@Before
	public void setUp() {
		createFruitMock(apple, LocalDate.of(2019, Month.JANUARY, 10), 50);
		createFruitMock(pear, LocalDate.of(2019, Month.JANUARY, 11), 40);
		createFruitMock(strawberry, LocalDate.of(2018, Month.DECEMBER, 29), 10);
		createFruitMock(orange, LocalDate.of(2018, Month.DECEMBER, 1), 50);
		when(fruitShop.getFruits()).thenReturn(Arrays.asList(new Fruit[] { apple, pear, strawberry, orange }));
	}

	private void createFruitMock(Fruit fruit, LocalDate date, int timeTolive) {
		when(fruit.getDeliveryDate()).thenReturn(date);
		when(fruit.getDayToLive()).thenReturn(timeTolive);
		when(fruit.clone()).thenReturn(fruit);
	}

	@Test
	public void testAllFresh() {
		List<Fruit> expected = new ArrayList<>();
		expected.add(apple);
		List<Fruit> actual = fruitShop.allFresh(LocalDate.of(2019, Month.FEBRUARY, 28));

		verify(apple, times(1)).clone();
		assertEquals(expected, actual);
	}

	@Test
	public void testAllFreshAndFruitType() {
		doReturn(Arrays.asList(orange)).when(fruitShop).allFruitOfFruitType(FruitType.ORANGE);
		// when(fruitShop.allFruitOfFruitType(FruitType.ORANGE)).thenReturn(Arrays.asList(orange));
		List<Fruit> expected = new ArrayList<>();
		expected.add(orange);
		List<Fruit> actual = fruitShop.allFreshAndFruitType(FruitType.ORANGE, LocalDate.of(2019, Month.JANUARY, 12));

		assertEquals(expected, actual);
	}

	// ...all others tests
}
