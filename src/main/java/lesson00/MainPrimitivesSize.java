package lesson00;

/**
 * @author spasko
 */
public class MainPrimitivesSize {
	public static void main(String[] args) {
		int intNumber = 127;
		byte byteNumber = (byte) intNumber;
		int addNumber=13;

		System.out.println("Before integer " + Integer.toBinaryString(intNumber));
		System.out.println("Before byte " + byteToBinaryString(byteNumber));

		intNumber += addNumber;
		byteNumber += addNumber;

		System.out.println("after integer " + Integer.toBinaryString(intNumber));
		System.out.println("after byte " + byteToBinaryString(byteNumber));
		
		System.out.println("Result integer "+intNumber);
		System.out.println("Result byte "+byteNumber);
		
		//System.out.println(((Object)(5/2)).getClass().getName());
		
		//int number=6;
		//System.out.println(new Integer(number)==(Integer)number);
	}

	static String byteToBinaryString(byte b) {
		return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
	}

}
