package lesson19.spring.intro.entity;

import org.springframework.stereotype.Component;

/**
 * @author spasko
 */
@Component("dog")
public class Dog extends AbstractAnimal {

	@Override
	public String getVoice() {
		return "Gav-gav";
	}

}
