package project.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import project.external.SomeBean;

@Component
public class SomeBeanFromFactory {

    @Bean(destroyMethod = "quit", name = "someBean")
    public SomeBean someBean() {
	return new SomeBean();
    }
}
