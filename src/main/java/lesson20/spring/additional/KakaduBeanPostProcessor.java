package lesson20.spring.additional;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import lesson20.spring.entity.Kakadu;

/**
 * @author spasko
 */
@Component
public class KakaduBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Kakadu) {
			System.out.println("In postProcessAfterInitialization " + bean);
		}
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Kakadu) {
			System.out.println("In postProcessBeforeInitialization " + bean);
		}
		return bean;
	}

}
