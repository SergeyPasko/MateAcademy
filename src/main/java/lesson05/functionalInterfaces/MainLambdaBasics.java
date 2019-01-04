package lesson05.functionalInterfaces;

/**
 * @author spasko
 */
public class MainLambdaBasics {
	public static void main(String[] args) {
		TestInterface<Integer, String> testInterface = new TestInterface<Integer, String>() {
			@Override
			public String doSome(Integer t) {
				return "Number1: " + t;
			}
		};
		System.out.println(testInterface.doSome(123));

		testInterface = (Integer i) -> "Number2: " + i;
		System.out.println(testInterface.doSome(123));

		testInterface = (i) -> "Number3: " + i;
		System.out.println(testInterface.doSome(123));

		testInterface = i -> "Number4: " + i;
		System.out.println(testInterface.doSome(123));

		testInterface = i -> "Number5 dont use param ";
		System.out.println(testInterface.doSome(123));

		testInterface = i -> i.toString();
		System.out.println(testInterface.doSome(123));

		// testInterface = Integer::toString;
		testInterface = i -> ((Object) i).toString();
		System.out.println(testInterface.doSome(234));

		testInterface = Object::toString;
		System.out.println(testInterface.doSome(234));
	}
}
