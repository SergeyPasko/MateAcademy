package lesson19.spring.intro.entity;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author spasko
 */
@Component
@Primary
public class Cat extends AbstractAnimal {

	@Override
	public String getVoice() {
		return "Mur-mur";
	}

}
