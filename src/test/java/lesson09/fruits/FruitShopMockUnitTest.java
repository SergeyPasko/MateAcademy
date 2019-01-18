package lesson09.fruits;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import lesson09.junit.fruits.Fruit;
import lesson09.junit.fruits.FruitShop;

/**
 * @author spasko
 */
@RunWith(MockitoJUnitRunner.class)
public class FruitShopMockUnitTest {
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

		when(fruits.stream()).thenReturn(Stream.of(apple, pear, strawberry, orange));
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

	// ...all others tests
}
