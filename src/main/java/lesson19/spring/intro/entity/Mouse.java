package lesson19.spring.intro.entity;

import org.springframework.stereotype.Component;

/**
 * @author spasko
 */
@Component("mouse")
public class Mouse extends AbstractAnimal {

	@Override
	public String getVoice() {
		return "Pi-pi";
	}

}
