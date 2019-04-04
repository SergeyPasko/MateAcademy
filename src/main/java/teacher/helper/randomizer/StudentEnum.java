package teacher.helper.randomizer;

import java.util.Arrays;

/**
 * @author spasko
 */
public enum StudentEnum {
	S1(1, "Artem Lemeshko"), S2(2, "Sergii Klunnyi"), S3(3, "Yuriy Cherkashyn"), S4(4, "Vadim Chumasov"),
	S5(5, "Oleksandr Dadizha"), S6(6, "Tetiana Pedchenko"), S7(7, "Tetiana Nebesna"), S8(8, "Maria Kharkhuta"),
	S9(9, "Illia Polianskyi"), S10(10, "Rostyslav Danylo");
	private int number;
	private String name;

	private StudentEnum(int number, String name) {
		this.number = number;
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public static String getName(int number) {
		return Arrays.stream(values()).filter(st -> st.number == number).findFirst().get().name;
	}
}
