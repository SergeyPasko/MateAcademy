package teacher.helper.randomizer;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author spasko
 */
public class MainRandomizer {
	private static final String DAY = "day";
	private static final String FILE_PATH = "src/main/resources/teacher/helper/randomizer/data.json";

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		List<Integer> ignored = Arrays.asList(0, 2, 7);

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Integer> dataMap = mapper.readValue(new File(FILE_PATH), HashMap.class);

		int currentDayOfmonth = LocalDate.now().getDayOfMonth();
		if (dataMap.get(DAY) != currentDayOfmonth) {
			dataMap.clear();
			Arrays.stream(StudentEnum.values()).forEach(k -> dataMap.put(k.getNumber()+"", 0));
			dataMap.put(DAY, currentDayOfmonth);
		}
		int maxValue = dataMap.entrySet().stream()
				.filter(map -> !map.getKey().equals(DAY) && !ignored.contains(Integer.valueOf(map.getKey())))
				.mapToInt(map -> map.getValue()).max().getAsInt();
		int minValue = dataMap.entrySet().stream()
				.filter(map -> !map.getKey().equals(DAY) && !ignored.contains(Integer.valueOf(map.getKey())))
				.mapToInt(map -> map.getValue()).min().getAsInt();
		Random r = new Random();
		int result = 0;
		while (ignored.contains(result) || (minValue < maxValue && dataMap.get(result + "") == maxValue)) {
			result = r.nextInt(StudentEnum.values().length) + 1;
		}
		dataMap.put(result + "", dataMap.get(result + "") + 1);
		mapper.writeValue(new File(FILE_PATH), dataMap);
		System.out.println(StudentEnum.getName(result));
	}
}
