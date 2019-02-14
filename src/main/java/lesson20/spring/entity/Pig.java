package lesson20.spring.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author spasko
 */
@Component
@PropertySource({ "classpath:lesson20/pig.properties" })
public class Pig {
	@Value("${voice}")
	private String voice;

	public String getVoice() {
		return voice;
	}

	public String toString() {
		return "Pig say " + getVoice();
	}
}
