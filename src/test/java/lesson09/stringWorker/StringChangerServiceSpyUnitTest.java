package lesson09.stringWorker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import lesson09.junit.stringWorker.StringChangerService;
import lesson09.junit.stringWorker.StringLowerUpperService;

/**
 * @author spasko
 */
@SuppressWarnings("unused")
@RunWith(MockitoJUnitRunner.class)
public class StringChangerServiceSpyUnitTest {
	@Spy
	@InjectMocks
	private StringChangerService stringChangerService;
	@Mock
	private StringLowerUpperService lowerUpperService;

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

	@Test
	public void testAddStartUpperInputLower() {
		when(lowerUpperService.toLower(Mockito.anyString())).thenReturn("lovervalue");
		// doReturn("lovervalue").when(lowerUpperService).toLower(Mockito.anyString());
		when(lowerUpperService.toUpper(Mockito.anyString())).thenReturn("UPPERVALUE");
		String expected = "UPPERVALUElovervalue";
		String actual = stringChangerService.addStartUpperInputLower("some", "some");
		assertEquals(expected, actual);
	}

	@Test(expected = NullPointerException.class)
	public void testAddStartUpperInputLowerWhenStartNull() {
		when(lowerUpperService.toUpper(null)).thenThrow(new NullPointerException());
		stringChangerService.addStartUpperInputLower(null, "some");
	}

	// It is the unittest
	@Test
	public void testAddStartAndEndTotalLower() {
		doReturn("sTArtINput").when(stringChangerService).addStart("sTArt", "INput");
		stringChangerService.addStartAndEndTotalLower("sTArt", "eNd", "INput");
		verify(lowerUpperService).toLower("sTArtINputeNd");
	}

	@Test
	public void testAddStartAndEnd() {
		String expected = "sTArtINputeNd";
		doReturn("sTArtINput").when(stringChangerService).addStart("sTArt", "INput");
		String actual = stringChangerService.addStartAndEnd("sTArt", "eNd", "INput");
		assertTrue(expected.equals(actual));
	}

	// ...all others tests
}
